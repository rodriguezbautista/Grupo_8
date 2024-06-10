package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.CredencialesInvalidasException;
import excepciones.PedidoRechazadoException;
import excepciones.UsuarioExistenteException;
import excepciones.ViajeEnCursoException;
import excepciones.ViajeNoIniciadoException;
import modelo.sistema.Empresa;
import vista.IVista;
import vista.VentanaConfiguracionSimulacion;

public class Controlador implements ActionListener{
	private IVista vistaLogin;
	private VentanaConfiguracionSimulacion vistaConfiguracion;
	private Empresa modelo;
	
	/**
	 * Constructor del controlador. Asigna al mismo las referencias a las ventanas y al modelo.<br>
	 * @param vista: parametro correspondiente a la ventanaLogin.<br>
	 * @param vistaConfiguracion: parametro correspondiente a la ventana de configuracion.<br>
	 * <br> Precondicion: parametro vistaLogin diferente de null.<br>
	 * <br> Precondicion: parametro vistaConfiguracion diferente de null.<br>
	 */
	public Controlador(IVista vistaLogin, VentanaConfiguracionSimulacion vistaConfiguracion) {
		this.modelo=Empresa.getInstance();
		this.vistaLogin = vistaLogin;
		this.vistaLogin.setActionListener(this);
		this.vistaConfiguracion = vistaConfiguracion;
		this.vistaConfiguracion.setActionListener(this);
	}
	
	/**
	 * Metodo que escucha eventos de las ventanas. Se activa al presionar botones en las ventanas.<br> 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Finalizar Pedidos")) {
			this.vistaLogin.deshabilitarBotones();
			this.vistaLogin.appendLog("------- SOLICITUD DE PEDIDOS FINALIZADA ---------");
			//LOGICA DE RESTAR UNO AL SISTEMA
		}
		else if (e.getActionCommand().equalsIgnoreCase("Solicitar Viaje")) {
			int cantidadPersonas = this.vistaLogin.getCantidadPersonas();
			boolean usaBaul = this.vistaLogin.getUsaBaul();
			boolean llevaMascota = this.vistaLogin.getLlevaMascota();
			String zona = this.vistaLogin.getZona();
			
			try {
				//envio de datos al model
				try {
					this.modelo.solicitarViaje(12.0, zona, cantidadPersonas, usaBaul, llevaMascota);
				} catch (ViajeEnCursoException e1) {
					this.vistaLogin.appendLog(e1.getMessage());
				}
				this.vistaLogin.limpiarCamposPedido();
			}
			catch(PedidoRechazadoException msj) {
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Pagar Viaje")) {
			try {
				this.modelo.pagarViaje();
			} catch (ViajeNoIniciadoException e1) {
				this.vistaLogin.appendLog(e1.getMessage());
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("Aceptar")) {
			if(this.vistaConfiguracion.getTipoConfiguracion() == "Configuracion existente") {
				this.modelo.setConfiguracion(null);
			}else {
				this.modelo.setConfiguracion(this.vistaConfiguracion.getConfiguracion());
			}
			
			this.modelo.iniciarSimulacion();
			this.vistaConfiguracion.setVisible(false);
			this.vistaLogin.setVisible(true);			
			this.vistaLogin.habilitarPanelLogin(true);
		}
		else if(e.getActionCommand().equalsIgnoreCase("Registrarse")) {
			String nombre = this.vistaLogin.getNombreRegistrado();
			String usuario = this.vistaLogin.getUsuarioRegistrado();
			String contrasenia = this.vistaLogin.getContraseniaRegistrado();
			try {
				this.modelo.registrarCliente(nombre, usuario, contrasenia);
				this.vistaLogin.limpiarCamposRegistrarse();
				this.vistaLogin.habilitarBtnFinalizarPedidos(true);
				this.vistaLogin.habilitarPanelPedidos(true);
				this.vistaLogin.habilitarPanelLogin(false);
			} catch (UsuarioExistenteException e1) {
			};
		}
		else if(e.getActionCommand().equalsIgnoreCase("Login")) {
			String usuario = this.vistaLogin.getUsuarioLogeado();
			String contrasenia = this.vistaLogin.getContraseniaLogeado();
			try {
				this.modelo.logearCliente(usuario, contrasenia);
				this.vistaLogin.limpiarCamposLogin();
				this.vistaLogin.habilitarPanelLogin(false);
				this.vistaLogin.habilitarPanelPedidos(true);
				this.vistaLogin.habilitarBtnFinalizarPedidos(true);
			} catch (CredencialesInvalidasException e1) {
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Persistir")) {
			this.modelo.persistir();
			this.modelo.finalizarPrograma();
		}
	}
}
