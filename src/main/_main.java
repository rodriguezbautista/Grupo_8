package main;

import java.io.Serializable;

import controlador.Controlador;
import modelo.sistema.Empresa;
import modelo.sistema.RecursoCompartido;
import modelo.sistema.Simulacion;
import persistencia.EmpresaDAO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import vista.IVista;
import vista.VentanaConfiguracionSimulacion;
import vista.VentanaLogin;

public class _main {

	public static void main(String[] args) {
		Empresa empresa = Empresa.getInstance();
		Simulacion simulacion = new Simulacion();
		RecursoCompartido recursoCompartido = new RecursoCompartido();
		simulacion.setRc(recursoCompartido);
		empresa.setRecursoCompartido(recursoCompartido);
		
		IPersistencia<Serializable> persistencia = new PersistenciaBIN();
		EmpresaDAO dao = new EmpresaDAO(persistencia);
		dao.deserializar();
		IVista vistaLogin = new VentanaLogin();
		VentanaConfiguracionSimulacion ventanaConfiguracion = new VentanaConfiguracionSimulacion();
		Controlador controlador = new Controlador(vistaLogin, ventanaConfiguracion);
		ventanaConfiguracion.start();
	}

}
