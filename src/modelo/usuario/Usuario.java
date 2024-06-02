package modelo.usuario;

public class Usuario{
	private String usuario;
	private String contrasenia;
    private String nombreCompleto;
    
	public Usuario(String usuario, String contrasenia, String nombreCompleto) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombreCompleto = nombreCompleto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombreCompleto;
	}

	public void setNombre(String nombre) {
		this.nombreCompleto = nombre;
	}	
}
