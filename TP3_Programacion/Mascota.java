public class Mascota {
    // Atributos
    private String nombre;
    private String especie;
    private int edad;

    // Constructor
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    // Método para mostrar información de la mascota
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }

    // Método para cumplir años (aumentar edad en 1)
    public void cumplirAnios() {
        edad++;
        System.out.println(nombre + " ha cumplido años. Ahora tiene " + edad + " años.");
    }

    // Método principal para probar la clase Mascota
    public static void main(String[] args) {
        // Crear una instancia de Mascota
        Mascota mascota = new Mascota("Luna", "Perro", 3);

        // Mostrar información inicial
        System.out.println("Información inicial:");
        mascota.mostrarInfo();

        // Aumentar la edad
        mascota.cumplirAnios();

        // Mostrar información actualizada
        System.out.println("\nInformación actualizada:");
        mascota.mostrarInfo();
    }
}
