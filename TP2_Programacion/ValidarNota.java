import java.util.Scanner;

public class ValidarNota {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nota;

        // Bucle para pedir una nota válida
        while (true) {
            System.out.print("Ingrese una nota (0-10): ");
            nota = scanner.nextInt();

            if (nota >= 0 && nota <= 10) {
                System.out.println("✅ Nota guardada correctamente.");
                break; // Sale del bucle si la nota es válida
            } else {
                System.out.println("⚠️ Error: Nota inválida. Ingrese una nota entre 0 y 10.");
            }
        }

        scanner.close();
    }
}
