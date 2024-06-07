package modelo.usuario;

import modelo.sistema.RecursoCompartido;

public abstract class ClienteThreadRobot extends ClienteThread {
	private int viajesRestantes;
	private RecursoCompartido rc;
	
	public ClienteThreadRobot(Cliente cliente, int viajesRestantes, RecursoCompartido rc) {
		super(cliente);
		this.viajesRestantes = viajesRestantes;
		
	}

	@Override
	public void run() {
		while(Simulacion.getChoferesActivos() > 0 && viajesRestantes > 0) {
			//pedido
		}
	}
}
