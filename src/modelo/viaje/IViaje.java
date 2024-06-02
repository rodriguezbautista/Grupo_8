package modelo.viaje;

import modelo.chofer.Chofer;
import modelo.sistema.Pedido;

/**
 * Interfaz que modela una parte del comportamiento de los viajes.<br>
 */
public interface IViaje {

	double getCosto();
	Pedido getPedido();
    double getDistanciaReal();
	Chofer getChofer();
  
}
