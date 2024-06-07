package persistencia;

import modelo.usuario.Empresa;

public class EmpresaDAO {
	public static EmpresaDTO EmpresaDTOfromEmpresa(Empresa empresa) {
		EmpresaDTO dto = new EmpresaDTO();
		//Aca iria todos los setter de el dto tomando los datos de la empresa
		return dto;
	}
	
	public static Empresa EmpresafromEmpresaDTO(EmpresaDTO empresaDTO) {
		Empresa empresa = Empresa.getInstance();
		//Aca iria todos los setter de la empresa tomando los datos de la empresa
		return empresa;
	}
}
