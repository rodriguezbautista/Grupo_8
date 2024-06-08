package modelo.viaje;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import excepciones.PedidoRechazadoException;
import modelo.sistema.Empresa;
import modelo.sistema.Pedido;
import modelo.sistema.RecursoCompartido;
import modelo.sistema.Util;
import modelo.usuario.Cliente;
import modelo.vehiculo.Vehiculo;

public class SubsistemaViaje {
	
	private static IViaje crearViaje(Pedido pedido){
        IViaje nuevoViaje = ViajeFactory.getViaje(pedido);
        nuevoViaje.setStatus("Solicitado.");
        return nuevoViaje;
    }
	
    private static Pedido crearPedido(RecursoCompartido recursoCompartido, Cliente cliente, double distancia, String zona, int cantidadPersonas, boolean usoBaul, boolean llevaMascota) throws PedidoRechazadoException{
    	Pedido pedido = null;
    	List<Vehiculo> vehiculos = Empresa.getInstance().getVehiculos();
    	
        recursoCompartido.validarPedido(cliente, vehiculos, zona, cantidadPersonas, usoBaul, llevaMascota);
        
        pedido = new Pedido(Util.fechaActual(), zona, llevaMascota, llevaMascota, cantidadPersonas, cliente);
        
        return pedido;
    }
    
    public static void solicitarViaje(RecursoCompartido recursoCompartido, Cliente cliente, double distancia, String zona, int cantidadPersonas, boolean usoBaul, boolean llevaMascota) throws PedidoRechazadoException {
    	Pedido pedido = crearPedido(recursoCompartido, cliente, distancia, zona, cantidadPersonas, usoBaul, llevaMascota);
    	recursoCompartido.agregarViaje(SubsistemaViaje.crearViaje(pedido));
    }
}
