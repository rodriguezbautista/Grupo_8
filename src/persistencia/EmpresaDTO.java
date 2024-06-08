package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.chofer.Chofer;
import modelo.usuario.Cliente;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.IViaje;

public class EmpresaDTO implements Serializable{
	private HashMap<String, Cliente> clientes;
	private ArrayList<Chofer> choferes;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<IViaje> viajes;

	public EmpresaDTO() {}

	public HashMap<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashMap<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}

	public void setChoferes(ArrayList<Chofer> choferes) {
		this.choferes = choferes;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public ArrayList<IViaje> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<IViaje> viajes) {
		this.viajes = viajes;
	}
}
