package Excepciones;

import java.io.*;
import java.util.Scanner;

public class LectorArchivo {
    public static void main(String[] args) {
        String ruta = "archivo.txt";

        //File not found exception
        try {
            LectorArchivo.leerArchivo(ruta);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo en sistema: " + e.getMessage());
        } finally {
            System.out.println("Fin del programa");
        }

        //IO Exception
        try {
            LectorArchivo.leerArchivoBuffer(ruta);
        } catch (IOException e) {
            System.out.println("Se produjo un error en la E/S");
        }
    }

    public static void leerArchivoBuffer(String rutaArchivo) throws IOException {
        System.out.println("Abriendo archivo con buffer...");
        File archivo = new File(rutaArchivo);
        try (BufferedReader br = new BufferedReader(new FileReader((archivo)))) {
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
            }
        }
    }

    public static void leerArchivo(String rutaArchivo) throws FileNotFoundException {
        System.out.println("Abriendo archivo...");
        File archivo = new File(rutaArchivo);
        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println(linea);
            }
        }
    }
}
