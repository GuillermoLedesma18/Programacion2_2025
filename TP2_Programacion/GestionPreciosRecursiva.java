public class GestionPreciosRecursiva {

    // Función recursiva para mostrar los precios originales
    public static void mostrarPreciosOriginales(double[] precios, int index) {
        if (index < precios.length) {
            System.out.println("Precio: $" + precios[index]);
            mostrarPreciosOriginales(precios, index + 1);
        }
    }

    // Función recursiva para mostrar los precios modificados
    public static void mostrarPreciosModificados(double[] precios, int index) {
        if (index < precios.length) {
            System.out.println("Precio: $" + precios[index]);
            mostrarPreciosModificados(precios, index + 1);
        }
    }

    public static void main(String[] args) {
        // 1. Declarar e inicializar un array con los precios de algunos productos
        double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};

        // 2. Mostrar los valores originales de los precios utilizando la función recursiva
        System.out.println("Precios originales:");
        mostrarPreciosOriginales(precios, 0);

        // 3. Modificar el precio de un producto específico (por ejemplo, el tercer producto)
        precios[2] = 129.99;

        // 4. Mostrar los valores modificados utilizando la función recursiva
        System.out.println("\nPrecios modificados:");
        mostrarPreciosModificados(precios, 0);
    }
}
