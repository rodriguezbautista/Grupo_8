package modelo.viaje;

import modelo.chofer.Chofer;
import modelo.sistema.Pedido;
import modelo.usuario.Cliente;
import modelo.vehiculo.Vehiculo;

/**
 * Interfaz que modela una parte del comportamiento de los viajes.<br>
 */
public interface IViaje {

	double getCosto();
	Pedido getPedido();
    double getDistanciaReal();
	Chofer getChofer();
	void setChofer(Chofer chofer);
	void setStatus(String string);
	void setVehiculo(Vehiculo vehiculo);
	Cliente getCliente();
	Vehiculo getVehiculo();
}
