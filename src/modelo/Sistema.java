package modelo;

import java.util.Collections;
import java.util.List;

import excepciones.NoChoferException;
import excepciones.PedidoRechazadoException;
import usuario.Empresa;
import vehiculo.Vehiculo;
import viaje.Viaje;
import viaje.ViajeFactory;
import chofer.Chofer;


public class Sistema {
	public Viaje crearViajeDesdePedido(Empresa empresa, Pedido pedido) throws PedidoRechazadoException, NoChoferException {
		
		ViajeFactory viajesFabrica = new ViajeFactory();
		
        if (evaluarPedido(empresa, pedido)) {
        	Vehiculo vehiculo = mejorVehiculoDisponible(empresa, pedido);
        	if(!empresa.getChoferes().isEmpty()) {
        		Chofer chofer = empresa.getChoferes().get(0);
        		Collections.rotate(empresa.getChoferes(), -1); // Este método rota los elementos del array x posiciones, con -1 el primer elemento queda último.
        		return (Viaje)viajesFabrica.getViaje(pedido, chofer, vehiculo);
        	}else {
        		throw new NoChoferException();
        	}	
        } else {
            throw new PedidoRechazadoException();
        }
    }

    private boolean evaluarPedido(Empresa empresa, Pedido pedido) {
    	
        List<Vehiculo> vehiculosDisponibles = empresa.getVehiculos();
        
        for(Vehiculo vh : vehiculosDisponibles) {
        	if(vh.verificaPasajeros(pedido.getCantPersonas()) && vh.verificaBaul(pedido.usoBaul()) && vh.verificaMascota(pedido.getMascota())) {
        		return true;
        	}
        }
        return false;
    }
    
    private Vehiculo mejorVehiculoDisponible(Empresa empresa, Pedido pedido) {
    	
    	int max = 0;
    	Vehiculo mejorVehiculo = null;
    	
    	List<Vehiculo> vehiculosDisponibles = empresa.getVehiculos();
        for(Vehiculo vh : vehiculosDisponibles) {
        	if(max < vh.getPrioridad(pedido)) {
        		max = vh.getPrioridad(pedido);
        		mejorVehiculo = vh;
        	}
        }
        return mejorVehiculo;
    }
    
    public void registrarPago(Empresa empresa, Viaje viaje) {
    	empresa.sumaRecaudado(viaje.getCosto());
    }
    
    public void finalizarViaje(Empresa empresa) {
    	Collections.rotate(empresa.getChoferes(), -1);
    	Collections.rotate(empresa.getVehiculos(), -1);
    }
}
