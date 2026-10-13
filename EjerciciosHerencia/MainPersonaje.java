import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainPersonaje {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Personaje> personajes = new ArrayList<>();

    // Pide un texto y repite si está vacío
    static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("No puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    // Pide un entero y repite si no es número o está fuera de rango
    static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= min && n <= max) {
                    return n;
                }
                System.out.println("Escribe un número entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número válido.");
            }
        }
    }

    static Personaje elegir(String mensaje) {
        for (int i = 0; i < personajes.size(); i++) {
            System.out.print((i + 1) + ". ");
            personajes.get(i).mostrar();
        }
        return personajes.get(leerEntero(mensaje, 1, personajes.size()) - 1);
    }

    public static void main(String[] args) {
        try {
            int opcion;
            do {
                System.out.println("\n--- AVENTURA ---");
                System.out.println("1. Crear Aldeano  2. Crear Guerrero  3. Crear Mago");
                System.out.println("4. Ver personajes 5. Atacar          6. Curar  0. Salir");
                opcion = leerEntero("Opción: ", 0, 6);

                if (opcion == 1) {
                    Aldeano a = new Aldeano();
                    a.setNombre(leerTexto("Nombre: "));
                    personajes.add(a);
                } else if (opcion == 2) {
                    String nombre = leerTexto("Nombre: ");
                    int fuerza = leerEntero("Fuerza (1-50): ", 1, 50);
                    personajes.add(new Guerrero(nombre, 100, fuerza));
                } else if (opcion == 3) {
                    String nombre = leerTexto("Nombre: ");
                    int mana = leerEntero("Maná (1-100): ", 1, 100);
                    personajes.add(new Mago(nombre, 80, mana));
                } else if (opcion >= 4 && opcion <= 6) {
                    if (personajes.isEmpty()) {
                        System.out.println("Primero crea un personaje.");
                    } else if (opcion == 4) {
                        for (Personaje p : personajes) {
                            p.mostrar();   // cada clase usa su propio mostrar()
                        }
                    } else if (opcion == 5) {
                        Personaje atacante = elegir("¿Quién ataca?: ");
                        Personaje victima = elegir("¿A quién?: ");
                        if (atacante == victima) {
                            System.out.println("Un personaje no puede atacarse a sí mismo.");
                        } else {
                            int danio = atacante.atacar();
                            victima.recibirDanio(danio);
                            System.out.println(atacante.getNombre() + " hace " + danio + " de daño a " + victima.getNombre());
                        }
                    } else {
                        Personaje p = elegir("¿A quién curar?: ");
                        int tipo = leerEntero("1=curación básica, 2=cantidad, 3=poción: ", 1, 3);
                        if (tipo == 1) {
                            p.curar();
                        } else if (tipo == 2) {
                            p.curar(leerEntero("Cantidad (1-100): ", 1, 100));
                        } else {
                            p.curar(leerEntero("Cantidad (1-100): ", 1, 100), leerTexto("Poción: "));
                        }
                        System.out.println("Vida actual: " + p.getVida());
                    }
                }
            } while (opcion != 0);
        } catch (NoSuchElementException e) {
            System.out.println("\nEntrada cerrada.");
        }
        System.out.println("¡Hasta luego!");
    }
}