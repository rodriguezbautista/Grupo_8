package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.PedidoRechazadoException;
import modelo.sistema.Sistema;
import vista.IVista;

public class Controlador implements ActionListener{
	private IVista vistaGeneral;
	private IVista vistaConfiguracion;
	private Sistema modelo;
	
	
	public Controlador(IVista vista, IVista vistaConfiguracion) {
		this.modelo=Sistema.getInstance();
		this.vistaGeneral = vista;
		this.vistaGeneral.setActionListener(this);
		this.vistaConfiguracion = vistaConfiguracion;
		this.vistaConfiguracion.setActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Finalizar Pedidos")) {
			this.vistaGeneral.deshabilitarBotones();
			this.vistaGeneral.appendLog("------- SOLICITUD DE PEDIDOS FINALIZADA ---------");
			//LOGICA DE RESTAR UNO AL SISTEMA
		}
		else if (e.getActionCommand().equalsIgnoreCase("Solicitar Viaje")) {
			//llamado a getters
			try {
				//envio de datos al modelo
				this.modelo.solicitarViaje(null, 0, null, 0, false, false);
				this.vistaGeneral.limpiarCamposPedido();
				this.vistaGeneral.appendLog("Viaje Solicitado");
			}
			catch(PedidoRechazadoException msj) {
				this.vistaGeneral.appendLog(msj.getMessage());
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("Aceptar")) {
			//aca hay que vincular el boton de aceptar con el modelo, pasando
			//todos los datos de configuracion al mismo.
			this.vistaGeneral.habilitarPanelLogin();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Registrarse")) {
			//aca se vincula el btn de registrarse con el modelo, pasando los datos
			//al mismo y creando otro clienteDTO, agregandolo al hashmap
			this.vistaGeneral.limpiarCamposRegistrarse();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Login")) {
			//aca se crea otro thread
			this.vistaGeneral.limpiarCamposLogin();
			this.vistaGeneral.habilitarBtnFinalizarPedidos();
			this.vistaGeneral.habilitarPanelPedidos();
		}
	}
}
