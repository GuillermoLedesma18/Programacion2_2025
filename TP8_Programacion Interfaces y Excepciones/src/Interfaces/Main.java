package Interfaces;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Fideos Luchetti", 1500);
        Producto producto2 = new Producto("Arroz Tio Carlos", 1700);
        Cliente cliente = new Cliente("Pedro Paz", "pedropaz@example.com");

        Pedido miPedido = new Pedido(cliente);
        miPedido.agregarProducto(producto1);
        miPedido.agregarProducto(producto2);

        Pedido miPedido1 = new Pedido();
        miPedido1.agregarProducto(producto2);

        System.out.println("El total a pagar por el pedido es de $" + miPedido.calcularTotal());

        TarjetaCredito tarjeta = new TarjetaCredito("1111 3333 4444 5555");
        Paypal paypal = new Paypal("persona@example.com");

        tarjeta.procesarPago(miPedido.calcularTotal());
        tarjeta.aplicarDescuento(25);

        paypal.procesarPago(miPedido1.calcularTotal());
        paypal.aplicarDescuento(15);

        miPedido.cambiarEstado(EstadoPedido.ENVIADO);


    }
}