import DAO.GenericDAO;
import DAO.GestorCategorias;
import DAO.PedidoDAOImpl;
import modelo.Categoria;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import modelo.ItemPedido;
import modelo.Pedido;
import modelo.Producto;
import service.CategoriaServiceImpl;
import service.ProductoServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {

        // MAIN PARA EL KATA_1
       /* GestorCategorias gestor = new GestorCategorias();

        try {
            gestor.agregarCategoria("Bebidas", "Líquidos y refrescos");
            gestor.agregarCategoria("Snacks", "Comidas rápidas");
            gestor.mostrarCategoria(1);
            gestor.actualizarCategoria(2, "Snacks", "Comidas listas para picar");
            gestor.eliminarCategoria(3);

            System.out.println("\n Lista de categorías:");
            gestor.listarCategorias().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(" Error general: " + e.getMessage());
        } */

        //MAIN PARA EL KATA_2
         /* CategoriaServiceImpl service = new CategoriaServiceImpl();

        try {
            // Crear categorías
            service.crear(new Categoria(0, "Bebidas", "Líquidos y refrescos"));
            service.crear(new Categoria(0, "Snacks", "Comidas listas para picar"));

            // Leer categoría
            Categoria c = service.leer(1);
            System.out.println(c);

            // Actualizar categoría
            c.setDescripcion("Bebidas frías y calientes");
            service.actualizar(c);

            // Listar categorías
            List<Categoria> lista = service.listar();
            System.out.println("Lista de categorías:");
            for (Categoria categoria : lista) {
                System.out.println(categoria);
            }

            // Eliminar categoría
            service.eliminar(2);

        } catch (SQLException e) { //Maneja errores de base de datos.
            System.out.println("Error SQL: " + e.getMessage());
        } catch (Exception e) { //Maneja cualquier tipo de error.
            System.out.println("Error general: " + e.getMessage());
        } */

        //MAIN PARA EL KATA 3
        /*ProductoServiceImpl service = new ProductoServiceImpl();

          try {
            Categoria bebidas = new Categoria(1, "Bebidas", null); // ya debería existir

            Producto p1 = new Producto(0, "Coca-Cola", "Gaseosa 1.5L", 1200.0, 10, bebidas);
            Producto p2 = new Producto(0, "Pepsi", "Gaseosa 2L", 1000.0, 8, bebidas);

            service.crear(p1);
            service.crear(p2);

            List<Producto> lista = service.listar();
            lista.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        } */


        //KATA4
        try {
            // Crear DAO para Pedido
            GenericDAO<Pedido> pedidoDAO = new PedidoDAOImpl();

            // Crear productos de ejemplo
            Producto p1 = new Producto();
            p1.setId(1);
            p1.setNombre("Producto A");
            p1.setPrecio(100.0);

            Producto p2 = new Producto();
            p2.setId(2);
            p2.setNombre("Producto B");
            p2.setPrecio(50.0);

            // Crear un pedido nuevo
            Pedido pedido = new Pedido();
            pedido.setFecha(LocalDate.now());

            // Crear items sin usar constructor con parámetros (para evitar error)
            ItemPedido item1 = new ItemPedido();
            item1.setId(0);
            item1.setProducto(p1);
            item1.setCantidad(2);
            item1.setSubtotal(p1.getPrecio() * 2);

            ItemPedido item2 = new ItemPedido();
            item2.setId(0);
            item2.setProducto(p2);
            item2.setCantidad(3);
            item2.setSubtotal(p2.getPrecio() * 3);

            // Agregar items al pedido
            pedido.agregarItem(item1);
            pedido.agregarItem(item2);

            // Calcular total del pedido
            pedido.calcularTotal();

            // Guardar pedido en la base de datos
            pedidoDAO.crear(pedido);

            System.out.println("Pedido creado con ID: " + pedido.getId());

            // Listar todos los pedidos
            List<Pedido> pedidos = pedidoDAO.listar();
            System.out.println("Listado de pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("ID: " + p.getId() + ", Fecha: " + p.getFecha() + ", Total: " + p.getTotal());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
