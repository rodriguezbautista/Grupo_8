package modelo.sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import excepciones.VehiculoInexistenteException;
import modelo.chofer.Chofer;
import modelo.chofer.ChoferFactory;
import modelo.chofer.ChoferThread;
import modelo.usuario.Cliente;
import modelo.usuario.ClienteThreadRobot;
import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;
import modelo.vehiculo.VehiculoFactory;
import persistencia.ConfiguracionDAO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;

/**
 * Clase que modela la simulacion.<br>
 */
public class Simulacion {
	private RecursoCompartido rc;
	private ConfiguracionSimulacion cs;
	private static int clientesActivos;
	private static int choferesActivos;
	
	public RecursoCompartido getRc() {
		return rc;
	}
	
	public void setRc(RecursoCompartido rc) {
		this.rc = rc;
	}
	
	public static int getClientesActivos() {
		return Simulacion.clientesActivos;
	}
	
	public static void setClientesActivos(int clientesActivos) {
		Simulacion.clientesActivos = clientesActivos;
	}
	
	public static int getChoferesActivos() {
		return Simulacion.choferesActivos;
	}
	
	public static void setChoferesActivos(int choferesActivos) {
		Simulacion.choferesActivos = choferesActivos;
	}

	public RecursoCompartido getRecursoCompartido() {
		return this.rc;
	}

	public void setConfiguracion(ConfiguracionSimulacion cs) {
		if (cs == null) {
			IPersistencia<Serializable> persistencia = new PersistenciaBIN();
			ConfiguracionDAO dao = new ConfiguracionDAO(persistencia);
			ConfiguracionSimulacion csPersistido = dao.deserializar();
			this.cs = csPersistido;
		}
		
		//recupero los datos de la empresa
		else {
			this.cs = cs;
		}
	}

	public void iniciarSimulacion(Empresa empresa) {
		ArrayList<Chofer> choferes = empresa.getChoferes();
		String[] tiposChofer = new String[]{"Permanente", "Temporario", "Contratado"};
		HashMap<String, Cliente> clientes = empresa.getClientes();
		Iterator<Vehiculo> iterator;
		Simulacion.setChoferesActivos(this.cs.getCantidadChoferes());
		Simulacion.setClientesActivos(this.cs.getCantidadClientes());
		
		//Meto motos a la simulacion
		
		//Inicializo el iterator de vehiculos
		iterator = ((ArrayList<Vehiculo>) empresa.getVehiculos().clone()).iterator();
		for (int i = 0; i < this.cs.getCantidadMotos(); i++) {
			Vehiculo vehiculo = null;
			
			//Recorre el iterator de vehiculos que tiene la empresa hasta encontrar una moto
			while(iterator.hasNext() && vehiculo == null) {
				vehiculo = iterator.next();
				
				//Si el vehiculo NO es una moto, le asigno nuevamente null
				if (vehiculo.califica(false, 1) != 1000)
					vehiculo = null;
			}
			
			//Si encontre una moto en la empresa, la agrego al recurso compartido, sino creo una moto y la agrego al recurso compartido y a la empresa 
			if (vehiculo != null)
				this.rc.agregarVehiculo(vehiculo);
			else {
				vehiculo = VehiculoFactory.getVehiculo("Moto", "123abc");
				empresa.addVehiculos(vehiculo);
				this.rc.agregarVehiculo(vehiculo);
			}
		}
		

		//Meto autos a la simulacion
		
		//Inicializo el iterator de vehiculos
		iterator = ((ArrayList<Vehiculo>) empresa.getVehiculos().clone()).iterator();
		for (int i = 0; i < this.cs.getCantidadAutos(); i++) {
			Vehiculo vehiculo = null;
			
			//Recorre el iterator de vehiculos que tiene la empresa hasta encontrar un automovil
			while(iterator.hasNext() && vehiculo == null) {
				vehiculo = iterator.next();
				
				//Si el vehiculo NO es un automovil, le asigno nuevamente null
				if (vehiculo.califica(false, 1) != 30)
					vehiculo = null;
			}
			
			//Si encontre un automovil en la empresa, lo agrego al recurso compartido, sino creo uno y lo agrego al recurso compartido y a la empresa 
			if (vehiculo != null)
				this.rc.agregarVehiculo(vehiculo);
			else {
				vehiculo = VehiculoFactory.getVehiculo("Automovil", "123abc");
				empresa.addVehiculos(vehiculo);
				this.rc.agregarVehiculo(vehiculo);
			}
		}

		//Meto combis a la simulacion
		
		//Inicializo el iterator de vehiculos
		iterator = ((ArrayList<Vehiculo>) empresa.getVehiculos().clone()).iterator();
		for (int i = 0; i < this.cs.getCantidadAutos(); i++) {
			Vehiculo vehiculo = null;
			
			//Recorre el iterator de vehiculos que tiene la empresa hasta encontrar una combi
			while(iterator.hasNext() && vehiculo == null) {
				vehiculo = iterator.next();
				
				//Si el vehiculo NO es una combi, le asigno nuevamente null
				if (vehiculo.califica(false, 1) != 10)
					vehiculo = null;
			}
			
			//Si encontre una combi en la empresa, la agrego al recurso compartido, sino creo una combi y la agrego al recurso compartido y a la empresa 
			if (vehiculo != null)
				this.rc.agregarVehiculo(vehiculo);
			else {
				vehiculo = VehiculoFactory.getVehiculo("Combi", "123abc");
				empresa.addVehiculos(vehiculo);
				this.rc.agregarVehiculo(vehiculo);
			}
		}

		//Meto choferes a la simulacion

		for (int i = 0; i < this.cs.getCantidadChoferes(); i++) {
			int vueltas = Util.aleatorio(1, this.cs.getCantidadMaximaViajesChofer());
			ChoferThread choferThread;
			
			//Tomo los choferes que existan de la empresa y, si necesito mas, los creo
			if (choferes.size() > i)
				choferThread = new ChoferThread(choferes.get(i), vueltas, this.rc);
			else {
				Chofer chofer = ChoferFactory.getChofer("Chofer " + (i + 1) , Util.dniAleatorio(), tiposChofer[Util.aleatorio(2)]);
				empresa.addChofer(chofer);
				choferThread = new ChoferThread(chofer, vueltas, this.rc);
			}

			choferThread.start();
		}

		//Meto clientes robot a la simulacion

		for (int i = 1; i <= this.cs.getCantidadClientes(); i++) {
			int vueltas = Util.aleatorio(1, this.cs.getCantidadMaximaViajesCliente());
			ClienteThreadRobot clienteThread;
			
			//Si existe un cliente robot en la empresa, creo un hilo para el
			if (clientes.containsKey("Cliente " + i)) {		
				clienteThread = new ClienteThreadRobot(clientes.get("Cliente " + i), vueltas, this.rc);
			}
			
			//Sino, creo un nuevo cliente y creo un hilo para el
			else {
				Cliente cliente = new Cliente("Cliente " + i, "Cliente " + i, "");
				empresa.addCliente(cliente);
				clienteThread = new ClienteThreadRobot(cliente, vueltas, this.rc);
			}
			clienteThread.start();
		}
		
		SistemaThread sistemaThread = new SistemaThread(rc); 
		sistemaThread.start();
	}
}
