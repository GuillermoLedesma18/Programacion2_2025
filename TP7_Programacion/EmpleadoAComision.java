public class EmpleadoAComision extends Empleado {
    private double salarioMinimo;
    private int cantClientesCaptados;
    private double montoPorCliente;

    public EmpleadoAComision(String DNI, String nombre, String apellido, int anioIngreso,
                             double salarioMinimo, int cantClientesCaptados, double montoPorCliente) {
        super(DNI, nombre, apellido, anioIngreso);
        this.salarioMinimo = salarioMinimo;
        this.cantClientesCaptados = cantClientesCaptados;
        this.montoPorCliente = montoPorCliente;
    }

    @Override
    public double getSalario() {
        double salario = cantClientesCaptados * montoPorCliente;
        return Math.max(salario, salarioMinimo);
    }

    public int getCantClientesCaptados() {
        return cantClientesCaptados;
    }
}
