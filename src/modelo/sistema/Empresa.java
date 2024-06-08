package modelo.sistema;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.CredencialesInvalidasException;
import excepciones.PedidoRechazadoException;
import excepciones.UsuarioExistenteException;
import modelo.chofer.Chofer;
import modelo.usuario.Cliente;
import modelo.usuario.ClienteThreadLogeado;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.IViaje;
import modelo.viaje.SubsistemaViaje;


public class Empresa {
	private static Empresa instance = null;
	private RecursoCompartido recursoCompartido;
	private HashMap<String, Cliente> clientes;
	private ArrayList<Chofer> choferes;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<IViaje> viajes;
	private Cliente clienteLogeado;
	
	public static Empresa getInstance() {
		if (instance==null) 
			instance=new Empresa();
		return instance;
	}

    public void setRecursoCompartido(RecursoCompartido recursoCompartido) {
    	this.recursoCompartido = recursoCompartido;
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
		return recursoCompartido;
	}
	
	public void logearCliente(String usuario, String contrasenia) throws CredencialesInvalidasException{
		Cliente cliente = this.clientes.get(usuario);
		if (cliente == null || cliente.getContrasenia() != contrasenia)
			throw new CredencialesInvalidasException();
		this.clienteLogeado = cliente;
	}
	
	public void registrarCliente(String nombre, String usuario, String contrasenia) throws UsuarioExistenteException{
		if (this.clientes.get(usuario) == null) {
			throw new UsuarioExistenteException();
		}
		Cliente cliente = new Cliente(nombre, usuario, contrasenia);
		this.clientes.put(usuario, cliente);
		this.clienteLogeado = cliente;
	}

	public void solicitarViaje(double d, String zona, int cantidadPersonas, boolean usaBaul, boolean llevaMascota) throws PedidoRechazadoException {
		ClienteThreadLogeado cliente = new ClienteThreadLogeado(this.clienteLogeado);
		SubsistemaViaje.solicitarViaje(this.getRecursoCompartido(), cliente.getCliente(), d, zona, cantidadPersonas, usaBaul, llevaMascota);
	}
}
