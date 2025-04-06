public class NaveEspacial {
    // Atributos
    private String nombre;
    private int combustible;
    private final int LIMITE_COMBUSTIBLE = 100;

    // Constructor
    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = Math.min(combustible, LIMITE_COMBUSTIBLE);
    }

    // Método despegar
    public void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado.");
        } else {
            System.out.println(nombre + " no puede despegar: combustible insuficiente.");
        }
    }

    // Método avanzar
    public void avanzar(int distancia) {
        if (combustible >= distancia) {
            combustible -= distancia;
            System.out.println(nombre + " ha avanzado " + distancia + " unidades.");
        } else {
            System.out.println(nombre + " no puede avanzar: combustible insuficiente para esa distancia.");
        }
    }

    // Método recargar combustible
    public void recargarCombustible(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad inválida para recargar.");
            return;
        }
        int nuevoNivel = combustible + cantidad;
        if (nuevoNivel > LIMITE_COMBUSTIBLE) {
            combustible = LIMITE_COMBUSTIBLE;
            System.out.println("Combustible recargado hasta el máximo (100 unidades).");
        } else {
            combustible = nuevoNivel;
            System.out.println("Combustible recargado en " + cantidad + " unidades.");
        }
    }

    // Mostrar estado de la nave
    public void mostrarEstado() {
        System.out.println("Nombre de la nave: " + nombre);
        System.out.println("Combustible actual: " + combustible + " unidades");
    }

    // Método main para probar todo el comportamiento
    public static void main(String[] args) {
        // Paso 2: Crear una nave con 50 unidades de combustible
        NaveEspacial nave = new NaveEspacial("Explorer-1", 50);

        // Paso 3: Intentar avanzar 60 unidades (debe fallar)
        nave.avanzar(60);

        // Paso 4: Recargar 40 unidades de combustible
        nave.recargarCombustible(40);

        // Paso 5: Intentar avanzar 60 unidades nuevamente (ahora debe funcionar)
        nave.avanzar(60);

        // Paso 6: Mostrar estado final de la nave
        System.out.println("\nEstado final de la nave:");
        nave.mostrarEstado();

        NaveEspacial nave2 = new NaveEspacial("Galaxia-X", 95);
        nave2.recargarCombustible(20); // prueba límite
        nave2.despegar();              // posible si combustible >= 10
        nave2.avanzar(50);             // válido si queda suficiente
        nave2.mostrarEstado();         // ver cómo quedó

    }
}
