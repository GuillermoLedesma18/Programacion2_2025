package DAO;

import modelo.Categoria;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GestorCategorias {

    public void agregarCategoria(String nombre, String descripcion) throws SQLException {
        try (Connection conn = ConexionBD.conectar()) {
            if (existeCategoria(conn, nombre)) {
                System.out.println(" La categoría ya existe.");
                return;
            }
            String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.executeUpdate();
            stmt.close();

            System.out.println(" Categoría agregada correctamente.");
        }
    }



    public void mostrarCategoria(int id) throws SQLException {
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Categoria c = new Categoria(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"));
                System.out.println(c);
            } else {
                System.out.println(" Categoría no encontrada.");
            }

            rs.close();
            stmt.close();
        }
    }

    public List<Categoria> listarCategorias() throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "SELECT * FROM categorias";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Categoria c = new Categoria(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"));
                lista.add(c);
            }

            rs.close();
            stmt.close();
        }
        return lista;
    }

    public void actualizarCategoria(int id, String nombre, String descripcion) throws SQLException {
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "UPDATE categorias SET nombre = ?, descripcion = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setInt(3, id);
            int filas = stmt.executeUpdate();
            stmt.close();

            if (filas > 0) {
                System.out.println(" Categoría actualizada.");
            } else {
                System.out.println("No se encontró la categoría.");
            }
        }
    }

    public void eliminarCategoria(int id) throws SQLException {
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "DELETE FROM categorias WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            stmt.close();

            if (filas > 0) {
                System.out.println(" Categoría eliminada.");
            } else {
                System.out.println(" No se encontró la categoría.");
            }
        }
    }

    private boolean existeCategoria(Connection conn, String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM categorias WHERE nombre = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        boolean existe = rs.getInt(1) > 0;
        rs.close();
        stmt.close();
        return existe;
    }
}








