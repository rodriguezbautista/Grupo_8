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
	
	
	public Controlador(IVista vista, VentanaConfiguracionSimulacion vistaConfiguracion) {
		this.modelo=Empresa.getInstance();
		this.vistaLogin = vista;
		this.vistaLogin.setActionListener(this);
		this.vistaConfiguracion = vistaConfiguracion;
		this.vistaConfiguracion.setActionListener(this);
	}
	
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
			//aca hay que vincular el boton de aceptar con el modelo, pasando
			//todos los datos de configuracion al mismo.
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
			this.vistaLogin.habilitarBtnFinalizarPedidos(true);
			this.vistaLogin.habilitarPanelPedidos(true);
			this.vistaLogin.habilitarPanelLogin(false);
		}
	}
}
