package modelo.usuario;

import modelo.sistema.RecursoCompartido;

public abstract class ClienteThreadRobot extends ClienteThread {
	private int viajesRestantes;
	private RecursoCompartido rc;
	
	public ClienteThreadRobot(ClienteDTO cliente, int viajesRestantes, RecursoCompartido rc) {
		super(cliente);
		this.viajesRestantes = viajesRestantes;
		this.rc = rc;
	}

	@Override
	public void run() {
		while(Simulacion.getChoferesActivos() > 0 && viajesRestantes > 0) {
			//pedido
		}
	}
}
