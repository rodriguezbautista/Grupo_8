package vehiculo;

public class Automovil extends Vehiculo {

	public Automovil(String numpatente, int cantmaxpas, boolean petfriendly, boolean baul) {
		super(numpatente, cantmaxpas, petfriendly, baul);
	}
	
	public int califica(boolean pideBaul, int cantPax) {
		if (pideBaul) {
			return 40*cantPax;
		} else {
			return 30*cantPax;
		}
	}
	
}
