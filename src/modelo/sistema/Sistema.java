package modelo.sistema;

import java.util.Collections;
import java.util.List;

import excepciones.NoChoferException;
import excepciones.PedidoRechazadoException;
import modelo.chofer.Chofer;
import modelo.usuario.Empresa;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.Viaje;
import modelo.viaje.ViajeFactory;


public class Sistema {
	private static Sistema instance = null;
	private Empresa empresa;
	
	private Sistema() {
		empresa = new Empresa();
	}
	
	public static Sistema getInstance() {
		if (instance==null) 
			instance=new Sistema();
		return instance;
	}
	
	public Viaje crearViajeDesdePedido(Pedido pedido) throws PedidoRechazadoException, NoChoferException {
		
		ViajeFactory viajesFabrica = new ViajeFactory();
		Viaje nuevoViaje;
		
        if (evaluarPedido(pedido)) {
        	nuevoViaje = (Viaje)viajesFabrica.getViaje(pedido, null, null);
        	nuevoViaje.setStatus("Solicitado.");
        	Vehiculo vehiculo = mejorVehiculoDisponible(nuevoViaje);
        	nuevoViaje.setVehiculo(vehiculo);
        	nuevoViaje.setStatus("Con vehiculo.");
        	if(!this.empresa.getChoferes().isEmpty()) {
        		Chofer chofer = this.empresa.getChoferes().get(0);
        		Collections.rotate(this.empresa.getChoferes(), -1); // Este método rota los elementos del array x posiciones, con -1 el primer elemento queda último.
        		nuevoViaje.setChofer(chofer);
        		nuevoViaje.setStatus("Iniciado.");
        		return nuevoViaje;
        	}else {
        		throw new NoChoferException();
        	}	
        } else {
            throw new PedidoRechazadoException();
        }
    }

    private boolean evaluarPedido(Pedido pedido) {
    	
        List<Vehiculo> vehiculosDisponibles = this.empresa.getVehiculos();
        
        for(Vehiculo vh : vehiculosDisponibles) {
        	if(vh.verificaPasajeros(pedido.getCantPersonas()) && vh.verificaBaul(pedido.usoBaul()) && vh.verificaMascota(pedido.getMascota())) {
        		return true;
        	}
        }
        return false;
    }
    
    private Vehiculo mejorVehiculoDisponible(Viaje viaje) {
    	
    	int max = 0;
    	Vehiculo mejorVehiculo = null;
    	
    	List<Vehiculo> vehiculosDisponibles = this.empresa.getVehiculos();
        for(Vehiculo vh : vehiculosDisponibles) {
        	if(max < vh.getPrioridad(viaje.getPedido())) {
        		max = vh.getPrioridad(viaje.getPedido());
        		mejorVehiculo = vh;
        	}
        }
        return mejorVehiculo;
    }
    
    public void registrarPago(Viaje viaje) {
    	this.empresa.sumaRecaudado(viaje.getCosto());
    	viaje.setStatus("Pagado.");
    }
    
    public void finalizarViaje() {
    	Collections.rotate(this.empresa.getChoferes(), -1);
    	Collections.rotate(this.empresa.getVehiculos(), -1);
    }
}
