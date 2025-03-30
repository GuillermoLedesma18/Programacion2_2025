import java.util.Scanner;

public class CalculadoraPrecio {
    // Método para calcular el precio final
    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        double impuestoAplicado = precioBase * (impuesto / 100);
        double descuentoAplicado = precioBase * (descuento / 100);
        return precioBase + impuestoAplicado - descuentoAplicado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = scanner.nextDouble();

        System.out.print("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double impuesto = scanner.nextDouble();

        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double descuento = scanner.nextDouble();

        // Calcular el precio final
        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);

        // Mostrar el resultado
        System.out.println("El precio final del producto es: " + precioFinal);

        scanner.close();
    }
}

