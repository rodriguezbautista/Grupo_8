package modelo.usuario;

import modelo.sistema.Simulacion;
import modelo.viaje.IViaje;

public abstract class ClienteThread extends Thread {
	private ClienteDTO clienteDTO;
	private IPedidos pedidos;
	private IViaje viaje;
	
	public ClienteThread(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	
	public ClienteDTO getCliente() {
		return this.clienteDTO;
	}
	
	protected void realizarPedido() {
		//pedidos.realizarPedido(asdasdasd);
	}
	
	public IViaje getViaje() {
		return this.viaje;
	}
}
