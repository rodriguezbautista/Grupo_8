package modelo;

import java.util.GregorianCalendar;

/**
 * Clase concreta que modela a un empleado permanente.
 */
public class Permanente extends Empleado {

	private static double plusAntiguedad=0.20;
	private static double plusHijos=0.05;
	private GregorianCalendar fecha;
	private int cantHijos;
	
	/**
	 * Construye un objeto de tipo Permanente <br>
	 * @param nombre: es el nombre del chofer <br>
	 * @param dni: es el dni del chofer <br>
	 * @param fecha: es la fecha de ingreso del chofer a la empresa <br>
	 */
	protected Permanente(String nombre, String dni, GregorianCalendar fecha) {
		super(nombre, dni);
		this.fecha=fecha;
	}
	
	/**
	 * Este metodo calcula el sueldo bruto para los choferes permanentes en funcion de su antiguedad y su cantidad de hijos.<br>
	 * @return devuelve un valor mayor a 0.
	 */
	@Override
	protected double getSueldoBruto() {
		double sueldoBruto = Empleado.sueldoBase+(Empleado.sueldoBase*Permanente.plusHijos*this.cantHijos);

		sueldoBruto*=()*Permanente.plusAntiguedad;
		return sueldoBruto;
	}
	
	/**
	 * Este metodo calcula el sueldo del empleado permanente en funcion de su sueldo bruto y sus aportes.<br>
	 * @return devuelve un valor mayor a 0. 
	 */
	@Override
	protected double calcularSueldo() {
		double sueldoNeto = this.getSueldoBruto()*Empleado.aportes;
		return sueldoNeto;
	}
	
	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	/**
	 * Este metodo setea el atributo estatico "plusAntiguedad".<br>
	 * <br> Precondicion: parametro mayor a 0. <br>
	 * <br> Postcondicion:  Atributo plusAntiguedad modificado con el valor ingresado como parametro.<br>
	 * @param plusAntiguedad: nuevo valor a asignar <br>
	 */
	public void setPlusAntiguedad(double plusAntiguedad) {
		Permanente.plusAntiguedad = plusAntiguedad;
	}
	
	/**
	 * Este metodo setea el atributo estatico "plusHijos".<br>
	 * <br> Precondicion: parametro mayor a 0. <br>
	 * <br> Postcondicion:  Atributo plusHijos modificado con el valor ingresado como parametro.<br>
	 * @param plusHijos: nuevo valor a asignar <br>
	 */
	public void setPlusHijos(double plusHijos) {
		Permanente.plusHijos = plusHijos;
	}
}
