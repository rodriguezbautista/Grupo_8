package modelo.chofer;

public class ChoferFactory {

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
