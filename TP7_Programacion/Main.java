public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        Empleado e1 = new EmpleadoSalarioFijo("12345678", "Ana", "Pérez", 2020, 80000);
        Empleado e2 = new EmpleadoAComision("87654321", "Luis", "Gómez", 2018, 50000, 10, 6000);
        Empleado e3 = new EmpleadoAComision("11223344", "Carla", "López", 2022, 40000, 15, 4000);

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);

        empresa.mostrarSalarios();

        Empleado top = empresa.empleadoConMasClientes();
        if (top != null) {
            System.out.println("\n👑 Empleado con más clientes: " + top.getNombreCompleto());
        }
    }
}
