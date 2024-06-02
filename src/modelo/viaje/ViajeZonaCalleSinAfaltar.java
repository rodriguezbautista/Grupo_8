package modelo.viaje;

import modelo.sistema.Pedido;

/**
 * Clase concreta que modela las caracteristicas y el comportamiento de los viajes de tipo ViajeZonaCalleSinAfaltar.<br>
 */
public class ViajeZonaCalleSinAfaltar extends Viaje {

	/**
	 * Construye un objeto de tipo ViajeZonaCalleSinAfaltar.La inicializacion de los atributos se delega al constructor de la superclase.<br>
	 * @param pedido: pedido por el cual se construye un viaje. Detalla las caracteristicas que tendra dicho viaje.<br> 
	 * <br> Precondicion: pedido diferente de null.<br>
	 */
	public ViajeZonaCalleSinAfaltar(Pedido pedido) {
		super(pedido);
	}
	
	/**
	 * Este metodo calcula el costo del viaje tipo ViajeZonaCalleSinAfaltar en funcion del costo base y agrega dos pluses, sobre el costo base,propios de este tipo de viaje: uno por cantidad de personas y otro por kilometros recorridos.<br>
	 * @return devuelve un valor mayor a 0.<br> 
	 */
	public double getCosto() {
		double incrXPersona=Viaje.getCostoBase()*this.getPedido().getCantPersonas()*0.20;
		double incrXKm=Viaje.getCostoBase()*this.getDistanciaReal()*0.15;
		return Viaje.getCostoBase()+incrXPersona+incrXKm;
	}
}