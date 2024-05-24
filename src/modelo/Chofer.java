package modelo;

/**
 * Clase abstracta que modela el comportamiento de un chofer. <br>
 */
public abstract class Chofer {
	protected String dni;
	protected String nombre;
	
	protected Chofer(String nombre, String dni) {
		this.nombre=nombre;
		this.dni=dni;
	}
	
	/**
	 * Metodo abstracto que calcula el sueldo del chofer.<br>
	 * @return devuelve un valor mayor a 0.<br>
	 */
	protected abstract double calcularSueldo();
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
}
