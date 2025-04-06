import java.time.Year;

public class Libro {
    // Atributos privados
    private String titulo;
    private String autor;
    private int añoPublicacion;

    // Constructor
    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.setAñoPublicacion(añoPublicacion); // Usamos el setter para aplicar validación
    }

    // Métodos getters públicos
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    // Método setter con validación
    public void setAñoPublicacion(int nuevoAño) {
        int añoActual = Year.now().getValue();
        if (nuevoAño >= 1900 && nuevoAño <= añoActual) {
            this.añoPublicacion = nuevoAño;
        } else {
            System.out.println("Año no válido: " + nuevoAño + ". Debe estar entre 1900 y " + añoActual + ".");
        }
    }

    // Método para mostrar la información del libro
    public void mostrarInfo() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año de publicación: " + getAñoPublicacion());
    }

    // Método principal para probar la clase Libro
    public static void main(String[] args) {
        // 1. Crear un libro
        Libro libro = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967);

        // 2. Intentar cambiar el año de publicación a uno inválido
        libro.setAñoPublicacion(1800); // Año inválido

        // 3. Intentar con un año válido
        libro.setAñoPublicacion(1985); // Año válido

        // 4. Mostrar la información del libro
        System.out.println("\nInformación del libro:");
        libro.mostrarInfo();
    }
}
