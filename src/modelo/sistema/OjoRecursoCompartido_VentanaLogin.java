package modelo.sistema;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaLogin;

/**
 * Clase que modela un observer del recurso compartido.<br>
 */
public class OjoRecursoCompartido_VentanaLogin implements Observer{
	
	private Observable rc;
	private VentanaLogin ventana;
	private InfoVentana info;
	
	/**
	 * Constructor del observer. Guarda una referencia a su observable y a la ventana a la cual tiene que
	 * informar.<br>
	 * @param rc: observable al cual el ojo observara.<br>
	 * @param ventana: ventana a la cual el ojo enviara mensajes provenientes de su observable.<br>
	 */
	public OjoRecursoCompartido_VentanaLogin(Observable rc, VentanaLogin ventana) {
		this.rc = rc;
		this.rc.addObserver(this);
		this.ventana = ventana;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.rc) {
			this.info = (InfoVentana) arg;
			
			if(this.info.getCliente().equalsIgnoreCase(/*Usuario logeado*/"")) {
				this.ventana.appendLog(this.info.getMensaje());
			}
		}
	}
	

}
