package modelo.vehiculo;

import java.util.ArrayList;

import excepciones.NoVehiculoException;
import excepciones.VehiculoInexistenteException;
import modelo.viaje.IViaje;

public class SubsistemaVehiculo {
	
	/**
	 * Metodo que determina el mejor vehiculo para un viaje determinado.<br>
	 * @param vehiculosDisponibles: arrayList de vehiculos disponibles.<br>
	 * @param viaje: viaje realizado por la empresa.<br>
	 * @return Devuelve el mejor vehiculo para el viaje recibido por parametro o null si no existe un vehiculo
	 * apto para ese viaje.<br>
	 * @throws NoVehiculoException: excepcion que se lanzara si no existe un vehiculo apto para el viaje
	 * recibido como parametro.<br>
	 * <br> Precondicion: parametro vehiculosDisponibles diferente de null.<br>
	 * <br> Precondicion: parametro viaje diferente de null.<br>
	 */
	public static Vehiculo mejorVehiculo(ArrayList<Vehiculo> vehiculosDisponibles, IViaje viaje) throws NoVehiculoException {
    	int max = 0;
    	Vehiculo mejorVehiculo = null;
    	
        for(Vehiculo vehiculo : vehiculosDisponibles) {
        	Integer prioridadVehiculo = vehiculo.getPrioridad(viaje.getPedido());
        	
        	if(prioridadVehiculo != null && max < prioridadVehiculo) {
        		max = prioridadVehiculo;
        		mejorVehiculo = vehiculo;
        	}
        }
        if(mejorVehiculo != null) {        	
        	return mejorVehiculo;
        }
        throw new NoVehiculoException();
    }
	
	public static void agregaVehiculo(ArrayList<Vehiculo> vehiculos, String tipo, String patente) throws VehiculoInexistenteException {
		vehiculos.add(VehiculoFactory.getVehiculo(tipo, patente));
	}
}
