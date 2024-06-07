package modelo.chofer;

public class ChoferThread extends Thread {
	private Chofer chofer;
	private int viajesRestantes;
	
	public ChoferThread(int viajesRestantes, Chofer chofer) {
		this.viajesRestantes = viajesRestantes;
		this.chofer = chofer;
	}

	@Override
	public void run() {
		while(Simulacion.getClientesActivos() > 0 && viajesRestantes > 0) {
			//tomar viaje
			
			this.viajesRestantes--;
			if(this.viajesRestantes == 0) {
				Simulacion.setChoferesActivos(Simulacion.getChoferesActivos() - 1);
			}
			
			//finaliza
		}
	}
}
