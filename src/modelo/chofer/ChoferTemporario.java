package modelo.chofer;

import modelo.usuario.Empresa;

/**
 * Clase que representa a un chofer temporario de la empresa.
 * Esta clase extiende la clase Chofer y agrega características específicas para los choferes temporarios.
 */
public class ChoferTemporario extends Chofer {
	
	private static double sueldoBasico = 2000;
	private double aportes;
	private double plusXCantViajes;
	
	/**
     * Constructor para crear un ChoferTemporario.
     * @param dni El número de identificación del chofer.
     * @param nombre El nombre del chofer.
     * @param sueldoBasico El sueldo básico del chofer temporario.
     * @param aportes El porcentaje de descuento por aportes jubilatorios.
     * @param plusXCantViajes El porcentaje de aumento por cantidad de viajes realizados.
     * @param cantViajes La cantidad de viajes realizados por el chofer.
     */
	public ChoferTemporario(String nombre, String dni) {
		super(nombre, dni);
	}
	/**
     * Método para obtener el sueldo de un chofer temporario.
     * Este método calcula el sueldo bruto del chofer temporario, teniendo en cuenta su sueldo básico,
     * el plus por cantidad de viajes realizados y los descuentos por aportes jubilatorios.
     * @return El sueldo neto del chofer temporario.
     */
	@Override
	public double getSueldo(Empresa empresa) {
		double sueldo = sueldoBasico;
		
		// Aquí se calcula el sueldo bruto (sueldo basico + pluses).
        sueldo += sueldoBasico * plusXCantViajes * empresa.getViajes(this).size();
        
        // Aquí se le restan los aportes al sueldo bruto.
        sueldo -= sueldo * aportes;
        
        return sueldo;
	}

	public double getAportes() {
		return aportes;
	}

	public void setAportes(double aportes) {
		this.aportes = aportes;
	}

	public double getPlusXCantViajes() {
		return plusXCantViajes;
	}

	public void setPlusXCantViajes(double plusXCantViajes) {
		this.plusXCantViajes = plusXCantViajes;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}
}
