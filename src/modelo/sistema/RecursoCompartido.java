package modelo.sistema;

import java.util.ArrayList;
import java.util.Observable;

public class RecursoCompartido extends Observable {
	private ArrayList<Vehiculos> vehicDisponibles = new ArrayList<Vehiculos>();
	private ArrayList<Vehiculos> vehicEnUso = new ArrayList<Vehiculos>();
	private ArrayList<Viajes> viajesSolicitados = new ArrayList<Viajes>();
	private ArrayList<Viajes> viajesConVehiculo = new ArrayList<Viajes>();
	private ArrayList<Viajes> viajesIniciados = new ArrayList<Viajes>();
	private ArrayList<Choferes> choferesDisponibles = new ArrayList<Choferes>();
	private ArrayList<Choferes> choferesOcupados = new ArrayList<Choferes>();
	private boolean simulacionActiva;
	private InfoVentanaGeneral informacion;


	public RecursoCompartido(boolean estadoSimulacion) {
		this.simulacionActiva = estadoSimulacion;
	}

	public synchronized void asignarVehiculo() {
		while (this.simulacionActiva && this.viajesSolicitados.isEmpty()) {// mientras la simulacion este activa y NO haya viajes solicitados, espera...															
			try {
				this.informacion.setEvento("General");
				this.informacion.setCartel("En espera de slicitudes de viajes");
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
			this.informacion.setEvento("General");
			this.informacion.setCartel("---> Se asigna un vehiculo al viaje del cliente " + this.viajesSolicitados[0].getCliente() + " y queda a la espera de ser tomado por un chofer ");
			setChanged();
			notifyObservers(this.informacion);
		}
		notifyAll();// si termino la simulacion o asigno un vehiculo, avisa a todos los hilos
	}

	public synchronized void tomarViaje(Chofer chofer) {
		while (this.simulacionActiva && this.viajesConVehiculo.isEmpty()) { //mientras la simulacion este activa y NO haya viajes con vehiculo, espera....
			try {
				this.informacion.setEvento("General");
				this.informacion.setCartel("Choferes en espera de tomar viajes");
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
			this.informacion.setEvento("Chofer");
			this.informacion.setCartel("---> El chofer " + chofer.getNombre() + " toma el viaje del cliente " + this.viajesConVehiculo[0].getCliente() + "\n *** El viaje esta iniciado ***");
		}
		notifyAll();
	}

	public synchronized void pagar(Cliente cliente) {
		if(this.simulacionActiva) {
			this.informacion.setEvento("Cliente");
			this.informacion.setCartel("El cliente " + cliente.getNombre() + " pago el viaje");
			setChanged();
			notifyObservers(this.informacion);
			/*
			 * aca el cliente paga el viaje.
			 */
		}
		notifyAll();
	}

	public synchronized void finalizar(Chofer chofer) {
		if(this.simulacionActiva) {
			this.informacion.setEvento("Chofer");
			this.informacion.setCartel("El chofer " + chofer.getNombre() + " finalizo su viaje");
			setChanged();
			notifyObservers(this.informacion);
			/*
			 * Aca el chofer finaliza el viaje. Se busca en la lista de viajes iniciados con el chofer
			 * que viene como parametro; se saca dicho viaje de la lista y se pone en la lista de viajes finalizados
			 * que esta en la empresa.
			 */
		}
		notifyAll();
	}

	public void agregarVehiculos(ArrayList<Vehiculos> vehiculos) {
		/*
		 * aca se agregan todos los vehiculos existentes de la empresa a la coleccion de
		 * vehiculos disponibles.
		 */
	}

	public void agregarChoferes(ArrayList<Choferes> choferes) {
		/*
		 * aca se agregan todos los choferes existentes de la empresa a la coleccion de
		 * choferes disponibles.
		 */
	}

	public void finalizarSimulacion() {
		this.informacion.setEvento("FinSimulacion");
		this.informacion.setCartel("***************** SIMULACION FINALIZADA ***************");
		setChanged();
		notifyObservers(this.informacion);
		this.simulacionActiva = false;
		notifyAll();
	}
}
