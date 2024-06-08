package vista;

import java.awt.event.ActionListener;

public interface IVista {
	public void setActionListener(ActionListener actionlistener);
	public void deshabilitarBotones();
	public void limpiarCamposPedido();
	public void appendLog(String mensaje);
	public void limpiarCamposRegistrarse();
	public void limpiarCamposLogin();
	public void habilitarBtnFinalizarPedidos();
	public void habilitarPanelLogin();
	public void habilitarPanelPedidos();
}
