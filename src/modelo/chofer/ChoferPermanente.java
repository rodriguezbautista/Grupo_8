package modelo.chofer;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import modelo.usuario.Empresa;

/**
 * Clase que representa a un chofer permanente de la empresa.
 * Esta clase extiende la clase Chofer y agrega características específicas para los choferes permanentes.
 */
public class ChoferPermanente extends Chofer {

	private static double sueldoBasico = 2000;
    private double plusXAntiguedad;
    private double plusXHijos;
    private double aportes;
    private int cantHijos;
    private String fechaIngreso;

    /**
     * Constructor para crear un ChoferPermanente.
     * @param dni El número de identificación del chofer.
     * @param nombre El nombre del chofer.
     * @param sueldoBasico El sueldo básico del chofer permanente.
     * @param plusXAntiguedad El porcentaje de aumento por antigüedad.
     * @param plusXHijos El porcentaje de aumento por cantidad de hijos.
     * @param aportes El porcentaje de descuento por aportes jubilatorios.
     * @param fechaIngreso La fecha de ingreso del chofer a la empresa.
     */
    public ChoferPermanente(String dni, String nombre, double sueldoBasico, double plusXAntiguedad, double plusXHijos, double aportes, int cantHijos, String fechaIngreso) {
    	super(dni, nombre);
    	this.plusXAntiguedad = plusXAntiguedad;
    	this.plusXHijos = plusXHijos;
    	this.aportes = aportes;
    	this.fechaIngreso = fechaIngreso;
    	this.cantHijos = cantHijos;
    }
    
    /**
     * Método para obtener el sueldo de un chofer permanente.
     * Este método calcula el sueldo bruto del chofer permanente, teniendo en cuenta su sueldo básico,
     * los pluses por antigüedad y cantidad de hijos, y los descuentos por aportes jubilatorios.
     * @return El sueldo neto del chofer permanente.
    */
    public int getAntiguedad(String fechaDeIngreso) {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	  //String fecha="22/11/2000";
	  LocalDate fechaIngreso = LocalDate.parse(fechaDeIngreso, formato);
	  LocalDate fechaActual = LocalDate.now();

	  Period antiguedad = Period.between(fechaIngreso, fechaActual);
	  
	  return antiguedad.getYears();
	 }
    @Override
    public double getSueldo(Empresa empresa) {
        double sueldo = sueldoBasico;
        // Aquí se calcula el sueldo bruto (sueldo basico + pluses).
        sueldo += sueldoBasico * plusXAntiguedad *getAntiguedad(this.fechaIngreso);
        sueldo += sueldoBasico * plusXHijos * cantHijos;
        // Aquí se le restan los aportes al sueldo bruto.
        sueldo -= sueldo * aportes;
        return sueldo;
    }

	public double getPlusXAntiguedad() {
		return plusXAntiguedad;
	}

	public void setPlusXAntiguedad(double plusXAntiguedad) {
		this.plusXAntiguedad = plusXAntiguedad;
	}

	public double getPlusXHijos() {
		return plusXHijos;
	}

	public void setPlusXHijos(double plusXHijos) {
		this.plusXHijos = plusXHijos;
	}

	public double getAportes() {
		return aportes;
	}

	public void setAportes(double aportes) {
		this.aportes = aportes;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}
    
}
