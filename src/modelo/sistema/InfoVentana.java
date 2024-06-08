package modelo.sistema;

import modelo.chofer.Chofer;
import modelo.usuario.Cliente;

public class InfoVentana {
	private String chofer;
	private String cliente;
	private String mensaje;

	public String getChofer() {
		return chofer;
	}

	public String getCliente() {
		return cliente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}
