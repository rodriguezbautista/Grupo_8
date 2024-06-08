package modelo.usuario;

import java.util.List;

import modelo.chofer.Chofer;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.IViaje;
import modelo.viaje.Viaje;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<ClienteDTO> clientes;
	private ArrayList<Chofer> choferes;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<IViaje> viajes;
	private double recaudado = 0;
	
	public Empresa() { 
		vehiculos = new ArrayList<Vehiculo>();
		choferes = new ArrayList<Chofer>();
	}

	public ArrayList<ClienteDTO> getClientes() {
		return clientes;
	}

	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public ArrayList<IViaje> getViajes() {
		return viajes;
	}
	
	public ArrayList<IViaje> getViajes(Chofer chofer) {
		ArrayList<IViaje> viajesChofer = new ArrayList<IViaje>();
		
		for(IViaje viaje: viajes) {
			if (viaje.getChofer() == chofer) {
				viajesChofer.add(viaje);
			}
		}
		
		return viajesChofer;
	}

	public double getRecaudado() {
		return recaudado;
	}

	public void sumaRecaudado(double monto) {
		this.recaudado += monto;
	}

	public void addViaje(IViaje viaje) {
		viajes.add(viaje);
	}
}
	
	