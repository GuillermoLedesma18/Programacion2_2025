public abstract class Empleado {
    protected String DNI;
    protected String nombre;
    protected String apellido;
    protected int anioIngreso;

    public Empleado(String DNI, String nombre, String apellido, int anioIngreso) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioIngreso = anioIngreso;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public abstract double getSalario();
}
