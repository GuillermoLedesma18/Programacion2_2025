public class GestionPrecios {
    public static void main(String[] args) {
        // 1. Declarar e inicializar un array con los precios de algunos productos
        double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};

        // 2. Mostrar los valores originales de los precios
        System.out.println("Precios originales:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }

        // 3. Modificar el precio de un producto específico (por ejemplo, el tercer producto)
        precios[2] = 129.99;

        // 4. Mostrar los valores modificados
        System.out.println("\nPrecios modificados:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }
    }
}
