package vehiculo;

public class Automovil extends Vehiculo {

	public Automovil(String numpatente, int cantmaxpas, boolean petfriendly, boolean baul) {
		super(numpatente, cantmaxpas, petfriendly, baul);
	}
	
	public int califica(boolean pideBaul, int cantPax) {
		return pideBaul ? (40*cantPax) : (30*cantPax);
	}
	
	

}
