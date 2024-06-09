package modelo.usuario;

import modelo.viaje.IViaje;

/**
 * Clase que modela a un cliente thread.<br>
 */
public abstract class ClienteThread extends Thread {
	private Cliente clienteDTO;
	private IViaje viaje;
	
	public ClienteThread(Cliente clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	
	public Cliente getCliente() {
		return this.clienteDTO;
	}
	
	protected void realizarPedido() {
		//pedidos.realizarPedido(asdasdasd);
	}
	
	public IViaje getViaje() {
		return this.viaje;
	}
	
	public void setViaje(IViaje viaje) {
		this.viaje = viaje;
	}
}
