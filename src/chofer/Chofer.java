package chofer;

/**
 * Clase abstracta que representa a un chofer de la empresa.
 * Esta clase define las características comunes para todos los choferes y declara un método abstracto para obtener el sueldo.
 */
public abstract class Chofer {
	
	protected String dni;
	protected String nombre;
	
	/**
     * Constructor para crear un Chofer.
     * @param dni El número de identificación del chofer.
     * @param nombre El nombre del chofer.
     */
	public Chofer(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	/**
     * Método abstracto para obtener el sueldo de un chofer.
     * Este método debe ser implementado por las subclases para calcular el sueldo específico de cada tipo de chofer.
     * @return El sueldo del chofer.
     */
	public abstract double getSueldo();

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
