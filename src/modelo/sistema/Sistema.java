package modelo.sistema;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import excepciones.PedidoRechazadoException;
import modelo.usuario.Cliente;
import modelo.usuario.Empresa;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.SubsistemaViaje;


public class Sistema {
	private static Sistema instance = null;
	private Empresa empresa;
	private RecursoCompartido recursoCompartido;
	
	private Sistema() {
		empresa = new Empresa();
	}
	
	public static Sistema getInstance() {
		if (instance==null) 
			instance=new Sistema();
		return instance;
	}

	public void crearViaje(Pedido pedido) throws PedidoRechazadoException {
		recursoCompartido.agregarViaje(SubsistemaViaje.crearViaje(pedido));
	}
	
    public Pedido crearPedido(Cliente cliente, double distancia, String zona, int cantidadPersonas, boolean usoBaul, boolean llevaMascota) throws PedidoRechazadoException{
    	Pedido pedido = null;
    	List<Vehiculo> vehiculosDisponibles = this.empresa.getVehiculos();
        
        for(Vehiculo vehiculo : vehiculosDisponibles) {
        	if(vehiculo.verificaPasajeros(cantidadPersonas) && vehiculo.verificaBaul(usoBaul) && vehiculo.verificaMascota(llevaMascota)) {
        		//Crea el pedido con la fecha actual
        		pedido = new Pedido(new SimpleDateFormat("dd-MM-yyyy").format(new Date()), zona, llevaMascota, usoBaul, cantidadPersonas, cliente);
        	}
        }
        if (pedido == null)
        	throw new PedidoRechazadoException();
        return pedido;
    }

    public void setEmpresa(Empresa empresa) {
    	this.empresa = empresa;
    }
    
    public void setRecursoCompartido(RecursoCompartido recursoCompartido) {
    	this.recursoCompartido = recursoCompartido;
    }
}
