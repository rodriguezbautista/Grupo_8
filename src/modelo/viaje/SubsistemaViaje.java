package modelo.viaje;

import java.util.Collections;

import excepciones.NoChoferException;
import excepciones.NoVehiculoException;
import excepciones.PedidoRechazadoException;
import modelo.sistema.Pedido;
import modelo.usuario.Empresa;

public class SubsistemaViaje {
	
	public static IViaje crearViaje(Pedido pedido) throws PedidoRechazadoException {
        
        IViaje nuevoViaje = ViajeFactory.getViaje(pedido);
        nuevoViaje.setStatus("Solicitado.");
        return nuevoViaje;
        
    	/*
    	Vehiculo vehiculo = SubsistemaVehiculo.mejorVehiculo(empresa, nuevoViaje);
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
    	}	*/
    }
	
	public static void registrarPago(Empresa empresa, Viaje viaje) {
		empresa.sumaRecaudado(viaje.getCosto());
		viaje.setStatus("Pagado.");
	}
	
	public static void finalizarViaje(Empresa empresa) {
		Collections.rotate(empresa.getChoferes(), -1);
		Collections.rotate(empresa.getVehiculos(), -1);
	}
}
