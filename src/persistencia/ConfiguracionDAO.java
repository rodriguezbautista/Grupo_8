package persistencia;

import java.io.IOException;
import java.io.Serializable;

import modelo.sistema.ConfiguracionSimulacion;

public class ConfiguracionDAO {
private IPersistencia<Serializable> persistencia;
	
	public ConfiguracionDAO(IPersistencia<Serializable> persistencia) {
		this.persistencia = persistencia;
	}

	public void serializar(ConfiguracionSimulacion cs) {
		try {
			persistencia.abrirOutput("Configuracion.dat");
			persistencia.escribir(cs);
			persistencia.cerrarOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ConfiguracionSimulacion deserializar() {
		ConfiguracionSimulacion cs = null;
		try {
			persistencia.abrirInput("Configuracion.dat");
			cs = (ConfiguracionSimulacion) persistencia.leer();
			persistencia.cerrarInput();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cs;
	}
	
	public static void persistir(ConfiguracionSimulacion cs) {
		IPersistencia<Serializable> persistencia = new PersistenciaBIN();
		ConfiguracionDAO dao = new ConfiguracionDAO(persistencia);
		dao.serializar(cs);
	}
}
