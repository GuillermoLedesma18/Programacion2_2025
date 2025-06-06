package DAO;

import modelo.Pedido;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl implements GenericDAO<Pedido> {

    @Override
    public void crear(Pedido p) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            crear(p, con);
        }
    }

    public void crear(Pedido p, Connection con) throws SQLException {
        String sql = "INSERT INTO pedidos (fecha, total) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, Date.valueOf(p.getFecha()));
            ps.setDouble(2, p.getTotal());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Pedido leer(int id) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            return leer(id, con);
        }
    }

    public Pedido leer(int id, Connection con) throws SQLException {
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        Pedido pedido = null;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pedido = new Pedido();
                    pedido.setId(rs.getInt("id"));
                    pedido.setFecha(rs.getDate("fecha").toLocalDate());
                    pedido.setTotal(rs.getDouble("total"));
                }
            }
        }
        return pedido;
    }

    @Override
    public void actualizar(Pedido p) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            actualizar(p, con);
        }
    }

    public void actualizar(Pedido p, Connection con) throws SQLException {
        String sql = "UPDATE pedidos SET fecha = ?, total = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(p.getFecha()));
            ps.setDouble(2, p.getTotal());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try (Connection con = ConexionBD.conectar()) {
            String sql = "DELETE FROM pedidos WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        }
    }

    @Override
    public List<Pedido> listar() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setFecha(rs.getDate("fecha").toLocalDate());
                pedido.setTotal(rs.getDouble("total"));
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
}
