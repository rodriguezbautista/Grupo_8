package excepciones;

/**
 * Clase que modela la excepcion que se lanza cuando un cliente se quiere registrar con las credenciales de
 * un usuario ya existente.<br>
 */
public class UsuarioExistenteException extends Exception {
    public UsuarioExistenteException() {
        super("El usuario ya existe.");
    }

    public UsuarioExistenteException(String message) {
        super(message);
        
    }
}
