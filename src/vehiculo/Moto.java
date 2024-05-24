package vehiculo;

public class Moto extends Vehiculo {

	public Moto(String numpatente, int cantmaxpas, boolean petfriendly, boolean baul) {
		super(numpatente, cantmaxpas, petfriendly, baul);
	}

	public int califica(boolean pideBaul, int cantPax) {
		return 1000;
	}
	

}
