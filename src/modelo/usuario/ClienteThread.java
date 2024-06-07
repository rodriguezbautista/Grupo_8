package modelo.usuario;

import modelo.sistema.Simulacion;

public abstract class ClienteThread extends Thread {
	private ClienteDTO clienteDTO;
	
	public ClienteThread(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	
	public ClienteDTO getCliente() {
		return this.clienteDTO;
	}
}
