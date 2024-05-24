package usuario;

import java.util.Iterator;
import java.util.List;

import excepciones.UsuarioExistenteException;

public class GestionDeUsuarios{
	
	public Usuario creaUsuario(List<Usuario> usuarios,Usuario usuario) throws UsuarioExistenteException {
		  Iterator<Usuario> iterator = usuarios.iterator();
	        while (iterator.hasNext()) {
	            Usuario usuarios1 = iterator.next();
	            if (usuarios1.getUsuario().equals(usuario.getUsuario())) {
	            	throw new UsuarioExistenteException("Usuario ya existente: "+usuario.getUsuario());
	            }
	        }
	       UsuarioFactory factoryUsuario = new UsuarioFactory();
	       return factoryUsuario.crea(usuario);
	}
}
