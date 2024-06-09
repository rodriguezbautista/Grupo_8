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
	
	/**
	 * Metodo que arma un pedido a partir de los datos enviados por el cliente.<br>
	 * @param recursoCompartido: recurso compartido por los threads. Necesario para validar el pedido.<br>
	 * @param cliente: cliente que realiza el pedido.<br>
	 * @param distancia: distancia del viaje.<br>
	 * @param zona: zona del viaje.<br>
	 * @param cantidadPersonas: cantidad de personas a transportar.<br>
	 * @param usoBaul: valor booleano que indica si se usa el baul o no.<br>
	 * @param llevaMascota: valor booleano que indica si se transporta mascoata o no.<br>
	 * @return Devuelve un pedido valido o lanza una excepcion en caso contrario.<br>
	 * @throws PedidoRechazadoException: excepcion que se lanza cuando el pedido es rechazado.<br>
	 * <br> Precondiciones: Parametro recursoCompartido diferente de null.<br>
	 * <br> Precondiciones: Parametro cliente diferente de null.<br>
	 * <br> Precondiciones: Parametro distancia mayor a 0.<br>
	 * <br> Precondiciones: Parametro zona diferente de null y diferente de vacio.<br>
	 * <br> Precondiciones: Parametro cantidadPersonas mayor a 0.<br>
	 */
    private static Pedido crearPedido(RecursoCompartido recursoCompartido, Cliente cliente, double distancia, String zona, int cantidadPersonas, boolean usoBaul, boolean llevaMascota) throws PedidoRechazadoException{
    	Pedido pedido = null;
    	List<Vehiculo> vehiculos = Empresa.getInstance().getVehiculos();
    	
        recursoCompartido.validarPedido(cliente, vehiculos, zona, cantidadPersonas, usoBaul, llevaMascota);
        
        pedido = new Pedido(Util.fechaActual(), zona, llevaMascota, llevaMascota, cantidadPersonas, cliente);
        
        return pedido;
    }
    
    /**
     * Metodo que solicita un viaje a partir de un pedido valido.<br>
     * @param recursoCompartido: recurso compartido por los threads. Necesario para agregar el viaje a la
     * coleccion de viajes solicitados.<br>
     * @param cliente: cliente que realiza el pedido.<br>
     * @param distancia: distancia del viaje.<br>
     * @param zona: zona del viaje.<br>
     * @param cantidadPersonas: cantidad de personas a transportar.<br>
     * @param usoBaul: booleano que indica si se usa el baul o no.<br>
     * @param llevaMascota: valor booleano que indica si se transporta mascoata o no.<br>
     * @throws PedidoRechazadoException: excepcion que se lanza cuando el pedido es rechazado.<br>
     * <br> Precondiciones: Parametro recursoCompartido diferente de null.<br>
	 * <br> Precondiciones: Parametro cliente diferente de null.<br>
	 * <br> Precondiciones: Parametro distancia mayor a 0.<br>
	 * <br> Precondiciones: Parametro zona diferente de null y diferente de vacio.<br>
	 * <br> Precondiciones: Parametro cantidadPersonas mayor a 0.<br>
	 * <br> Postcondicion: agrega un viaje a la coleccion de viajes solicitados o lanza excepcion.<br>
     */
    public static void solicitarViaje(RecursoCompartido recursoCompartido, Cliente cliente, double distancia, String zona, int cantidadPersonas, boolean usoBaul, boolean llevaMascota) throws PedidoRechazadoException {
    	Pedido pedido = crearPedido(recursoCompartido, cliente, distancia, zona, cantidadPersonas, usoBaul, llevaMascota);
    	recursoCompartido.agregarViaje(SubsistemaViaje.crearViaje(pedido));
    }
}
