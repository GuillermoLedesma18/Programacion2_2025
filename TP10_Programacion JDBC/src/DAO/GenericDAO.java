package DAO;

import modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    void crear(T t) throws SQLException;
    T leer(int id) throws SQLException;
    void actualizar(T t) throws SQLException;
    void eliminar(int id) throws SQLException;
    List<T> listar() throws SQLException;
}
