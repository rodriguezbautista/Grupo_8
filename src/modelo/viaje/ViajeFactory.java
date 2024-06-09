package modelo.viaje;

import modelo.sistema.Pedido;

/**
 * Clase destinada a fabricar viajes.<br>
 */
public class ViajeFactory {
	
	/**
	 * Este metodo construye un viaje cuyo tipo depende del parametro "pedido".
	 * @param pedido: pedido por el cual se construye un viaje.<br>
	 * @return devuelve un objeto de tipo IViaje.<br>
	 * <br> Precondicion: pedido validado.<br>
	 */
	public static IViaje getViaje(Pedido pedido) {
		IViaje viaje = null;
		
		if(pedido.getZona().equalsIgnoreCase("Estandar")) {
			viaje=new ViajeZonaEstandar(pedido);
		}
		else if(pedido.getZona().equalsIgnoreCase("Calle sin asfaltar")) {
			viaje=new ViajeZonaCalleSinAfaltar(pedido);
		}
		else if(pedido.getZona().equalsIgnoreCase("Zona Peligrosa")){
			viaje=new ViajeZonaPeligrosa(pedido);
		}
		
		
		if(pedido.getMascota()) {
			viaje=new DecoratorConMascota(viaje);
		}

		if(pedido.getEquipaje()){
			viaje=new DecoratorEquipajeBaul(viaje);
		}
		
		return viaje;
	}
}
