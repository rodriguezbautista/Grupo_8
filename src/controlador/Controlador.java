package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.PedidoRechazadoException;
import modelo.sistema.Empresa;
import modelo.usuario.ClienteThreadLogeado;
import modelo.viaje.SubsistemaViaje;
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
				this.modelo.solicitarViaje(12.0, zona, cantidadPersonas, usaBaul, llevaMascota);
				this.vistaLogin.limpiarCamposPedido();
				this.vistaLogin.appendLog("Viaje Solicitado");
			}
			catch(PedidoRechazadoException msj) {
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
			//aca se vincula el btn de registrarse con el modelo, pasando los datos
			//al mismo y creando otro clienteDTO, agregandolo al hashmap
			this.vistaLogin.limpiarCamposRegistrarse();
			this.vistaLogin.habilitarBtnFinalizarPedidos(true);
			this.vistaLogin.habilitarPanelPedidos(true);
			this.vistaLogin.habilitarPanelLogin(false);
		}
		else if(e.getActionCommand().equalsIgnoreCase("Login")) {
			//aca se crea otro thread
			this.vistaLogin.limpiarCamposLogin();
			this.vistaLogin.habilitarPanelLogin(false);
			this.vistaLogin.habilitarPanelPedidos(true);
			this.vistaLogin.habilitarBtnFinalizarPedidos(true);
		}
	}
}
