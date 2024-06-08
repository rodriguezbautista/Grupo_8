package modelo.sistema;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import excepciones.PedidoRechazadoException;
import modelo.chofer.Chofer;
import modelo.chofer.ChoferThread;
import modelo.usuario.Cliente;
import modelo.usuario.ClienteThread;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.IViaje;

public class RecursoCompartido extends Observable {
	private ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>();
	private ArrayList<IViaje> viajesSolicitados = new ArrayList<IViaje>();
	private ArrayList<IViaje> viajesConVehiculo = new ArrayList<IViaje>();
	private ArrayList<IViaje> viajesIniciados = new ArrayList<IViaje>();
	private InfoVentana informacion;

	public RecursoCompartido() {}

	public synchronized void asignarVehiculo() {
		while (Simulacion.getChoferesActivos() > 0 && this.viajesSolicitados.isEmpty()) {// mientras la simulacion este activa y NO haya viajes solicitados, espera...															
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
		this.informacion.setChofer("");
		
		if (Simulacion.getChoferesActivos() > 0) {
			IViaje viaje = this.viajesSolicitados.get(0);
			Vehiculo vehiculo = this.vehiculosDisponibles.get(0);
			
			this.viajesSolicitados.remove(viaje);
			this.vehiculosDisponibles.remove(vehiculo);
			viaje.setVehiculo(vehiculo);
			this.viajesConVehiculo.add(viaje);
			
			viaje.setStatus("con vehiculo");
			
			this.informacion.setCliente(viaje.getCliente().getNombre());
			this.informacion.setMensaje("Se asigna un vehiculo al viaje del cliente " + viaje.getCliente() + " y queda a la espera de ser tomado por un chofer");
			setChanged();
			notifyObservers(this.informacion);
		}
		else {
			for(IViaje viaje: this.viajesSolicitados) {
				this.informacion.setCliente(viaje.getCliente().getNombre());
				this.informacion.setMensaje("Se cancelo el viaje de " + viaje.getCliente().getNombre() + " por falta de choferes");
				setChanged();
				notifyObservers(this.informacion);
			}
			this.viajesSolicitados.clear();
		}
		notifyAll();// si termino la simulacion o asigno un vehiculo, avisa a todos los hilos
	}

	public synchronized void tomarViaje(ChoferThread chofer) {
		
		while (Simulacion.getClientesActivos() > 0 && this.viajesConVehiculo.isEmpty()) { //mientras la simulacion este activa y NO haya viajes con vehiculo, espera....
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.informacion.setChofer(chofer.getNombre());
		this.informacion.setCliente("");
		if(Simulacion.getClientesActivos() > 0) {
			IViaje viaje = this.viajesConVehiculo.get(0);
			viaje.setChofer(chofer.getChoferDTO());
			viaje.setStatus("iniciado");
			this.viajesConVehiculo.remove(viaje);
			this.viajesIniciados.add(viaje);
			this.informacion.setMensaje("El chofer " + chofer.getNombre() + " toma el viaje del cliente " + this.viajesConVehiculo.get(0).getCliente().getNombre() + "\n *** El viaje esta iniciado ***");
			setChanged();
			notifyObservers(this.informacion);
		}
		else{
			this.informacion.setMensaje("El chofer " + chofer.getNombre() + " finalizo su turno");
			setChanged();
			notifyObservers(this.informacion);
		}
		
		notifyAll();
	}

	public synchronized void pagar(ClienteThread cliente) {
		while(cliente.getViaje().getStatus() != "iniciado" && Simulacion.getChoferesActivos() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.informacion.setChofer("");
		this.informacion.setCliente(cliente.getCliente().getNombre());
		
		if(Simulacion.getChoferesActivos() > 0) {
			this.informacion.setMensaje("El cliente " + cliente.getCliente().getNombre() + " pago el viaje");
			setChanged();
			notifyObservers(this.informacion);
			cliente.getViaje().setStatus("pagado");
		}
		else {
			this.informacion.setMensaje("Se cancelo el viaje de " + cliente.getCliente().getNombre() + " por falta de choferes");
			setChanged();
			notifyObservers(this.informacion);
			this.viajesConVehiculo.remove(cliente.getViaje());
		}
		notifyAll();
	}

	public synchronized void finalizar(ChoferThread chofer) {
		IViaje viaje = null;
		Iterator<IViaje> iterator = this.viajesIniciados.iterator();
		
		while (iterator.hasNext() && viaje == null) {
			IViaje aux = iterator.next();
			if (aux.getChofer() == chofer.getChoferDTO()) {
				viaje = aux;
			}
		}
		
		while(viaje.getStatus() != "pagado") {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		viaje.setStatus("finalizado");
		
		agregarVehiculo(viaje.getVehiculo());
		Empresa.getInstance().addViaje(viaje);
		
		this.informacion.setChofer(chofer.getNombre());
		this.informacion.setCliente("");
		this.informacion.setMensaje("El chofer " + chofer.getNombre() + " finalizo su viaje");
		setChanged();
		notifyObservers(this.informacion);
		
		//Si fue su ultimo viaje o el viaje era el ultimo del ultimo cliente
		if(chofer.getViajesRestantes() == 1 || Simulacion.getClientesActivos() == 0) {
			this.informacion.setMensaje("El chofer " + chofer.getNombre() + " finalizo su turno");
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

	public void validarPedido(Cliente cliente, List<Vehiculo> vehiculos, String zona, int cantidadPersonas, boolean usoBaul, boolean llevaMascota) throws PedidoRechazadoException{
		boolean valido = false;
		
		this.informacion.setChofer("");
		this.informacion.setCliente(cliente.getNombre());
		
		if (cantidadPersonas > 10) {
			this.informacion.setMensaje("El cliente "+ cliente.getNombre() + " quiso realizar un pedido invalido de " + cantidadPersonas + " personas. El pedido fue rechazado");
    		setChanged();
    		notifyObservers(this.informacion);
    		throw new PedidoRechazadoException("Cantidad de personas invalido");
		}
		
		Iterator<Vehiculo> iteratorVehiculos = vehiculos.iterator();
    	while(iteratorVehiculos.hasNext() && !valido) {
    		Vehiculo aux = iteratorVehiculos.next();
    		if (aux.verificaPasajeros(cantidadPersonas) && aux.verificaBaul(usoBaul) && aux.verificaMascota(llevaMascota)) {
    			valido = true;
    		}
    	}
    	
    	if (!valido) {
    		this.informacion.setMensaje("No existen vehiculos aptos para el pedido del cliente " + cliente.getNombre() + ". El pedido fue rechazado");
    		setChanged();
    		notifyObservers(this.informacion);
    		throw new PedidoRechazadoException("No existen vehiculos aptos para el pedido del cliente");
    	}
	}

}
