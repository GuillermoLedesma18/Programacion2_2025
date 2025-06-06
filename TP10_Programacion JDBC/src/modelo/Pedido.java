package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDate fecha;
    private double total;
    private List<ItemPedido> items;

    public Pedido() {
        items = new ArrayList<>();
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public List<ItemPedido> getItems() { return items; }
    public void setItems(List<ItemPedido> items) { this.items = items; }

    // Métodos para agregar items y calcular total
    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    public void calcularTotal() {
        total = 0;
        for (ItemPedido item : items) {
            total += item.getSubtotal();
        }
    }
}
