package modelo.usuario;

import excepciones.PedidoRechazadoException;
import modelo.sistema.RecursoCompartido;
import modelo.sistema.Simulacion;
import modelo.sistema.Util;
import modelo.viaje.SubsistemaViaje;

public abstract class ClienteThreadRobot extends ClienteThread {
	private String[] zonas;
	private int viajesRestantes;
	private RecursoCompartido rc;
	
	public ClienteThreadRobot(Cliente cliente, int viajesRestantes, RecursoCompartido rc) {
		super(cliente);
		this.viajesRestantes = viajesRestantes;
		this.rc = rc;
		this.zonas = new String[]{"peligrosa", "sin asfaltar", "estandar"};
	}

	@Override
	public void run() {
		while(Simulacion.getChoferesActivos() > 0 && viajesRestantes > 0) {
			String zona = this.zonas[Util.aleatorio(2)];
			boolean mascota = Util.aleatorio(1) == 0;
			boolean equipaje = Util.aleatorio(1) == 0;
			int cantPersonas = Util.aleatorio(10) + 1;
			double distancia = 12.0;
			
			try {
				SubsistemaViaje.solicitarViaje(rc, getCliente(), distancia, zona, cantPersonas, equipaje, mascota);
				Util.espera();
				rc.pagar(this);
				Util.espera();
			} catch (PedidoRechazadoException e) {
			}
		}
	}
}
