import java.time.LocalDate;
class TicketSoporte {
    private static int contadorId = 1;
    private int id;
    private String descripcion;
    private String estado;
    private LocalDate fechaCreacion;
    private String tecnicoAsignado;
    private Usuario usuario;

    public TicketSoporte(String descripcion) {
        this.id = contadorId++;
        this.descripcion = descripcion;
        this.estado = "Abierto";
        this.fechaCreacion = LocalDate.now();
    }

    public TicketSoporte(String descripcion, Usuario usuario) {
        this(descripcion);
        this.usuario = usuario;
    }

    public void cerrarTicket() {
        this.estado = "Cerrado";
    }

    public void asignarTecnico(String tecnico) {
        this.tecnicoAsignado = tecnico;
    }

    public String mostrarDetalle() {
        return "Ticket ID: " + id + ", Descripción: " + descripcion + ", Estado: " + estado +
                ", Fecha: " + fechaCreacion + ", Técnico: " + (tecnicoAsignado != null ? tecnicoAsignado
                : "No asignado") +
                (usuario != null ? ", Usuario: " + usuario.getNombre() : "");
    }
}
