package excepciones;

/**
 * Clase que modela la excepcion que se lanza cuando se quiere acceder a un vehiculo inexistente.<br>
 */
public class VehiculoInexistenteException extends Exception {

	public VehiculoInexistenteException() {
		super("Vehiculo inexistente");
	}

	public VehiculoInexistenteException(String message) {
		super("El vehiculo " + message + " no existe en el sistema");
	}
}
