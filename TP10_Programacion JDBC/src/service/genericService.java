package service;

import java.sql.SQLException;
import java.util.List;

public interface genericService<T> {
    void crear(T t) throws SQLException;
    T leer(int id) throws SQLException;
    void actualizar(T t) throws SQLException;
    void eliminar(int id) throws SQLException;
    List<T> listar() throws SQLException;
}