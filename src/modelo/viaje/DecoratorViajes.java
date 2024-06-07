 package modelo.viaje;

import modelo.chofer.Chofer;
import modelo.sistema.Pedido;
import modelo.usuario.ClienteDTO;
import modelo.vehiculo.Vehiculo;

 /**
  * Clase abstracta que modela modela las caracteristicas y comportamiento comun de los encapsulados.<br>
  */
public abstract class DecoratorViajes implements IViaje {

	protected IViaje encapsulado;
	
	public DecoratorViajes(IViaje encapsulado) {
		this.encapsulado=encapsulado;
	}
	
	public double getDistanciaReal() {
		return this.encapsulado.getDistanciaReal();
	}
	
	public Pedido getPedido() {
		return this.encapsulado.getPedido();
	}

	public Chofer getChofer() {
		return encapsulado.getChofer();
	}

	public void setChofer(Chofer chofer) {
		encapsulado.setChofer(chofer);
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		encapsulado.setVehiculo(vehiculo);
	}
	
	public void setStatus(String status) {
		encapsulado.setStatus(status);
	}
	
	public ClienteDTO getCliente() {
		return this.encapsulado.getCliente();
	}
	
	public Vehiculo getVehiculo() {
		return this.encapsulado.getVehiculo();
	}
}
