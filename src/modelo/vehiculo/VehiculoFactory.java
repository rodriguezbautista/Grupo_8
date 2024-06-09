package modelo.vehiculo;

import excepciones.VehiculoInexistenteException;

public class VehiculoFactory {
	/**
	 * @param tipo: tipo de vehiculo.<br>
	 * @param patente: patente del vehiculo.<br>
	 * <br> Precondicion: Tipo de vehiculo valido.<br>
	 * <br> Precondicion: Patente distinta de null.<br>
	 */
	public static Vehiculo getVehiculo(String tipo,String patente) {
		Vehiculo vehiculo = null;
		
		if (tipo.equalsIgnoreCase("Moto"))
			vehiculo = new Moto(patente,1,false,false);
		else if (tipo.equalsIgnoreCase("Automovil")) 
			vehiculo = new Automovil(patente,4,true,true);
		else if (tipo.equalsIgnoreCase("Combi"))
			vehiculo = new Combi(patente,10,false,true);
		
		return vehiculo;
	}
}
