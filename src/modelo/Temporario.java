package modelo;

/**
 * Clase concreta que modela a un empleado temporario
 */
public class Temporario extends Empleado {

	private static double plusCantidadViajes=0.10;
	private int cantViajes;
	
	/**
	 * Construye un objeto de tipo Temporario.<br>
	 * @param nombre: nombre del chofer <br>
	 * @param dni: dni del chofer<br>
	 */
	protected Temporario(String nombre, String dni) {
		super(nombre, dni);
		this.cantViajes=0;
	}
	
	/**
	 * Este metodo calcula el sueldo bruto para los choferes temporarios en funcion su cantidad de viajes.<br>
	 * @return devuevle un valor mayor a 0 
	 */
	@Override
	protected double getSueldoBruto() {
		double sueldoBruto = Empleado.sueldoBase+(Empleado.sueldoBase*Temporario.plusCantidadViajes*this.cantViajes);
		return sueldoBruto;
	}
	
	/**
	 * Este metodo calcula el sueldo del empleado temporario en funcion de su sueldo bruto y sus aportes.<br>
	 * @return devuelve un valor mayor a 0.<br> 
	 */
	@Override
	protected double calcularSueldo() {
		double sueldoNeto=this.getSueldoBruto()*Empleado.aportes;
		return sueldoNeto;
	}
	
	/**
	 * Este metodo setea el atributo estatico "plusCantidadViajes".<br>
	 * <br> Precondicion: parametro mayor a 0. <br>
	 * <br> Postcondicion:  Atributo plusCantidadViajes modificado con el valor ingresado como parametro.<br>
	 * @param plusCantidadViajes: nuevo valor a asignar <br>
	 */
	public void setPlusCantidadViajes(double plusCantidadViajes) {
		Temporario.plusCantidadViajes = plusCantidadViajes;
	}
	public void nuevoViaje() {
		this.cantViajes++;
	}
}
