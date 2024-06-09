package modelo.usuario;

import modelo.viaje.IViaje;

/**
 * Clase que modela a un cliente thread correspondiente a un usuario logueado.<br>
 */
public class ClienteThreadLogeado extends ClienteThread {
	public ClienteThreadLogeado(Cliente clienteDTO) {
		super(clienteDTO);
	}

	@Override
	public void run() {
		
	}
}
