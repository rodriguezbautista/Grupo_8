package persistencia;

import java.io.IOException;
import java.io.Serializable;

import modelo.chofer.Chofer;
import modelo.sistema.Empresa;
import modelo.usuario.Cliente;
import modelo.vehiculo.Vehiculo;
import modelo.viaje.IViaje;

public class EmpresaDAO {
	private IPersistencia<Serializable> persistencia;
	
	public EmpresaDAO(IPersistencia<Serializable> persistencia) {
		this.persistencia = persistencia;
	}

	public EmpresaDTO EmpresaDTOfromEmpresa(Empresa empresa) {
		EmpresaDTO dto = new EmpresaDTO();
		dto.setChoferes(empresa.getChoferes());
		dto.setClientes(empresa.getClientes());
		dto.setVehiculos(empresa.getVehiculos());
		dto.setViajes(empresa.getViajes());
		
		return dto;
	}
	
	public void EmpresafromEmpresaDTO(EmpresaDTO empresaDTO) {
		Empresa empresa = Empresa.getInstance();
		for(IViaje viaje: empresaDTO.getViajes()){
			empresa.addViaje(viaje);
		}
		for(Cliente cliente: empresaDTO.getClientes().values()) {
			empresa.addCliente(cliente);
		}
		for(Chofer chofer: empresaDTO.getChoferes()) {
			empresa.addChofer(chofer);
		}
		for(Vehiculo vehiculo: empresaDTO.getVehiculos()) {
			empresa.addVehiculos(vehiculo);
		}
	}
	
	public void serializar(Empresa empresa) {
		try {
			persistencia.abrirOutput("Empresa.dat");
			EmpresaDTO edto= this.EmpresaDTOfromEmpresa(empresa);
			persistencia.escribir(edto);
			persistencia.cerrarOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deserializar() {
		try {
			persistencia.abrirInput("Empresa.dat");
			EmpresaDTO edto = (EmpresaDTO) persistencia.leer();
			persistencia.cerrarInput();
			this.EmpresafromEmpresaDTO(edto);
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void despersistir() {
		IPersistencia<Serializable> persistencia = new PersistenciaBIN();
		EmpresaDAO dao = new EmpresaDAO(persistencia);
		dao.deserializar();
	}

	public static void persistir(Empresa empresa) {
		IPersistencia<Serializable> persistencia = new PersistenciaBIN();
		EmpresaDAO dao = new EmpresaDAO(persistencia);
		dao.serializar(empresa);
	}
}
