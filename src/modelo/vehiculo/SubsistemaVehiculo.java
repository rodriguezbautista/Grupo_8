package modelo.vehiculo;

import java.util.ArrayList;

import excepciones.NoVehiculoException;
import excepciones.VehiculoInexistenteException;
import modelo.viaje.IViaje;

public class SubsistemaVehiculo {
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
