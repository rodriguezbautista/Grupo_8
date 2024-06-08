package modelo.chofer;

import modelo.sistema.Simulacion;

public class ChoferThread extends Thread {
	private Chofer chofer;
	private int viajesRestantes;
	
	public ChoferThread(int viajesRestantes, Chofer chofer) {
		this.viajesRestantes = viajesRestantes;
		this.chofer = chofer;
	}
	
	public int getViajesRestantes() {
		return this.viajesRestantes;
	}
	
	public String getNombre() {
		return this.chofer.getNombre();
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

	public Chofer getChoferDTO() {
		// TODO Auto-generated method stub
		return null;
	}
}
