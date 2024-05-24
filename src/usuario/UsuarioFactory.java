package usuario;

public class UsuarioFactory {
	public Usuario crea(Usuario usuario) {
		if (usuario.isAdmin())
			return new Administrador(usuario);
		else
			return new Cliente(usuario);
	}
}
