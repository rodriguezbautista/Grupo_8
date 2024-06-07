package modelo.usuario;

public abstract class ClienteThread extends Thread {
	private Cliente cliente;

	public ClienteThread(Cliente cliente) {
		this.cliente = cliente;
	}
}
