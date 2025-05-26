public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("P001", "Televisor", 2500.0, 20, CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(new Producto("P002", "Silla", 150.0, 50, CategoriaProducto.HOGAR));
        inventario.agregarProducto(new Producto("P003", "Queso", 5.5, 80, CategoriaProducto.ALIMENTOS));
        inventario.agregarProducto(new Producto("P004", "Laptop", 1800.0, 15, CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(new Producto("P005", "Jeans", 40.0, 60, CategoriaProducto.ROPA));

        System.out.println("📦 Total de stock disponible: " + inventario.obtenerTotalStock());

        System.out.println("\n📈 Producto con mayor stock:");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            mayorStock.mostrarInfo();
        }

        System.out.println("💰 Productos con precio entre $1000 y $3000:");
        for (Producto p : inventario.filtrarProductosPorPrecio(1000, 3000)) {
            p.mostrarInfo();
        }

        System.out.println("📚 Categorías del inventario:");
        inventario.mostrarCategoriasDisponibles();
    }
}
