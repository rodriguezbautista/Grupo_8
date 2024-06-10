package modelo.sistema;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaGeneral;

/**
 * Clase que modela un observer del recurso compartido.<br>
 */
public class OjoRecursoCompartido_VentanaGeneral implements Observer{

	private Observable rc;
	private VentanaGeneral ventana;
	private InfoVentana info;
	
	/**
	 * Constructor del observer. Guarda una referencia a su observable y a la ventana a la cual tiene que
	 * informar.<br>
	 * @param rc: observable al cual el ojo observara.<br>
	 * @param ventana: ventana a la cual el ojo enviara mensajes provenientes de su observable.<br>
	 */
	public OjoRecursoCompartido_VentanaGeneral(Observable  rc, VentanaGeneral ventana) {
		this.rc = rc;
		this.ventana = ventana;
		this.rc.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.rc) {
			this.info = (InfoVentana) arg;
			
			this.ventana.appendTextGeneral(this.info.getMensaje());//muentra en el campo de texto general
			if(this.info.getChofer().equalsIgnoreCase("Chofer 1")) {
				 this.ventana.appendTextChofer(this.info.getMensaje());
			 } 
			 if(this.info.getCliente().equalsIgnoreCase("Cliente 1")) {
		 	   this.ventana.appendTextCliente(this.info.getMensaje());
			 }
	    }   
		else {
		  throw new IllegalArgumentException();
		}
	}
}
