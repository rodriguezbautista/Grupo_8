package modelo.usuario;

import java.util.List;

import modelo.chofer.Chofer;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.Viaje;

import java.util.ArrayList;

public class Empresa {
	private List<Cliente> clientes;
	private List<Chofer> choferes;
	private List<Vehiculo> vehiculos;
	private List<Viaje> viajes;
	private double recaudado = 0;
	
	public Empresa() { 
		vehiculos = new ArrayList<Vehiculo>();
		choferes = new ArrayList<Chofer>();
	}
	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Chofer> getChoferes() {
		return choferes;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public double getRecaudado() {
		return recaudado;
	}

	public void sumaRecaudado(double monto) {
		this.recaudado += monto;
	}
	
	
	
}
	
	