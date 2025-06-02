public class EmpleadoSalarioFijo extends Empleado {
    private static final double PORC1 = 0.05;
    private static final double PORC2 = 0.10;
    private double sueldoBasico;

    public EmpleadoSalarioFijo(String DNI, String nombre, String apellido, int anioIngreso, double sueldoBasico) {
        super(DNI, nombre, apellido, anioIngreso);
        this.sueldoBasico = sueldoBasico;
    }

    @Override
    public double getSalario() {
        int antiguedad = 2025 - anioIngreso;
        if (antiguedad >= 2 && antiguedad <= 5) {
            return sueldoBasico * (1 + PORC1);
        } else if (antiguedad > 5) {
            return sueldoBasico * (1 + PORC2);
        } else {
            return sueldoBasico;
        }
    }
}
