package chofer;

/**
 * Clase que representa a un chofer temporario de la empresa.
 * Esta clase extiende la clase Chofer y agrega características específicas para los choferes temporarios.
 */
public class ChoferTemporario extends Chofer {
	
	private static double sueldoBasico;
	private double aportes;
	private double plusXCantViajes;
	private int cantViajes;
	
	/**
     * Constructor para crear un ChoferTemporario.
     * @param dni El número de identificación del chofer.
     * @param nombre El nombre del chofer.
     * @param sueldoBasico El sueldo básico del chofer temporario.
     * @param aportes El porcentaje de descuento por aportes jubilatorios.
     * @param plusXCantViajes El porcentaje de aumento por cantidad de viajes realizados.
     * @param cantViajes La cantidad de viajes realizados por el chofer.
     */
	public ChoferTemporario(String dni, String nombre, float sueldobasico, float aportes, float plusxcantviajes, int cantviajes) {
		super(dni, nombre);
		this.sueldoBasico = sueldobasico;
		this.aportes = aportes;
		this.plusXCantViajes = plusxcantviajes;
		this.cantViajes = cantviajes;
	}
	/**
     * Método para obtener el sueldo de un chofer temporario.
     * Este método calcula el sueldo bruto del chofer temporario, teniendo en cuenta su sueldo básico,
     * el plus por cantidad de viajes realizados y los descuentos por aportes jubilatorios.
     * @return El sueldo neto del chofer temporario.
     */
	@Override
	public double getSueldo() {
		double sueldo = sueldoBasico;
		// Aquí se calcula el sueldo bruto (sueldo basico + pluses).
        sueldo += sueldoBasico * (plusXCantViajes / 100) * cantViajes;
     // Aquí se le restan los aportes al sueldo bruto.
        sueldo -= sueldo * (aportes / 100);
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

	public int getCantViajes() {
		return cantViajes;
	}

	public void setCantViajes(int cantViajes) {
		this.cantViajes = cantViajes;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}
	
	

}
