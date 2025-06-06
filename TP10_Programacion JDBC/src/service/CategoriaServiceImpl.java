package service;

import DAO.CategoriaDAOImpl;
import modelo.Categoria;
import util.ConexionBD;

import java.sql.SQLException;
import java.util.List;

public class CategoriaServiceImpl implements genericService<Categoria> {

    private CategoriaDAOImpl dao = new CategoriaDAOImpl();

    @Override
    public void crear(Categoria c) throws SQLException {
        if (c.getNombre() == null || c.getNombre().trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        // Verificar duplicado llamando a DAO
        if (dao.existeNombre(ConexionBD.conectar(), c.getNombre())) {
            System.out.println("Ya existe una categoría con ese nombre.");
            return;
        }
        dao.crear(c);
    }

    @Override
    public Categoria leer(int id) throws SQLException {
        return dao.leer(id);
    }

    @Override
    public void actualizar(Categoria c) throws SQLException {
        if (c.getNombre() == null || c.getNombre().trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        dao.actualizar(c);
    }

    @Override
    public void eliminar(int id) throws SQLException {
        dao.eliminar(id);
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        return dao.listar();
    }
}
