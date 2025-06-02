import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    // B) Mostrar salarios
    public void mostrarSalarios() {
        System.out.println("💼 Salarios de empleados:");
        for (Empleado e : empleados) {
            System.out.println(e.getNombreCompleto() + " - $" + e.getSalario());
        }
    }

    // C) Empleado con más clientes
    public Empleado empleadoConMasClientes() {
        EmpleadoAComision mejor = null;
        for (Empleado e : empleados) {
            if (e instanceof EmpleadoAComision) {
                EmpleadoAComision ec = (EmpleadoAComision) e;
                if (mejor == null || ec.getCantClientesCaptados() > mejor.getCantClientesCaptados()) {
                    mejor = ec;
                }
            }
        }
        return mejor;
    }
}
