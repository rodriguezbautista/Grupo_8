package modelo.usuario;

import modelo.viaje.IViaje;

/**
 * Clase que modela a un cliente thread.<br>
 */
public abstract class ClienteThread extends Thread {
	private Cliente cliente;
	private IViaje viaje;
	
	public ClienteThread(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public IViaje getViaje() {
		return this.viaje;
	}
	
	public void setViaje(IViaje viaje) {
		this.viaje = viaje;
	}
}
