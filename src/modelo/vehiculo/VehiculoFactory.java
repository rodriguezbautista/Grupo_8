package modelo.vehiculo;

import excepciones.VehiculoInexistenteException;

public class VehiculoFactory {
	/**
	 * Metodo que instancia un vehiculo dependiendo del tipo recibido como parametro.<br>
	 * @param tipo: tipo de vehiculo.<br>
	 * @param patente: patente del vehiculo.<br>
	 * <br> Precondicion: Patente distinta de null.<br>
	 * <br> Excepcion: Vehiculo inexistente.<br>
	 */
	public static Vehiculo getVehiculo(String tipo,String patente) throws VehiculoInexistenteException {
		if (tipo.equalsIgnoreCase("Moto"))
			return new Moto(patente,1,false,false);
		if (tipo.equalsIgnoreCase("Automovil")) 
			return new Automovil(patente,4,true,true);
		if (tipo.equalsIgnoreCase("Combi"))
			return new Combi(patente,10,false,true);
		throw new VehiculoInexistenteException(tipo);
	}
}
