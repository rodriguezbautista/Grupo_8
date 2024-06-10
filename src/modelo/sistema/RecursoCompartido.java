package modelo.sistema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import excepciones.PedidoRechazadoException;
import excepciones.SinChoferesException;
import modelo.chofer.ChoferThread;
import modelo.usuario.Cliente;
import modelo.usuario.ClienteThread;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.IViaje;

/**
 * Clase que modela el recurso compartido por los hilos involucrados.<br>
 */
public class RecursoCompartido extends Observable {
	private ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>();
	private ArrayList<IViaje> viajesSolicitados = new ArrayList<IViaje>();
	private ArrayList<IViaje> viajesConVehiculo = new ArrayList<IViaje>();
	private ArrayList<IViaje> viajesIniciados = new ArrayList<IViaje>();
	private InfoVentana informacion;

	public RecursoCompartido() {
		this.informacion = new InfoVentana();
	}

	/**
	 * Metodo sincronizado que intenta asignar vehiculos a viajes en situacion de solicitado.<br>
	 */
	public synchronized void asignarVehiculo() {
		while (Simulacion.getChoferesActivos() > 0 && this.viajesSolicitados.isEmpty()) {// mientras la simulacion este activa y NO haya viajes solicitados, espera...															
			try {
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
			
			this.informacion.setCliente(viaje.getCliente().getUsuario());
			this.informacion.setMensaje("Se asigna un vehiculo al viaje del cliente " + viaje.getCliente().getNombre());
			setChanged();
			notifyObservers(this.informacion);
		}
		else {
			//Si no hay choferes, cancelo todos los viajes no iniciados
			for(IViaje viaje: this.viajesSolicitados) {
				this.informacion.setCliente(viaje.getCliente().getUsuario());
				this.informacion.setMensaje("Se cancelo el viaje de " + viaje.getCliente().getNombre() + " por falta de choferes");
				setChanged();
				notifyObservers(this.informacion);
			}
			for(IViaje viaje: this.viajesConVehiculo) {
				this.informacion.setCliente(viaje.getCliente().getUsuario());
				this.informacion.setMensaje("Se cancelo el viaje de " + viaje.getCliente().getNombre() + " por falta de choferes");
				setChanged();
				notifyObservers(this.informacion);
			}
			this.viajesSolicitados.clear();
			this.viajesConVehiculo.clear();
		}
		notifyAll();// si termino la simulacion o asigno un vehiculo, avisa a todos los hilos
	}
	
	/**
	 * Metodo sincronizado, llamado por los choferesThread, que intenta tomar un viaje con vehiculo <br>
	 * e iniciarlo.<br> 
	 * @param chofer: parametro correspondiente al choferThread que intenta tomar un viaje.<br>
	 * <br> Precondicion: parametro chofer diferente de null.<br>
	 */
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
		if(Simulacion.getClientesActivos() > 0) {
			IViaje viaje = this.viajesConVehiculo.get(0);
			viaje.setChofer(chofer.getChofer());
			viaje.setStatus("iniciado");
			this.viajesConVehiculo.remove(viaje);
			this.viajesIniciados.add(viaje);
			this.informacion.setCliente(viaje.getCliente().getUsuario());
			this.informacion.setMensaje("El chofer " + chofer.getNombre() + " toma el viaje del cliente " + viaje.getCliente().getNombre());
			setChanged();
			notifyObservers(this.informacion);
		}
		else{
			this.informacion.setCliente("");
			this.informacion.setMensaje("El chofer " + chofer.getNombre() + " finalizo su turno");
			setChanged();
			notifyObservers(this.informacion);
		}
		
		notifyAll();
	}
	
