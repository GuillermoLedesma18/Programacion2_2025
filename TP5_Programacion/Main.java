public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(1, "Carlos Pérez", "carlos@example.com");
        Tecnico tecnico1 = new Tecnico(1, "Ana López", "Redes");

        TicketSoporte ticket1 = new TicketSoporte("Problema con la conexión a internet",
                usuario1);
        ticket1.asignarTecnico(tecnico1.getNombre());

        SistemaSoporte sistema = new SistemaSoporte();
        sistema.agregarTicket(ticket1);

        ticket1.cerrarTicket();

        sistema.listarTickets();
    }
}