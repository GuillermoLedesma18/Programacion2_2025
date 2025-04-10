public class Empleado {
    // Atributos
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados = 0; // Atributo estático

    // Constructor que recibe todos los atributos como parámetros
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++; // Incrementa el contador estático
    }

    // Constructor que recibe solo nombre y puesto, asignando un id automático y salario por defecto
    public Empleado(String nombre, String puesto) {
        this.id = totalEmpleados + 1;  // Asigna un ID único, incrementando el contador
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 30000.0;  // Salario por defecto
        totalEmpleados++; // Incrementa el contador estático
    }

    // Método sobrecargado para actualizar el salario con un porcentaje
    public void actualizarSalario(double porcentaje) {
        this.salario += this.salario * porcentaje / 100;
    }

    // Método sobrecargado para actualizar el salario con una cantidad fija
    public void actualizarSalario(double cantidadFija, boolean esFija) {
        if (esFija) {
            this.salario += cantidadFija;
        }
    }

    // Método estático para mostrar el total de empleados creados
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    // Sobrescritura del método toString para mostrar la información del empleado
    @Override
    public String toString() {
        return "Empleado [ID: " + id + ", Nombre: " + nombre + ", Puesto: " + puesto + ", Salario: " + salario + "]";
    }
}
