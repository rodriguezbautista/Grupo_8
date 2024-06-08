package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.PedidoRechazadoException;
import modelo.sistema.Sistema;
import vista.IVista;

public class Controlador implements ActionListener{
	private IVista vistaLogin;
	private IVista vistaConfiguracion;
	private Sistema modelo;
	
	
	public Controlador(IVista vista, IVista vistaConfiguracion) {
		this.modelo=Sistema.getInstance();
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
			//llamado a getters
			try {
				//envio de datos al modelo
				this.modelo.solicitarViaje(null, 0, null, 0, false, false);
				this.vistaLogin.limpiarCamposPedido();
				this.vistaLogin.appendLog("Viaje Solicitado");
			}
			catch(PedidoRechazadoException msj) {
				this.vistaLogin.appendLog(msj.getMessage());
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
			this.vistaLogin.habilitarPanelPedidos(true);;
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
