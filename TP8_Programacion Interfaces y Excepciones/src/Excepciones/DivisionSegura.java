package Excepciones;

public class DivisionSegura {

    public static void main(String[] args) {
        double numerador = 10.0;
        double denominador = 5.0;

        try {
            System.out.println("Resultado de la operacion: " + dividir(numerador, denominador));
        } catch (ArithmeticException e) {
            System.out.println("No se pudo realizar la operacion: " + e.getMessage());
        }

    }
    public static double dividir(double numerador, double denominador) {
        double resultado;
        if (denominador == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        resultado = numerador / denominador;
        return resultado;
    }
}
