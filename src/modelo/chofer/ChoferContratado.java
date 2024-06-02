package modelo.chofer;

import java.util.ArrayList;

import modelo.usuario.Empresa;
import modelo.viaje.IViaje;

/**
 * Clase que representa a un chofer contratado de la empresa.
 * Esta clase extiende la clase Chofer y agrega características específicas para los choferes contratados.
 */
public class ChoferContratado extends Chofer {
	
	private double gananciaXViaje;
	
	/**
     * Constructor para crear un ChoferContratado.
     * @param dni El número de identificación del chofer.
     * @param nombre El nombre del chofer.
     * @param gananciaXViaje La ganancia por cada viaje realizado por el chofer contratado.
     */
	public ChoferContratado(String nombre, String dni) {
		super(nombre, dni);
	}
	
	/**
	 * Método para obtener el sueldo de un chofer contratado.
	 * Este método calcula el sueldo del chofer contratado multiplicando la cantidad recaudada
	 * por el porcentaje de ganancia por viaje.
	 * @return El sueldo neto del chofer contratado.
	 */
	public double getSueldo(Empresa empresa) {
		double recaudado = 0;
		ArrayList<IViaje> viajes = empresa.getViajes(this);
		
		for(IViaje viaje: viajes) {
			recaudado += viaje.getCosto();
		}
		
		return recaudado * this.gananciaXViaje;
	}
}
