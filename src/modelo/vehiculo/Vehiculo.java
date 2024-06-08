package modelo.vehiculo;

import java.io.Serializable;

import modelo.sistema.Pedido;

public abstract class Vehiculo implements Serializable{
	protected String numpatente;
	protected final int cantMaxPas;
	protected final boolean petFriendly;
	protected final boolean baul;
	
	public Vehiculo(String numpatente,int cantmaxpas, boolean petfriendly, boolean baul) {
		this.numpatente=numpatente;
		this.cantMaxPas = cantmaxpas;
		this.petFriendly = petfriendly;
		this.baul = baul;
	}

	public Integer getPrioridad(Pedido pedido) {
		Integer valorPrioridad = null;
		
		if(verificaPasajeros(pedido.getCantPersonas()) && verificaBaul(pedido.usoBaul()) && verificaMascota(pedido.getMascota()))
			valorPrioridad = califica(pedido.usoBaul(), pedido.getCantPersonas());
		
		return valorPrioridad;
	}
	
	public boolean verificaPasajeros(int cantPasajeros){
		if (cantPasajeros <= this.cantMaxPas)
			return true;
		else
			return false;
	}
	
	public boolean verificaBaul(boolean baul) {
		if(!baul) {
			return true;
		}else
			return this.baul;
	}
	
	public boolean verificaMascota(boolean mascota) {
		if(!mascota) {
			return true;
		}else
			return this.petFriendly;
	}
	
	
	protected abstract int califica(boolean pideBaul, int cantPax);
}
