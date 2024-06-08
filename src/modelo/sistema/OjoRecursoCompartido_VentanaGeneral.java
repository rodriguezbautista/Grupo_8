package modelo.sistema;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaGeneral;

public class OjoRecursoCompartido_VentanaGeneral implements Observer{

	private Observable rc;
	private VentanaGeneral ventana;
	private InfoVentana info;
	
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
			if(this.info.getChofer().equalsIgnoreCase("Chofer")) {
				 this.ventana.appendTextChofer(this.info.getMensaje());
			 } 
			 if(this.info.getCliente().equalsIgnoreCase("Cliente")) {
		 	   this.ventana.appendTextCliente(this.info.getMensaje());
			 }
	    }   
		else {
		  throw new IllegalArgumentException();
		}
	}
}
