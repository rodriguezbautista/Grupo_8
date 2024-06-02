package excepciones;

public class PedidoRechazadoException extends Exception {
	public PedidoRechazadoException() {
		super("El pedido es invalido");
	}
	
	public PedidoRechazadoException(String message) {
		super(message);
	}
}
