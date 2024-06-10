package modelo.usuario;

import excepciones.PedidoRechazadoException;
import excepciones.SinChoferesException;
import modelo.sistema.RecursoCompartido;
import modelo.sistema.Simulacion;
import modelo.sistema.Util;
import modelo.viaje.IViaje;
import modelo.viaje.SubsistemaViaje;

/**
 * Clase que modela a un cliente thread generado automaticamente por la simulacion.<br>
 */
public class ClienteThreadRobot extends ClienteThread {
	private String[] zonas;
	private int viajesRestantes;
	private RecursoCompartido rc;
	
	public ClienteThreadRobot(Cliente cliente, int viajesRestantes, RecursoCompartido rc) {
		super(cliente);
		this.viajesRestantes = viajesRestantes;
		this.rc = rc;
		this.zonas = new String[]{"Zona Peligrosa", "Calle sin asfaltar", "Estandar"};
	}
	
	@Override
	public void run() {		

		while(Simulacion.getChoferesActivos() > 0 && viajesRestantes > 0) {
			String zona = this.zonas[Util.aleatorio(2)];
			boolean mascota = Util.aleatorio(1) == 0;
			boolean equipaje = Util.aleatorio(1) == 0;
			int cantPersonas = Util.aleatorio(10);
			double distancia = 12.0;
			
			try {
				Util.espera();
				IViaje viaje = SubsistemaViaje.solicitarViaje(rc, getCliente(), distancia, zona, cantPersonas, equipaje, mascota);
				super.setViaje(viaje);
				Util.espera();
				rc.pagar(this.getViaje());
				viajesRestantes--;
			} catch (PedidoRechazadoException | SinChoferesException e) {
			}
		}
		
		Simulacion.setClientesActivos(Simulacion.getClientesActivos() - 1);
	}
}
