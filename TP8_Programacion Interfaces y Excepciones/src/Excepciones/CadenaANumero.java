package Excepciones;

import java.util.Scanner;

public class CadenaANumero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un numero entero");
        String ingreso = input.nextLine();
        int numero;
        try {
            numero = convertirANumero(ingreso);
        } catch (NumberFormatException e) {
            System.out.println("No ingresaste un numero entero: " + e.getMessage());
        }

    }
    public static int convertirANumero(String ingreso) throws NumberFormatException{
        int i = Integer.parseInt(ingreso);
        return i;
    }
}
