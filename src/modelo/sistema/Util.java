package modelo.sistema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public abstract class Util
{
	private static Random r = new Random();

	public static void espera(int milisegundos)
	{
		try
		{
			Thread.sleep(milisegundos);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void espera()
	{
		Util.espera(r.nextInt(7000) + 3000);
	}
	
	public static int aleatorio(int max) {
		return r.nextInt(max);
	}

	public static String fechaActual() {
		LocalDateTime fechaActual = LocalDateTime.now();;
		return fechaActual.getDayOfMonth() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear() + " - " + fechaActual.getHour() + ":" + fechaActual.getMinute();
	}
}
