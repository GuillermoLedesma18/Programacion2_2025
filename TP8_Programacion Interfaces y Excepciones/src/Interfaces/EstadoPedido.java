package Interfaces;

public enum EstadoPedido {
    PENDIENTE("Pendiente"),
    ENVIADO("Enviado"),
    ETREGADO("Entregado");

    private String nombre;

    EstadoPedido(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
