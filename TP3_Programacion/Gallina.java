public class Gallina {
    // Atributos
    private String idGallina;
    private int edad;
    private int huevosPuestos;

    // Constructor
    public Gallina(String idGallina) {
        this.idGallina = idGallina;
        this.edad = 0;
        this.huevosPuestos = 0;
    }

    // Método para poner un huevo
    public void ponerHuevo() {
        huevosPuestos++;
    }

    // Método para envejecer
    public void envejecer() {
        edad++;
    }

    // Método para mostrar el estado de la gallina
    public void mostrarEstado() {
        System.out.println("ID de la gallina: " + idGallina);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Huevos puestos: " + huevosPuestos);
        System.out.println("-----------------------------");
    }

    // Método principal para probar la clase Gallina
    public static void main(String[] args) {
        // 1. Crear dos gallinas con identificadores únicos
        Gallina gallina1 = new Gallina("G001");
        Gallina gallina2 = new Gallina("G002");

        // 2. Cada gallina pone al menos un huevo
        gallina1.ponerHuevo();
        gallina2.ponerHuevo();
        gallina2.ponerHuevo(); // gallina2 pone un segundo huevo

        // 3. Cada gallina envejece un año
        gallina1.envejecer();
        gallina2.envejecer();

        // 4. Mostrar el estado de cada gallina
        System.out.println("Estado de las gallinas:");
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();
    }
}
