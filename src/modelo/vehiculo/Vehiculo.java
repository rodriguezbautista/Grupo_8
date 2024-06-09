package modelo.vehiculo;

import java.io.Serializable;

import modelo.sistema.Pedido;

/**
 * Clase abstracta que modela el comportamiento de un vehiculo.<br>
 */
public abstract class Vehiculo implements Serializable{
	protected String numpatente;
	protected final int cantMaxPas;
	protected final boolean petFriendly;
	protected final boolean baul;
	
	public Vehiculo(String numpatente,int cantmaxpas, boolean petfriendly, boolean baul) {
		this.numpatente=numpatente;
		this.cantMaxPas = cantmaxpas;
		this.petFriendly = petfriendly;
		this.baul = baul;
	}
	
	/**
	 * Metodo que determina la prioridad del vehiculo para ser asignado a un viaje.<br>
	 * @param pedido: pedido realizado por el cliente. En este parametro estan los datos usados para 
	 * determinar la prioridad del vehiculo.<br>
	 * @return Devuelve un valor correspondiente a la prioridad del vehiculo, o null.<br>
	 * <br> Precondicion: parametro pedido diferente de null.<br>
	 */
	public Integer getPrioridad(Pedido pedido) {
		Integer valorPrioridad = null;
		
		if(verificaPasajeros(pedido.getCantPersonas()) && verificaBaul(pedido.usoBaul()) && verificaMascota(pedido.getMascota()))
			valorPrioridad = califica(pedido.usoBaul(), pedido.getCantPersonas());
		
		return valorPrioridad;
	}
	
	/**
	 * Metodo que determina si un vehiculo puede o no transportar al numero de personas indicado como
	 * parametro.<br> 
	 * @param cantPasajeros: cantidad de personas a transportar.<br>
	 * @return Devuelve true si el vehiculo puede transportar al numero de personas indicada en el parametro,
	 * o false en caso contrario.<br>
	 * <br> Precondicion: parametro cantPasajeros mayor a 0;
	 */
	public boolean verificaPasajeros(int cantPasajeros){
		if (cantPasajeros <= this.cantMaxPas)
			return true;
		else
			return false;
	}
	
	/**
	 * Metodo que determina si un vehiculo puede o no transportar equipaje en el baul.<br>
	 * @param baul: valor booleano que indica si se usa o no el baul.<br>
	 * @return Devuelve true si el vehiculo puede transportar equipaje en el baul. Devuelve false en 
	 * caso contrario.<br>
	 */
	public boolean verificaBaul(boolean baul) {
		if(!baul) {
			return true;
		}else
			return this.baul;
	}
	
	/**
	 * Metodo que determina si un vehiculo puede o no transportar mascota.<br>
	 * @param mascota: valor booleano que indica si se transporta o no una mascota.<br>
	 * @return Devuelve true si el vehiculo puede transportar mascota. Devuelve false en caso contrario.<br>
	 */
	public boolean verificaMascota(boolean mascota) {
		if(!mascota) {
			return true;
		}else
			return this.petFriendly;
	}
	
	/**
	 * Metodo abstracto que determina la calificacion de un vehiculo en funcion de la cantidad de personas
	 * que puede transportar, y en funcion de su posibilidad de transportar equipaje en el baul.<br>
	 * @param pideBaul: valor booleano que indica si se usa o no el baul.<br>
	 * @param cantPax: cantidad de personas a transportar.<br>
	 * @return devuelve un valor entero que representa la calificacion del vehiculo.
	 * <br> Precondicion: parametro cantPax mayor a 0.<br>
	 * <br> Postcondicion: devuelve un valor entero.<br>
	 */
	public abstract int califica(boolean pideBaul, int cantPax);
}
