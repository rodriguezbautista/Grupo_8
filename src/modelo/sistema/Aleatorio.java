package modelo.sistema;

import java.util.Random;

public class Aleatorio {
	private static final Random r = new Random();

	public static int aleatorio() {
		int numero = r.nextInt(5) + 1;
		return numero;
	}
}
