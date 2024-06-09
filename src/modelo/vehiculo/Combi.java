package modelo.vehiculo;

/**
 * Clase que representa a un vehiculo tipo combi.<br>
 */
public class Combi extends Vehiculo{

	public Combi(String numpatente, int cantmaxpas, boolean petfriendly, boolean baul) {
		super(numpatente, cantmaxpas, petfriendly, baul);
	}
	
	/**
	 * Metodo que devuelve un valor que representa la calificacion del vehiculo en funcion de la cantidad de personas
	 * que puede transportar, y en funcion de su posibilidad de transportar equipaje en el baul.<br>
	 * Dicha calificacion sera usada para determinar la prioridad del vehiculo.<br> 
	 * <br> Precondicion: parametro cantPax mayor a 0.<br>
	 * <br> Postcondicion: devuelve un valor entero.<br>
	 */
	public int califica(boolean pideBaul, int cantPax) {
		if (pideBaul) {
			return 10*cantPax + 100;
		} else {
			return 10*cantPax;
		}
	}
}
