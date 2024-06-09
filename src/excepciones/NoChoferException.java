package excepciones;

/**
 * Clase que modela la excepcion lanzada cuando no hay choferes activos.<br>
 */
public class NoChoferException extends Exception {
    public NoChoferException() {
        super("No hay suficientes Choferes");
    }

    public NoChoferException(String message) {
        super(message);
    }
}
