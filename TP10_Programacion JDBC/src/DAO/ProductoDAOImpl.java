package DAO;

import modelo.Categoria;
import modelo.Producto;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements GenericDAO<Producto> {



    // Crear con conexión propia (normal)
    @Override
    public void crear(Producto p) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            crear(p, con);
        }
    }

    // Crear con conexión pasada (para transacción)
    public void crear(Producto p, Connection con) throws SQLException {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, cantidad, id_categoria) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.setInt(5, p.getCategoria().getId());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
            }
        }
    }

    // Leer por id (conexión propia)
    @Override
    public Producto leer(int id) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            return leer(id, con);
        }
    }

    // Leer con conexión pasada
    public Producto leer(int id, Connection con) throws SQLException {
        String sql = "SELECT p.*, c.id AS c_id, c.nombre AS c_nombre FROM productos p " +
                "JOIN categorias c ON p.id_categoria = c.id WHERE p.id = ?";
        Producto producto = null;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("c_id"));
                    categoria.setNombre(rs.getString("c_nombre"));

                    producto = new Producto();
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setCantidad(rs.getInt("cantidad"));
                    producto.setCategoria(categoria);
                }
            }
        }
        return producto;
    }

    // Actualizar con conexión propia
    @Override
    public void actualizar(Producto p) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            actualizar(p, con);
        }
    }

    // Actualizar con conexión pasada
    public void actualizar(Producto p, Connection con) throws SQLException {
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, cantidad = ?, id_categoria = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.setInt(5, p.getCategoria().getId());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
        }
    }

    // Eliminar con conexión propia
    @Override
    public void eliminar(int id) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            eliminar(id, con);
        }
    }

    // Eliminar con conexión pasada
    public void eliminar(int id, Connection con) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // Listar con conexión propia
    @Override
    public List<Producto> listar() throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            return listar(con);
        }
    }

    // Listar con conexión pasada
    public List<Producto> listar(Connection con) throws SQLException {
        String sql = "SELECT p.*, c.id AS c_id, c.nombre AS c_nombre FROM productos p " +
                "JOIN categorias c ON p.id_categoria = c.id";
        List<Producto> productos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("c_id"));
                categoria.setNombre(rs.getString("c_nombre"));

                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setCategoria(categoria);

                productos.add(producto);
            }
        }
        return productos;
    }

    // Listar por categoría con conexión propia
    public List<Producto> listarPorCategoria(int idCategoria) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            return listarPorCategoria(idCategoria, con);
        }
    }

    // Listar por categoría con conexión pasada
    public List<Producto> listarPorCategoria(int idCategoria, Connection con) throws SQLException {
        String sql = "SELECT p.*, c.id AS c_id, c.nombre AS c_nombre FROM productos p " +
                "JOIN categorias c ON p.id_categoria = c.id WHERE c.id = ?";
        List<Producto> productos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("c_id"));
                    categoria.setNombre(rs.getString("c_nombre"));

                    Producto producto = new Producto();
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setCantidad(rs.getInt("cantidad"));
                    producto.setCategoria(categoria);

                    productos.add(producto);
                }
            }
        }
        return productos;
    }

    // Existe categoría con conexión propia
    public boolean existeCategoria(int idCategoria) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            return existeCategoria(idCategoria, con);
        }
    }

    // Existe categoría con conexión pasada
    public boolean existeCategoria(int idCategoria, Connection con) throws SQLException {
        String sql = "SELECT 1 FROM categorias WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}
