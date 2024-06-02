package excepciones;

public class VehiculoInexistenteException extends Exception {

	public VehiculoInexistenteException() {
		super("Vehiculo inexistente");
	}

	public VehiculoInexistenteException(String message) {
		super("El vehiculo " + message + " no existe en el sistema");
	}
}
