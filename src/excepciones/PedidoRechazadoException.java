package excepciones;

/**
 * Clase que modela la excepcion que se lanza cuando un pedido es rechazado.<br>
 */
public class PedidoRechazadoException extends Exception {
	public PedidoRechazadoException() {
		super("El pedido es invalido");
	}
	
	public PedidoRechazadoException(String message) {
		super(message);
	}
}
