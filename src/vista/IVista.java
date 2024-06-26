package vista;

import java.awt.event.ActionListener;

public interface IVista {
	public void setActionListener(ActionListener actionlistener);
	public void deshabilitarBotones();
	public void limpiarCamposPedido();
	public void appendLog(String mensaje);
	public void limpiarCamposRegistrarse();
	public void limpiarCamposLogin();
	public void habilitarBtnFinalizarPedidos(boolean b);
	public void habilitarPanelLogin(boolean b);
	public void habilitarPanelPedidos(boolean b);
	int getCantidadPersonas();
	boolean getUsaBaul();
	boolean getLlevaMascota();
	String getZona();
	public void setVisible(boolean b);
	public String getNombreRegistrado();
	public String getUsuarioRegistrado();
	public String getContraseniaRegistrado();
	public String getUsuarioLogeado();
	public String getContraseniaLogeado();
	public void popup(String string);
}
