package modelo.chofer;

import modelo.chofer.ChoferPermanente;
import modelo.chofer.ChoferTemporario;
import modelo.chofer.ChoferContratado;

public class ChoferFactory {

	public static Chofer getChofer(String nombre, String dni, String tipo) {
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
