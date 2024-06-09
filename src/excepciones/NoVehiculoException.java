package excepciones;

/**
 * Clase que modela la excepcion que se lanza cuando no hay un vehiculo apto para un viaje.<br>
 */
public class NoVehiculoException extends Exception {
    public NoVehiculoException() {
        super("No se encontró ningún vehículo que cumpla con los requisitos del viaje.");
    }

    public NoVehiculoException(String message) {
        super(message);
        
    }
}
