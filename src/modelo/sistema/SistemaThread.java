package modelo.sistema;

public class SistemaThread extends Thread {
	private RecursoCompartido rc;
	
	public SistemaThread(RecursoCompartido rc) {
		this.rc = rc;
	}

	@Override
	public void run() {
		while(Simulacion.getChoferesActivos() > 0) {
			this.rc.asignarVehiculo();
		}
	}
	
}
