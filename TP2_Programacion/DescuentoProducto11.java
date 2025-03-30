import java.util.Scanner;

public class DescuentoProducto11 {

    // Variable global
    public static final double DESCUENTO_ESPECIAL = 0.10;

    // Método para calcular el descuento especial
    public static void calcularDescuentoEspecial(double precio) {
        // Variable local que calcula el descuento
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;

        // Calcular el precio final con descuento
        double precioFinal = precio - descuentoAplicado;

        // Mostrar el descuento aplicado y el precio final
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el precio del producto
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        // Llamar al método para calcular el descuento
        calcularDescuentoEspecial(precio);

        scanner.close();
    }
}
