package usuario;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import chofer.Chofer;
import vehiculo.Vehiculo;
import viaje.Viaje;

public class Empresa {
	private static Empresa instance=null;
	private List<Cliente> clientes;
	private List<Chofer> choferes;
	private List<Vehiculo> vehiculos;
	private List<Viaje> viajes;
	private double recaudado = 0;
	
	private Empresa() { 
		vehiculos = new ArrayList<Vehiculo>();
		choferes = new ArrayList<Chofer>();
	}
	
	public static Empresa getInstance() {
		if (instance==null) 
			instance=new Empresa();
		return instance;
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
	
	