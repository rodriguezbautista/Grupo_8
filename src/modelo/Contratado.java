package modelo;

/**
 * Clase concreta que modela a un empleado contratado
 */
public class Contratado extends Chofer {

	private static double gananciaViaje=0.20;
	
	/**
	 * Construye un objeto de tipo Contratado <br>
	 * @param nombre: es el nombre del chofer <br>
	 * @param dni: es el dni del chofer <br>
	 */
	protected Contratado(String nombre, String dni) {
		super(nombre, dni);
	}
	
	/**
	 * Este metodo calcula el sueldo de un empleado contratado en funcion de su ganancia por viaje.<br>
	 * @return devuelve un valor mayor a 0
	 */
	@Override
	protected double calcularSueldo() {
		double recaudado = Sistema.getInstance().getSueldoContratado(this);
		recaudado*=Contratado.gananciaViaje;
		return recaudado;
	}
	
	/**
	 * Este metodo setea el atributo estatico "gananciaViaje" con un valor ingresado como parametro.<br>
	 * <br> Precondicion: parametro mayor a 0.<br>
	 * @param gananciaViaje: nuevo valor a asignar <br>
	 */
	public void setGananciaViaje(double gananciaViaje) {
		Contratado.gananciaViaje = gananciaViaje;
	}
	
}
