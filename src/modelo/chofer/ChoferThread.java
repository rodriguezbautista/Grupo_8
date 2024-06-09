package modelo.chofer;

import modelo.sistema.RecursoCompartido;
import modelo.sistema.Simulacion;

public class ChoferThread extends Thread {
	private Chofer chofer;
	private int viajesRestantes;
	private RecursoCompartido rc;
	
	public ChoferThread(Chofer chofer, int viajesRestantes, RecursoCompartido rc) {
		this.viajesRestantes = viajesRestantes;
		this.chofer = chofer;
		this.rc = rc;
	}
	
	public int getViajesRestantes() {
		return this.viajesRestantes;
	}
	
	public String getNombre() {
		return this.chofer.getNombre();
	}

	@Override
	public void run() {
		while(Simulacion.getClientesActivos() > 0 && viajesRestantes > 0) {
			this.rc.tomarViaje(this);
			this.rc.finalizar(this);
			this.viajesRestantes--;
		}
		Simulacion.setChoferesActivos(Simulacion.getChoferesActivos() - 1);
	}

	public Chofer getChofer() {
		return this.chofer;
	}
}
