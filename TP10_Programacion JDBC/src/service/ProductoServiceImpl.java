package service;

import DAO.ProductoDAOImpl;
import modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public class ProductoServiceImpl implements genericService<Producto> {

    private ProductoDAOImpl productoDAO;

    public ProductoServiceImpl() {
        this.productoDAO = new ProductoDAOImpl();
    }

    @Override
    public void crear(Producto producto) throws SQLException {
        validarProducto(producto);
        productoDAO.crear(producto);
    }

    @Override
    public Producto leer(int id) throws SQLException {
        return productoDAO.leer(id);
    }

    @Override
    public void actualizar(Producto producto) throws SQLException {
        validarProducto(producto);
        productoDAO.actualizar(producto);
    }

    @Override
    public void eliminar(int id) throws SQLException {
        productoDAO.eliminar(id);
    }

    @Override
    public List<Producto> listar() throws SQLException {
        return productoDAO.listar();
    }

    public List<Producto> listarPorCategoria(int idCategoria) throws SQLException {
        return productoDAO.listarPorCategoria(idCategoria);
    }

    // ✅ Método de validación de negocio
    private void validarProducto(Producto producto) throws SQLException {
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero.");
        }

        if (producto.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }

        // Verificar existencia de la categoría (integridad referencial)
        if (!productoDAO.existeCategoria(producto.getCategoria().getId())) {
            throw new IllegalArgumentException("La categoría asociada no existe.");
        }
    }
}
