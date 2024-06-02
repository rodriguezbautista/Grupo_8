package modelo.sistema;

import java.util.Observable;
import java.util.Observer;

import ventana.VentanaGeneral;

public class OjoRecursoCompartido implements Observer{

	private Observable rc;
	private VentanaGeneral ventana;
	private InfoVentanaGeneral info;
	
	public OjoRecursoCompartido(Observable  rc, VentanaGeneral ventana) {
		this.rc = rc;
		this.ventana = ventana;
		this.rc.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.rc) {
			this.info = (InfoVentanaGeneral) arg;
			
			if(this.info.getEvento().equalsIgnoreCase("FinSimulacion")) {
				this.ventana.appendTextGeneral(this.info.getCartel());
				this.ventana.appendTextChofer(this.info.getCartel());
				this.ventana.appendTextCliente(this.info.getCartel());
			}
			else {
			   this.ventana.appendTextGeneral(this.info.getCartel());//muentra en el campo de texto general
			
			   if(this.info.getEvento().equalsIgnoreCase("Chofer")) {
				  this.ventana.appendTextChofer(this.info.getCartel());
			   }
			   
			   if(this.info.getEvento().equalsIgnoreCase("Cliente")) {
				  this.ventana.appendTextCliente(this.info.getCartel());
			   }
			}   
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
