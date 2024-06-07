package modelo.sistema;

public class Simulacion {
	private RecursoCompartido rc;
	private static int clientesActivos;
	private static int choferesActivos;
	
	public RecursoCompartido getRc() {
		return rc;
	}
	
	public void setRc(RecursoCompartido rc) {
		this.rc = rc;
	}
	
	public static int getClientesActivos() {
		return clientesActivos;
	}
	
	public static void setClientesActivos(int clientesActivos) {
		Simulacion.clientesActivos = clientesActivos;
	}
	
	public static int getChoferesActivos() {
		return choferesActivos;
	}
	
	public static void setChoferesActivos(int choferesActivos) {
		Simulacion.choferesActivos = choferesActivos;
	}
	
}
