import java.util.Scanner;

public class DescuentoProducto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el precio del producto
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        // Solicitar la categoría del producto
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        char categoria = scanner.next().toUpperCase().charAt(0); // Convertir a mayúscula para evitar errores

        double descuento = 0;

        // Aplicar el descuento según la categoría
        if (categoria == 'A') {
            descuento = 0.10;
        } else if (categoria == 'B') {
            descuento = 0.15;
        } else if (categoria == 'C') {
            descuento = 0.20;
        } else {
            System.out.println("Categoría no válida.");
            scanner.close();
            return; // Termina el programa si la categoría no es válida
        }

        // Calcular el descuento y el precio final
        double montoDescuento = precio * descuento;
        double precioFinal = precio - montoDescuento;

        // Mostrar los resultados
        System.out.println("Descuento aplicado: " + (int) (descuento * 100) + "%");
        System.out.println("Precio final: " + precioFinal);

        scanner.close();
    }
}
