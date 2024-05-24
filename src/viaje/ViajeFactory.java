package viaje;

import chofer.Chofer;
import modelo.Pedido;
import vehiculo.Vehiculo;

/**
 * Clase destinada a fabricar viajes.<br>
 */
public class ViajeFactory {
	
	/**
	 * Este metodo construye un viaje cuyo tipo depende del parametro "pedido".
	 * @param pedido: pedido por el cual se construye un viaje.<br>
	 * @param chofer: chofer asignado al viaje.<br>
	 * @param vehiculo: vehiculo asignado al viaje.<br>
	 * @return devuelve un objeto de tipo IViaje.<br>
	 * <br> Precondicion: pedido diferente de null.<br>
	 * <br> Precondicion: chofer diferente de null.<br>
	 * <br> Precondicion: vehiculo diferente de null.<br>
	 */
	public IViaje getViaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		IViaje viaje;
		viaje=null;
		
		if(pedido.getZona().equalsIgnoreCase("Estandar")) {
			viaje=new ViajeZonaEstandar(pedido,chofer,vehiculo);
		}
		else if(pedido.getZona().equalsIgnoreCase("Calle sin afaltar")) {
			viaje=new ViajeZonaCalleSinAfaltar(pedido,chofer,vehiculo);
		}
		else if(pedido.getZona().equalsIgnoreCase("Zona Peligrosa")){
			viaje=new ViajeZonaPeligrosa(pedido,chofer,vehiculo);
		}
		
		
		if(pedido.getMascota()) {
			viaje=new DecoratorConMascota(viaje);
		}

		if(pedido.getEquipaje().equalsIgnoreCase("Baul")) {
			viaje=new DecoratorEquipajeBaul(viaje);
		}
		
		return viaje;
	}
}
