package main;

import java.io.Serializable;

import controlador.Controlador;
import modelo.sistema.Empresa;
import modelo.sistema.OjoRecursoCompartido_VentanaGeneral;
import modelo.sistema.OjoRecursoCompartido_VentanaLogin;
import modelo.sistema.RecursoCompartido;
import modelo.sistema.Simulacion;
import persistencia.EmpresaDAO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import vista.IVista;
import vista.VentanaConfiguracionSimulacion;
import vista.VentanaGeneral;
import vista.VentanaLogin;

public class _main {

	public static void main(String[] args) {
		Empresa empresa = Empresa.getInstance();
		Simulacion simulacion = new Simulacion();
		RecursoCompartido recursoCompartido = new RecursoCompartido();
		simulacion.setRc(recursoCompartido);
		empresa.setSimulacion(simulacion);
		
		EmpresaDAO.despersistir();
		VentanaLogin vistaLogin = new VentanaLogin();
		VentanaConfiguracionSimulacion ventanaConfiguracion = new VentanaConfiguracionSimulacion();
		VentanaGeneral ventanaGeneral = new VentanaGeneral();
		
		Controlador controlador = new Controlador(vistaLogin, ventanaConfiguracion);
		OjoRecursoCompartido_VentanaGeneral ojoGeneral = new OjoRecursoCompartido_VentanaGeneral(recursoCompartido, ventanaGeneral);
		OjoRecursoCompartido_VentanaLogin ojoLogeado = new OjoRecursoCompartido_VentanaLogin(recursoCompartido, vistaLogin);
		
		ventanaGeneral.setVisible(true);
		ventanaConfiguracion.setVisible(true);
	}

}
