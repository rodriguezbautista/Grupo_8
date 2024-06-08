package modelo.sistema;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaLogin;

public class OjoRecursoCompartido_VentanaLogin implements Observer{
	
	private Observable rc;
	private VentanaLogin ventana;
	private InfoVentana info;
	
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
