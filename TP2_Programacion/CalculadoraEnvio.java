import java.util.Scanner;

public class CalculadoraEnvio {

    // Método para calcular el costo de envío según zona y peso
    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5; // $5 por kg para envíos nacionales
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return peso * 10; // $10 por kg para envíos internacionales
        } else {
            System.out.println("⚠️ Error: Zona de envío no válida.");
            return -1; // Código de error
        }
    }

    // Método para calcular el total de la compra sumando el costo del producto y el envío
    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = scanner.nextDouble();

        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = scanner.nextDouble();

        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = scanner.nextLine();

        // Calcular costo de envío
        double costoEnvio = calcularCostoEnvio(peso, zona);

        if (costoEnvio == -1) {
            System.out.println("No se pudo calcular el costo de envío. Intente nuevamente.");
        } else {
            System.out.println("El costo de envío es: " + costoEnvio);
            // Calcular el total a pagar
            double total = calcularTotalCompra(precioProducto, costoEnvio);
            System.out.println("El total a pagar es: " + total);
        }

        scanner.close();
    }
}
