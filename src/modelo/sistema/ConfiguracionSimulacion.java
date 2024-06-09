package modelo.sistema;

import java.io.Serializable;

public class ConfiguracionSimulacion implements Serializable {
	private int cantidadChoferes;
	private int cantidadClientes;
	private int cantidadMaximaViajesChofer;
	private int cantidadMaximaViajesCliente;
	private int cantidadAutos;
	private int cantidadCombis;
	private int cantidadMotos;
	
	public ConfiguracionSimulacion(int cantidadChoferes, int cantidadClientes, int cantidadMaximaViajesChofer,
			int cantidadMaximaViajesCliente, int cantidadAutos, int cantidadCombis, int cantidadMotos) {
		this.cantidadChoferes = cantidadChoferes;
		this.cantidadClientes = cantidadClientes;
		this.cantidadMaximaViajesChofer = cantidadMaximaViajesChofer;
		this.cantidadMaximaViajesCliente = cantidadMaximaViajesCliente;
		this.cantidadAutos = cantidadAutos;
		this.cantidadCombis = cantidadCombis;
		this.cantidadMotos = cantidadMotos;
	}

	public int getCantidadChoferes() {
		return cantidadChoferes;
	}

	public int getCantidadClientes() {
		return cantidadClientes;
	}

	public int getCantidadMaximaViajesChofer() {
		return cantidadMaximaViajesChofer;
	}

	public int getCantidadMaximaViajesCliente() {
		return cantidadMaximaViajesCliente;
	}

	public int getCantidadAutos() {
		return cantidadAutos;
	}

	public int getCantidadCombis() {
		return cantidadCombis;
	}

	public int getCantidadMotos() {
		return cantidadMotos;
	}
}
