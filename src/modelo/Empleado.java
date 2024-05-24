package modelo;
/**
 * Clase abstracta que modela las caracteristicas y comportamiento comun a los choferes permanentes y temporarios. <br> 
 */
public abstract class Empleado extends Chofer {

	protected static double sueldoBase=10000;
	protected static double aportes=0.85;
	
	protected Empleado(String nombre, String dni) {
		super(nombre, dni);
	}
	
	/**
	 * Este metodo calcula el sueldo bruto del chofer dependiendo del tipo del chofer <br>
	 * <br> Precondicion:.......... <br>
	 * @return devuelve un valor mayor a 0.
	 */
	protected abstract double getSueldoBruto();
	
	/**
	 * Este metodo setea el valor del sueldo base de los empleados permanentes y temporarios <br>
	 * <br> Precondicion: parametro mayor a 0.<br>
	 * @param sueldoBase: nuevo valor a asignar <br>
	 * <br> Postcondicion: Atributo sueldoBase modificado con el valor ingresado como parametro.<br>
	 */
	public void setSueldoBase(double sueldoBase) {
		Empleado.sueldoBase = sueldoBase;
	}
	
	/**
	 * Este metodo setea el valor de los aportes de los empleados permanentes y temporarios <br>
	 * <br> Precondicion: parametro mayor a 0.
	 * @param aportes: nuevo valor a asignar <br>
	 * <br> Postcondicion: Atributo aportes modificado con el valor ingresado como parametro.
	 */
	public void setAportes(double aportes) {
		Empleado.aportes = aportes;
	}
}
