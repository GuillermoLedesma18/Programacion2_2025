public class Estudiante {
    // Atributos
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    // Constructor
    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    // Método para mostrar información del estudiante
    public void mostrarInfo() {
        System.out.println("Estudiante: " + apellido + ", " + nombre);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
    }

    // Método para subir la calificación
    public void subirCalificacion(double puntos) {
        if (puntos > 0 && puntos <= 10) {
            calificacion += puntos;
            if (calificacion > 10.0) {
                calificacion = 10.0;
            }
            System.out.println("Calificación actualizada: " + calificacion);
        } else {
            System.out.println("La cantidad de puntos debe estar entre 0 y 10.");
        }
    }

    // Método para bajar la calificación
    public void bajarCalificacion(double puntos) {
        if (puntos > 0 && puntos <= 10) {
            calificacion -= puntos;
            if (calificacion < 0.0) {
                calificacion = 0.0;
            }
            System.out.println("Calificación actualizada: " + calificacion);
        } else {
            System.out.println("La cantidad de puntos debe estar entre 0 y 10.");
        }
    }

    // Método principal para probar la clase Estudiante
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Juan", "Pérez", "Matemáticas", 8.5);
        estudiante.mostrarInfo();

        // Subir calificación en 2 puntos
        estudiante.subirCalificacion(2);

        // Bajar calificación en 1.5 puntos
        estudiante.bajarCalificacion(1.5);
    }
}
