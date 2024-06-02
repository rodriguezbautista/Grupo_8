 package modelo.viaje;

import modelo.chofer.Chofer;
import modelo.sistema.Pedido;

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
}
