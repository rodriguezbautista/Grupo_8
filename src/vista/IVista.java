package vista;

import java.awt.event.ActionListener;

public interface IVista {
	public void setActionListener(ActionListener actionlistener);
	public void deshabilitarBotones();
	public void limpiarCamposPedido();
	public void appendLog(String mensaje);
}
