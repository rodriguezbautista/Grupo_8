package modelo.chofer;

import modelo.chofer.ChoferPermanente;
import modelo.chofer.ChoferTemporario;
import modelo.chofer.ChoferContratado;

public class ChoferFactory {
	
	/**
	 * Metodo que instanica a un chofer dependiende del tipo ingresado como parametro.<br>
	 * @param nombre: nombre del chofer.<br>
	 * @param dni: dni del chofer.<br>
	 * @param tipo: tipo de chofer.<br>
	 * @return retorna un chofer del tipo ingresado como parametro o null.<br>
	 */
	public Chofer getChofer(String nombre, String dni, String tipo) {
		Chofer chofer = null;

		if (tipo == "Permanente") {
			chofer = new ChoferPermanente(nombre, dni);
		} else if (tipo == "Temporario") {
			chofer = new ChoferTemporario(nombre, dni);
		} else if (tipo == "Contratado") {
			chofer = new ChoferContratado(nombre, dni);
		}
		return chofer;
	}
}
