package modelo.sistema;

public class InfoVentanaGeneral {
	private String evento;
	private String cartel;
	
	public InfoVentanaGeneral(String evento, String cartel) {
		this.evento = evento;
		this.cartel = cartel;
	}
	
	public String getEvento() {
		return this.evento;
	}
	
	public String getCartel() {
		return this.cartel;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public void setCartel(String cartel) {
		this.cartel = cartel;
	}
}
