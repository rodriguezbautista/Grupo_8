package modelo.viaje;

import modelo.sistema.Pedido;

/**
 * Clase concreta que modela el comportamiento de los viajes con equipaje en baul.<br>
 */
public class DecoratorEquipajeBaul extends DecoratorViajes {

	/**
	 * Construye un objeto de tipo DecoratorEquipajeBaul.<br>
	 * @param encapsulado: objeto a decorar de tipo interfaz IViaje.<br> 
	 */
	public DecoratorEquipajeBaul(IViaje encapsulado) {
		super(encapsulado);
	}
	
	/**
	 * Este metodo modifica el costo del viaje, representado por el encapsulado, agregando un plus sobre el costo base por llevar equipaje en el baul.<br>
	 * @return devuelve un valor mayor a 0.<br>
	 */
	@Override
	public double getCosto() {
		double costoEncapsulado=this.encapsulado.getCosto();
		double incrXPersona=Viaje.getCostoBase()*0.10*this.encapsulado.getPedido().getCantPersonas();
		double incrXKm=Viaje.getCostoBase()*0.05*this.encapsulado.getDistanciaReal();
		
		return costoEncapsulado+incrXPersona+incrXKm;
	}
	@Override
	public Pedido getPedido() {
		return this.encapsulado.getPedido();
	}

}
