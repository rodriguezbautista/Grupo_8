package modelo.usuario;

import java.io.Serializable;

public class Cliente implements Serializable{
	private String nombre;
	private String usuario;
	private String contrasenia;
	
	public Cliente(String nombre, String usuario, String contrasenia) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	
}