	/**
	 * metodo sincronizado que, llamado por los clientesThread, que intentan pagar un viaje.<br>
	 * @param viaje: parametro correspondiente al clienteThread que quiere pagar su viaje.<br>
	 * <br> Precondicion: Parametro viaje diferente de null.<br>
	 */
	public synchronized void pagar(IViaje viaje) {
		while(viaje.getStatus() != "iniciado" && Simulacion.getChoferesActivos() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.informacion.setChofer("");
		this.informacion.setCliente(viaje.getCliente().getUsuario());
		
		if(viaje.getStatus() == "iniciado") {
			this.informacion.setMensaje(viaje.getCliente().getNombre() + " pago el viaje");
			setChanged();
			notifyObservers(this.informacion);
			viaje.setStatus("pagado");
		}
		else {
			this.informacion.setMensaje("Se cancelo el viaje de " + viaje.getCliente().getNombre() + " por falta de choferes");
			setChanged();
			notifyObservers(this.informacion);
			this.viajesConVehiculo.remove(viaje);
		}
		notifyAll();
	}
	
	/**
	 * metodo sincronizado, llamado por los choferesThread, que intenta finalizar un viaje.<br>
	 * @param chofer: Parametro correspondiente al choferThread que quiere finalizar su viaje.<br>
	 * <br> precondicion: parametro chofer distinto de null.<br>
	 */
	public synchronized void finalizar(ChoferThread chofer) {
		IViaje viaje = null;
		Iterator<IViaje> iterator = this.viajesIniciados.iterator();
		
		while (viaje == null) {
			IViaje aux = iterator.next();
			if (aux.getChofer() == chofer.getChofer()) {
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
		this.viajesIniciados.remove(viaje);
		
		this.informacion.setChofer(chofer.getNombre());
		this.informacion.setCliente(viaje.getCliente().getUsuario());
		this.informacion.setMensaje("El chofer " + chofer.getNombre() + " finalizo su viaje");
		setChanged();
		notifyObservers(this.informacion);
		
		//Si fue su ultimo viaje o el viaje era el ultimo del ultimo cliente
		if(chofer.getViajesRestantes() == 1 || Simulacion.getClientesActivos() == 0) {
			this.informacion.setCliente("");
			this.informacion.setMensaje("El chofer " + chofer.getNombre() + " finalizo su turno");
			setChanged();
			notifyObservers(this.informacion);
		}
		notifyAll();
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		this.vehiculosDisponibles.add(vehiculo);
	}

	public synchronized void agregarViaje(IViaje viaje) throws SinChoferesException {
		if (Simulacion.getChoferesActivos() == 0) {
			this.informacion.setChofer("");
			this.informacion.setCliente(viaje.getCliente().getUsuario());
    		this.informacion.setMensaje("No hay choferes disponibles. El pedido de " + viaje.getCliente().getNombre() + " fue rechazado.");
    		setChanged();
    		notifyObservers(this.informacion);
    		throw new SinChoferesException("No hay choferes disponibles");
		}
		this.viajesSolicitados.add(viaje);
		notifyAll();
	}
	
	/**
	 * Metodo que valida un pedido realizado. 
	 * @param cliente: cliente que realiza el pedido.<br>
	 * @param vehiculos: arrayList de vehiculos disponibles.<br>
	 * @param zona: zona del viaje.<br>
	 * @param cantidadPersonas: cantidad de personas a transportar.<br>
	 * @param usoBaul: valor booleano correspondiente al uso del baul.<br>
	 * @param llevaMascota: valor booleano correspondiente al transporte de mascota.<br>
	 * @throws PedidoRechazadoException: excepcion que se lanzara cuando el pedido sea rechazado.<br>
	 * <br> Precondicion: parametro cliente diferente de null.<br>
	 * <br> Precondicion: parametro vehiculos diferente de null.<br>
	 * <br> Precondicion: parametro zona diferente de null y diferente de vacio.<br> 
	 * <br> Precondicion: parametro cantidadPersonas mayor a 0.<br>
	 */
	public void validarPedido(Cliente cliente, List<Vehiculo> vehiculos, String zona, int cantidadPersonas, boolean usoBaul, boolean llevaMascota) throws PedidoRechazadoException{
		boolean valido = false;
		
		this.informacion.setChofer("");
		this.informacion.setCliente(cliente.getUsuario());

		Iterator<Vehiculo> iteratorVehiculos = vehiculos.iterator();
    	while(iteratorVehiculos.hasNext() && !valido) {
    		Vehiculo aux = iteratorVehiculos.next();
    		if (aux.verificaPasajeros(cantidadPersonas) && aux.verificaBaul(usoBaul) && aux.verificaMascota(llevaMascota)) {
    			valido = true;
    		}
    	}
    	
    	if (!valido) {
    		this.informacion.setMensaje("No existen vehiculos aptos para el pedido del cliente " + cliente.getNombre() + ". El pedido fue rechazado");
    		throw new PedidoRechazadoException("No existen vehiculos aptos para el pedido del cliente");
    	}
    	else{
    		this.informacion.setMensaje("El cliente " + cliente.getNombre() + " Solicito un viaje");
    	}
    	setChanged();
    	notifyObservers(this.informacion);
	}

}
