package modelo.sistema;

import java.util.ArrayList;
import java.util.Observable;

import modelo.chofer.Chofer;
import modelo.usuario.ClienteThread;
import modelo.usuario.Empresa;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.IViaje;

public class RecursoCompartido extends Observable {
	private ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>();
	private ArrayList<IViaje> viajesSolicitados = new ArrayList<IViaje>();
	private ArrayList<IViaje> viajesConVehiculo = new ArrayList<IViaje>();
	private ArrayList<IViaje> viajesIniciados = new ArrayList<IViaje>();
	private boolean simulacionActiva;
	private InfoVentanaGeneral informacion;
	private Empresa empresa;


	public RecursoCompartido(Empresa empresa, boolean estadoSimulacion) {
		this.empresa = empresa;
		this.simulacionActiva = estadoSimulacion;
	}

	public synchronized void asignarVehiculo() {
		while (this.simulacionActiva && this.viajesSolicitados.isEmpty()) {// mientras la simulacion este activa y NO haya viajes solicitados, espera...															
			try {
				this.informacion.setChofer("");
				this.informacion.setCliente("");
				this.informacion.setMensaje("En espera de solicitudes de viajes");
				setChanged();
				notifyObservers(this.informacion);
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.simulacionActiva) {
			/*
			 * aca se saca el vehiculo de la lista de vehiculos disponibles y se pasa a la
			 * lista de vehiculos en uso. Ademas se agrega el vehiculo al objeto viaje y se
			 * saca el viaje de la lista de viajes solicitados y se pasa a la lista de
			 * viajes con vehiculo
			 */
			this.informacion.setChofer("");
			this.informacion.setCliente("");
			this.informacion.setMensaje("---> Se asigna un vehiculo al viaje del cliente " + this.viajesSolicitados.get(0).getCliente() + " y queda a la espera de ser tomado por un chofer ");
			setChanged();
			notifyObservers(this.informacion);
		}
		notifyAll();// si termino la simulacion o asigno un vehiculo, avisa a todos los hilos
	}

	public synchronized void tomarViaje(Chofer chofer) {
		
		while (this.simulacionActiva && this.viajesConVehiculo.isEmpty()) { //mientras la simulacion este activa y NO haya viajes con vehiculo, espera....
			try {
				this.informacion.setChofer(chofer.getNombre());
				this.informacion.setCliente("");
				this.informacion.setMensaje("Chofer " + chofer.getNombre() + " esta esperando tomar un viaje");
				setChanged();
				notifyObservers(this.informacion);
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(this.simulacionActiva) {
			/*
			 * Aca se saca al chofer de la lista de choferes disponibles y se pasa a la lista de choferes ocupados.
			 * Tambien se saca el viaje de la lista de viajes con vehiculo y se pasa a la lista de viajes iniciados
			 * Se asigna el chofer al objeto viaje
			 */
			this.informacion.setChofer(chofer.getNombre());
			this.informacion.setCliente("");
			this.informacion.setMensaje("---> El chofer " + chofer.getNombre() + " toma el viaje del cliente " + this.viajesConVehiculo.get(0).getCliente().getNombre() + "\n *** El viaje esta iniciado ***");
		}
		notifyAll();
	}

	public synchronized void pagar(ClienteThread cliente) {
		if(this.simulacionActiva) {
			this.informacion.setChofer("");
			this.informacion.setCliente(cliente.getCliente().getNombre());
			this.informacion.setMensaje("El cliente " + cliente.getCliente().getNombre() + " pago el viaje");
			setChanged();
			notifyObservers(this.informacion);
			/*
			 * aca el cliente paga el viaje.
			 */
		}
		notifyAll();
	}

	public synchronized void finalizar(Chofer chofer, IViaje viaje) {
		if(this.simulacionActiva) {
			agregarVehiculo(viaje.getVehiculo());
			empresa.addViaje(viaje);
			
			this.informacion.setChofer(chofer.getNombre());
			this.informacion.setCliente("");
			this.informacion.setMensaje("El chofer " + chofer.getNombre() + " finalizo su viaje");
			setChanged();
			notifyObservers(this.informacion);
		}
		notifyAll();
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		this.vehiculosDisponibles.add(vehiculo);
	}

	public void agregarViaje(IViaje viaje) {
		this.viajesSolicitados.add(viaje);
	}

}
