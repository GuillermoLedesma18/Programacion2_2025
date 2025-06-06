package DAO;

import modelo.ItemPedido;
import modelo.Producto;
import modelo.Pedido;          // Importar Pedido para setear en ItemPedido si es necesario
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAOImpl implements GenericDAO<ItemPedido> {

    // Insertar un nuevo ItemPedido en la base
    @Override
    public void crear(ItemPedido item) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            crear(item, con);
        }
    }

    public void crear(ItemPedido item, Connection con) throws SQLException {
        String sql = "INSERT INTO item_pedido (id_pedido, id_producto, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, item.getPedido().getId());      // <-- Ojo que ItemPedido debe tener getPedido()
            ps.setInt(2, item.getProducto().getId());
            ps.setInt(3, item.getCantidad());
            ps.setDouble(4, item.getSubtotal());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    item.setId(rs.getInt(1));
                }
            }
        }
    }

    // Leer un ItemPedido por su ID (requerido por GenericDAO)
    @Override
    public ItemPedido leer(int id) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            return leer(id, con);
        }
    }

    // Implementación interna que recibe la conexión
    public ItemPedido leer(int id, Connection con) throws SQLException {
        String sql = "SELECT ip.*, p.id AS p_id, p.nombre AS p_nombre, p.descripcion, p.precio, p.cantidad AS p_cantidad, " +
                "c.id AS c_id, c.nombre AS c_nombre, ip.id_pedido " +
                "FROM item_pedido ip " +
                "JOIN productos p ON ip.id_producto = p.id " +
                "JOIN categorias c ON p.id_categoria = c.id " +
                "WHERE ip.id = ?";

        ItemPedido itemPedido = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto producto = new Producto();
                    producto.setId(rs.getInt("p_id"));
                    producto.setNombre(rs.getString("p_nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setCantidad(rs.getInt("p_cantidad"));

                    var categoria = new modelo.Categoria();
                    categoria.setId(rs.getInt("c_id"));
                    categoria.setNombre(rs.getString("c_nombre"));
                    producto.setCategoria(categoria);

                    itemPedido = new ItemPedido();
                    itemPedido.setId(rs.getInt("id"));
                    itemPedido.setCantidad(rs.getInt("cantidad"));
                    itemPedido.setSubtotal(rs.getDouble("subtotal"));
                    itemPedido.setProducto(producto);

                    // Seteamos el pedido para evitar errores de getPedido()
                    Pedido pedido = new Pedido();
                    pedido.setId(rs.getInt("id_pedido"));
                    itemPedido.setPedido(pedido);
                }
            }
        }
        return itemPedido;
    }

    @Override
    public void actualizar(ItemPedido item) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            actualizar(item, con);
        }
    }

    public void actualizar(ItemPedido item, Connection con) throws SQLException {
        String sql = "UPDATE item_pedido SET id_pedido = ?, id_producto = ?, cantidad = ?, subtotal = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, item.getPedido().getId());
            ps.setInt(2, item.getProducto().getId());
            ps.setInt(3, item.getCantidad());
            ps.setDouble(4, item.getSubtotal());
            ps.setInt(5, item.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            eliminar(id, con);
        }
    }

    public void eliminar(int id, Connection con) throws SQLException {
        String sql = "DELETE FROM item_pedido WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<ItemPedido> listar() throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            return listar(con);
        }
    }

    public List<ItemPedido> listar(Connection con) throws SQLException {
        String sql = "SELECT ip.*, p.id AS p_id, p.nombre AS p_nombre, p.descripcion, p.precio, p.cantidad AS p_cantidad, " +
                "c.id AS c_id, c.nombre AS c_nombre " +
                "FROM item_pedido ip " +
                "JOIN productos p ON ip.id_producto = p.id " +
                "JOIN categorias c ON p.id_categoria = c.id ";

        List<ItemPedido> items = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("p_id"));
                producto.setNombre(rs.getString("p_nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("p_cantidad"));

                var categoria = new modelo.Categoria();
                categoria.setId(rs.getInt("c_id"));
                categoria.setNombre(rs.getString("c_nombre"));
                producto.setCategoria(categoria);

                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setId(rs.getInt("id"));
                itemPedido.setCantidad(rs.getInt("cantidad"));
                itemPedido.setSubtotal(rs.getDouble("subtotal"));
                itemPedido.setProducto(producto);

                // Setear pedido básico para evitar errores en getters
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                itemPedido.setPedido(pedido);

                items.add(itemPedido);
            }
        }

        return items;
    }

    // Método extra para listar items por id de pedido
    public List<ItemPedido> listarPorPedido(int pedidoId) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            return listarPorPedido(pedidoId, con);
        }
    }

    public List<ItemPedido> listarPorPedido(int pedidoId, Connection con) throws SQLException {
        String sql = "SELECT ip.*, p.id AS p_id, p.nombre AS p_nombre, p.descripcion, p.precio, p.cantidad AS p_cantidad, " +
                "c.id AS c_id, c.nombre AS c_nombre " +
                "FROM item_pedido ip " +
                "JOIN productos p ON ip.id_producto = p.id " +
                "JOIN categorias c ON p.id_categoria = c.id " +
                "WHERE ip.id_pedido = ?";

        List<ItemPedido> items = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setId(rs.getInt("p_id"));
                    producto.setNombre(rs.getString("p_nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setCantidad(rs.getInt("p_cantidad"));

                    var categoria = new modelo.Categoria();
                    categoria.setId(rs.getInt("c_id"));
                    categoria.setNombre(rs.getString("c_nombre"));
                    producto.setCategoria(categoria);

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setId(rs.getInt("id"));
                    itemPedido.setCantidad(rs.getInt("cantidad"));
                    itemPedido.setSubtotal(rs.getDouble("subtotal"));
                    itemPedido.setProducto(producto);

                    Pedido pedido = new Pedido();
                    pedido.setId(pedidoId);
                    itemPedido.setPedido(pedido);

                    items.add(itemPedido);
                }
            }
        }

        return items;
    }
}
