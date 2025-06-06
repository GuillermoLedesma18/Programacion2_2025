package service;

import DAO.ItemPedidoDAOImpl;
import DAO.PedidoDAOImpl;
import DAO.ProductoDAOImpl;
import modelo.ItemPedido;
import modelo.Pedido;
import modelo.Producto;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PedidoServiceImpl {

    private PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
    private ItemPedidoDAOImpl itemPedidoDAO = new ItemPedidoDAOImpl();
    private ProductoDAOImpl productoDAO = new ProductoDAOImpl();

    public void crearPedido(Pedido pedido) throws SQLException {
        // Validar que haya al menos un ítem
        if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un ítem.");
        }

        // Validar cantidades y existencia de productos y stock
        for (ItemPedido item : pedido.getItems()) {
            if (item.getCantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad de cada ítem debe ser mayor a cero.");
            }

            Producto producto = productoDAO.leer(item.getProducto().getId());
            if (producto == null) {
                throw new IllegalArgumentException("El producto con ID " + item.getProducto().getId() + " no existe.");
            }

            if (producto.getCantidad() < item.getCantidad()) {
                throw new IllegalArgumentException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            if (producto.getCategoria() == null) {
                throw new IllegalArgumentException("El producto debe tener una categoría válida.");
            }
        }

        // Si pasa validaciones, hacer la transacción para insertar pedido y items
        Connection conn = null;
        try {
            conn = ConexionBD.conectar();
            conn.setAutoCommit(false);

            // Insertar pedido
            pedido.setFecha(LocalDate.now());
            pedido.setTotal(0.0);
            pedidoDAO.crear(pedido, conn);  // Modificar PedidoDAOImpl para aceptar conexión

            double totalPedido = 0.0;

            // Insertar items y descontar stock
            for (ItemPedido item : pedido.getItems()) {
                Producto producto = productoDAO.leer(item.getProducto().getId());

                // Calcular subtotal
                double subtotal = producto.getPrecio() * item.getCantidad();
                item.setSubtotal(subtotal);
                item.setPedido(pedido);  // Asociar el pedido con el item

                // Insertar item_pedido
                itemPedidoDAO.crear(item, conn);  // Modificar ItemPedidoDAOImpl para aceptar conexión

                // Descontar stock y actualizar producto
                producto.setCantidad(producto.getCantidad() - item.getCantidad());
                productoDAO.actualizar(producto, conn);  // Modificar ProductoDAOImpl para aceptar conexión

                totalPedido += subtotal;
            }

            // Actualizar total del pedido
            pedido.setTotal(totalPedido);
            pedidoDAO.actualizar(pedido, conn);

            conn.commit();

        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    public void mostrarDetallePedido(int pedidoId) throws SQLException {
        Pedido pedido = pedidoDAO.leer(pedidoId);
        if (pedido == null) {
            System.out.println("Pedido no encontrado");
            return;
        }

        System.out.println("Pedido ID: " + pedido.getId());
        System.out.println("Fecha: " + pedido.getFecha());
        System.out.println("Detalle:");

        List<ItemPedido> items = itemPedidoDAO.listarPorPedido(pedidoId); //
        for (ItemPedido item : items) {
            System.out.printf("Producto: %s | Categoría: %s | Cantidad: %d | Subtotal: %.2f\n",
                    item.getProducto().getNombre(),
                    item.getProducto().getCategoria().getNombre(),
                    item.getCantidad(),
                    item.getSubtotal());
        }
        System.out.println("Total del pedido: " + pedido.getTotal());
    }
}
