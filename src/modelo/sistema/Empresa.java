package modelo.sistema;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.CredencialesInvalidasException;
import excepciones.PedidoRechazadoException;
import excepciones.SinChoferesException;
import excepciones.UsuarioExistenteException;
import excepciones.ViajeEnCursoException;
import excepciones.ViajeNoIniciadoException;
import modelo.chofer.Chofer;
import modelo.usuario.Cliente;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.IViaje;
import modelo.viaje.SubsistemaViaje;
import persistencia.ConfiguracionDAO;
import persistencia.EmpresaDAO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;

/**
 * Clase que modela el comportamiento y datos de la empresa.<br>
 */
public class Empresa {
	private static Empresa instance = null;
	private Simulacion simulacion;
	private HashMap<String, Cliente> clientes;
	private ArrayList<Chofer> choferes;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<IViaje> viajes;
	
	
	/**
	 * Constructor private. Garantiza que solo habra una instancia de este objeto.<br>
	 */
	private Empresa() {
		clientes = new HashMap<String, Cliente>();
		choferes = new ArrayList<Chofer>();
		vehiculos = new ArrayList<Vehiculo>();
		viajes = new ArrayList<IViaje>();
	}
	
	/**
	 * Singleton de la empresa. 
	 * @return Retorna una instancia de la empresa. Si la empresa no existe la crea y 
	 *         devuelve la referencia, si ya existe devuelve la referencia existente.
	 */
	public static Empresa getInstance() {
		if (instance==null) 
			instance=new Empresa();
		return instance;
	}

	public void setSimulacion(Simulacion simulacion) {
		this.simulacion = simulacion;
	}
    
	public HashMap<String, Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public ArrayList<IViaje> getViajes() {
		return viajes;
	}
	
	public ArrayList<IViaje> getViajes(Chofer chofer) {
		ArrayList<IViaje> viajesChofer = new ArrayList<IViaje>();
		
		for(IViaje viaje: viajes) {
			if (viaje.getChofer() == chofer) {
				viajesChofer.add(viaje);
			}
		}
		
		return viajesChofer;
	}

	public void addViaje(IViaje viaje) {
		viajes.add(viaje);
	}

	public void addCliente(Cliente cliente) {
		clientes.put(cliente.getUsuario(), cliente);
	}

	public void addChofer(Chofer chofer) {
		choferes.add(chofer);
	}

	public void addVehiculos(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}

	public RecursoCompartido getRecursoCompartido() {
		return this.simulacion.getRecursoCompartido();
	}
	
	/**
	 * Metodo que lgoguea a un cliente. Si el usuario y contrasenia son validas, loguea al cliente.
	 * Otro caso lanzara excepcion.<br>
	 * @param usuario: usuario a loguear <br>
	 * @param contrasenia: contrasenia del usuario <br>
	 * @throws CredencialesInvalidasException: excepcion que lanzara si el usuario y/o la contrasenia
	 * son invalidas <br>
	 * <br> Precondicion: Usuario diferente de null.<br>
	 * <br> Precondicion: Usuario diferente de vacio.<br>
	 * <br> Precondicion: Contrasenia diferente de null.<br>
	 * <br> Precondicion: Contrasenia diferente de vacio.<br>
	 * <br> Postcondicion: Cliente logueado o lanzamiento de excepcion.<br> 
	 */
	public void logearCliente(String usuario, String contrasenia) throws CredencialesInvalidasException{
		Cliente cliente = this.clientes.get(usuario);
		if (cliente == null || !cliente.getContrasenia().equals(contrasenia))
			throw new CredencialesInvalidasException("El nombre de usuario o la contraseña son invalidos, intente nuevamente");
		this.simulacion.setClienteLogeado(cliente);
	}
	
