package vehiculo;

public class VehiculoFactory {
	public Vehiculo getVehiculo(String tipo,String patente) {
		if (tipo=="Automovil") 
			return new Automovil(patente,4,true,true);
		if (tipo=="Moto")
			return new Moto(patente,1,false,false);
		if (tipo=="Combi")
			return new Combi(patente,10,false,true);
		return null;
	}
}
