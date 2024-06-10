package modelo.sistema;

import java.io.Serializable;

import modelo.usuario.Cliente;

/**
 * Clase que modela las caracteristicas de un pedido.<br>
 */
public class Pedido implements Serializable {
	private String fecha;
	private String zona;
	private boolean mascota;
	private boolean equipaje;
	private int cantPersonas;
	private Cliente cliente;
	
	/**
	 * Construye un objeto de tipo Pedido.<br>
	 * @param fecha: fecha de realizacion del pedido.<br>
	 * @param zona: zona en donde se efectuara el viaje.<br>
	 * @param mascota: valor booleano correspondiente al transporte de mascota.<br>
	 * @param equipaje: tipo de equipaje. <br>
	 * @param cantPersonas: cantidad de personas a transportar.<br>
	 * @param cliente: cliente que realiza el pedido.<br>
	 */
	public Pedido(String fecha, String zona, boolean mascota, boolean equipaje, int cantPersonas, Cliente cliente) {
		this.fecha = fecha;
		this.zona = zona;
		this.mascota = mascota;
		this.equipaje = equipaje;
		this.cantPersonas = cantPersonas;
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}
	public String getZona() {
		return zona;
	}
	public boolean getMascota() {
		return mascota;
	}
	public boolean getEquipaje() {
		return equipaje;
	}
	
	public boolean usoBaul() {
		return this.equipaje;
	}
	
	public int getCantPersonas() {
		return cantPersonas;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", zona=" + zona + ", mascota=" + mascota + ", equipaje=" + equipaje
				+ ", cantPersonas=" + cantPersonas + "]";
	}
}
