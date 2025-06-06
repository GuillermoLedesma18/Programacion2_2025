package Excepciones;

import java.util.Scanner;

public class EdadValida {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese su edad");
        String ingreso = input.nextLine();
        int edad;
        try {
            edad = Integer.parseInt(ingreso);
            validarEdad(edad);
        } catch (NumberFormatException e) {
            System.out.println("No ingresaste un numero");
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void validarEdad(int edad) throws EdadInvalidaException{
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("Edad ingresada no válida");
        }
    }
}
