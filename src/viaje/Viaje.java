package viaje;

import chofer.Chofer;
import modelo.Pedido;
import usuario.Cliente;
import vehiculo.Vehiculo;

/**
 * Clase abstracta que modela las caracteristicas y el comportamoiento de los viajes.<br>
 */
public abstract class Viaje implements IViaje {
	
	protected String status;
	protected Pedido pedido;
	protected Chofer chofer;
	protected Cliente cliente;
	protected double distanciaReal,costo;
	protected static double costoBase=1000;
	protected Vehiculo vehiculo;
	
	
	public Viaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		this.pedido=pedido;
		this.chofer=chofer;
		this.vehiculo=vehiculo;
	}
	
    /**
     * Este metodo setea el atributo distanciaReal con el valor recibido como parametro.<br>
     * <br> Precondicion: parametro mayor a 0.<br>
     * @param dist: nuevo valor a asignar.<br>
     */
	protected void setDistanciaReal(double dist) {
		this.distanciaReal=dist;	
	}
	
	protected static double getCostoBase() {
		return Viaje.costoBase;
	}
	
	/**
	 * Este metodo setea el atributo estatico costoBase con el valor recibido como parametro.<br>
	 * <br> Precondicion: parametro mayor a 0.<br>
	 * @param costoBase: nuevo valor a asignar.<br>
	 */
	protected static void setCostoBase(double costoBase) {
		Viaje.costoBase=costoBase;
	}

	public double getDistanciaReal() {
		return this.distanciaReal;
	}
	public Pedido getPedido() {
		return pedido;
	}
	
	/**
	 * Este metodo abstracto calculara el costo del viaje dependiento del tipo de viaje.<br>
	 */
	public abstract double getCosto();

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	

}
