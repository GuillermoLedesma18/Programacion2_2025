package Interfaces;

import java.util.ArrayList;

public class Pedido implements Pagable{
 private ArrayList<Producto> listaProductos;
 private Cliente cliente;
 private EstadoPedido estado;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
        this.estado = EstadoPedido.PENDIENTE;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.listaProductos = new ArrayList<>();
        this.estado = EstadoPedido.PENDIENTE;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : this.listaProductos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void agregarProducto(Producto producto){
        this.listaProductos.add(producto);
    }

    public void cambiarEstado(EstadoPedido estado){
        this.estado = estado;
        String mensaje = "El estado de su pedido cambio a " + estado.getNombre();
        cliente.notificar(mensaje);
    }
}
