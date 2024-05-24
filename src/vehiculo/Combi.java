package vehiculo;

public class Combi extends Vehiculo{

	public Combi(String numpatente, int cantmaxpas, boolean petfriendly, boolean baul) {
		super(numpatente, cantmaxpas, petfriendly, baul);
	}
	
	public int califica(boolean pideBaul, int cantPax) {
		return pideBaul ? (10*cantPax + 100) : (10*cantPax);
	}
	
}
