public class PruebaEmpleado {
    public static void main(String[] args) {
        // Instanciando objetos Empleado utilizando ambos constructores
        Empleado empleado1 = new Empleado(1, "Juan Pérez", "Gerente", 50000.0);
        Empleado empleado2 = new Empleado("Ana López", "Desarrolladora");

        // Utilizando los métodos sobrecargados para actualizar el salario
        empleado1.actualizarSalario(10);  // Aumento del 10% en el salario
        empleado2.actualizarSalario(2000, true);  // Aumento fijo de 2000 unidades

        // Imprimiendo la información de cada empleado mediante toString()
        System.out.println(empleado1.toString());
        System.out.println(empleado2.toString());

        // Mostrando el total de empleados creados utilizando el método estático
        System.out.println("Total de empleados creados: " + Empleado.mostrarTotalEmpleados());
    }
}
