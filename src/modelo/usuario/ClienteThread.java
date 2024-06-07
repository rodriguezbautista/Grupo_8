package modelo.usuario;

import modelo.sistema.Simulacion;

public abstract class ClienteThread implements Runnable {
	private ClienteDTO clienteDTO;
	private int cantPedidos;
	
	
	public ClienteThread(ClienteDTO clienteDTO, int cantPedidos) {
		this.clienteDTO = clienteDTO;
		this.cantPedidos = cantPedidos;
	}
	
	public ClienteDTO getCliente() {
		return this.clienteDTO;
	}
	
	public void run() {
		while(Simulacion.getChoferesActivos()>0 && this.cantPedidos>0) {
			
		}
	}
}
