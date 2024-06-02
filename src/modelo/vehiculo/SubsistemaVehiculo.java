package modelo.vehiculo;

import java.util.ArrayList;
import java.util.List;

import excepciones.NoVehiculoException;
import excepciones.VehiculoInexistenteException;
import modelo.usuario.Empresa;
import modelo.viaje.IViaje;

public class SubsistemaVehiculo {
	public static Vehiculo mejorVehiculo(Empresa empresa, IViaje viaje) throws NoVehiculoException {
    	int max = 0;
    	Vehiculo mejorVehiculo = null;
    	
    	List<Vehiculo> vehiculosDisponibles = empresa.getVehiculos();
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