	/**
	 * Este metodo registra a un cliente. Si el cliente no existe, lo crea, sino lanza una excepcion.
	 * @param nombre: nombre real del cliente a registrar.<br>
	 * @param usuario: nombre de usuario del cliente a registrar.<br> 
	 * @param contrasenia: contrasenia del cliente a registrar.<br>
	 * @throws UsuarioExistenteException: Excepcion que se lanzara cuando las credenciales del cliente a 
	 * registrar correspondan a un cliente ya registrado.<br>
	 * <br> Precondicion: parametro nombre diferente de null y diferente de vacio.<br>
	 * <br> Precondicion: parametro usuario diferente de null y diferente de vacio.<br>
	 * <br> Precondicion: parametro contrasenia diferente de null y diferente de vacio.<br>
	 * <br> Postcondicion: Nuevo cliente registrado o lanzamiento de excepcion.<br>
	 */
	public void registrarCliente(String nombre, String usuario, String contrasenia) throws UsuarioExistenteException{
		if (this.clientes.get(usuario) != null) {
			throw new UsuarioExistenteException("El usuario " + usuario + " ya existe en el sistema, use otro nombre");
		}
		Cliente cliente = new Cliente(nombre, usuario, contrasenia);
		this.clientes.put(usuario, cliente);
		this.simulacion.setClienteLogeado(cliente);
	}
	
	/**
	 * Metodo que solicita un pedido. Si el pedido es rechazado lanzara una excepcion, sino, crea un viaje
	 * en situacion de solicitado. <br>
	 * @param d: distancia del recorrido del viaje.<br>
	 * @param zona: zona del viaje.<br>
	 * @param cantidadPersonas: cantidad de personas a transportar.<br>
	 * @param usaBaul: valor booleano correspondiante al uso del baul.<br>
	 * @param llevaMascota: valor booleano correspondiente al transporte de mascota.<br>
	 * @throws PedidoRechazadoException: excepcion que se lanzara cuando el pedido sea rechazado.<br>
	 * <br> Precondicion: parametro d mayor a 0.<br>
	 * <br> Precondicion: parametro cantidadpersonas mayor a 0.<br>
	 * <br> Precondicion: parametro zona diferente de null y diferente de vacio.<br>
	 * <br> Postcondicion: Se crea un nuevo viaje es situacion de solicitado o se lanza una excepcion.<br>
	 */
	public void solicitarViaje(double d, String zona, int cantidadPersonas, boolean usaBaul, boolean llevaMascota) throws PedidoRechazadoException, ViajeEnCursoException {
		if (this.simulacion.getViajeActualClienteLogeado() != null) {
			throw new ViajeEnCursoException("Usted tiene un viaje en curso, espere a que finalize para solicitar otro");
		}
		
		IViaje viaje;
		try {
			viaje = SubsistemaViaje.solicitarViaje(this.getRecursoCompartido(), this.simulacion.getClienteLogeado(), d, zona, cantidadPersonas, usaBaul, llevaMascota);
			this.simulacion.setViajeActualClienteLogeado(viaje);
		} catch (PedidoRechazadoException | SinChoferesException e) {
		}
	}
	
	public void pagarViaje() throws ViajeNoIniciadoException {
		IViaje viajeActual = this.simulacion.getViajeActualClienteLogeado();
		
		if (viajeActual == null || viajeActual.getStatus() != "iniciado") {
			throw new ViajeNoIniciadoException("El viaje aun no esta iniciado, no se puede pagar");
		}
		
		this.simulacion.pagarViaje(viajeActual);
		this.simulacion.setViajeActualClienteLogeado(null);
	}

	public void setConfiguracion(ConfiguracionSimulacion cs) {
		this.simulacion.setConfiguracion(cs);
	}

	public void iniciarSimulacion() {
		this.simulacion.iniciarSimulacion(this);
	}

	public Cliente getClienteLogeado() {
		return this.simulacion.getClienteLogeado();
	}

	public void persistir() {
		EmpresaDAO.persistir(this);
		ConfiguracionDAO.persistir(this.simulacion.getCS());
	}
	
	public void finalizarPrograma() {
		System.exit(0);
	}
}
