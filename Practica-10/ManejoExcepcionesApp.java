/** Práctica 10: Manejo de excepciones
 * Código 1: Clase ManejoExcepcionesApp.java
 * Fecha: 15 de junio del 2024
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que engloba todas las demostraciones de excepciones. 
 */
import java.util.InputMismatchException;
import java.util.Scanner;/** libreria para mostrar las excepciones */

/** clase principal del programa */
public class ManejoExcepcionesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
/* Menú de opciones */
        do {
            System.out.println("\n    DEMOSTRACIÓN DINÁMICA DE EXCEPCIONES \n");
            System.out.println("1. ArithmeticException (División por cero)");
            System.out.println("2. InputMismatchException (Tipo de dato incorrecto)");
            System.out.println("3. NullPointerException (Objeto nulo)");
            System.out.println("4. NumberFormatException (Formato numérico inválido)");
            System.out.println("5. FileNotFoundException (Archivo no encontrado)");
            System.out.println("6. IOException (Error de entrada/salida)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción interactiva: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada

                switch (opcion) {
                    case 1:
                        ValidarExcepciones.probarArithmetic(scanner);
                        break;
                    case 2:
                        ValidarExcepciones.probarInputMismatch(scanner);
                        break;
                    case 3:
                        ValidarExcepciones.probarNullPointerException(scanner);
                        break;
                    case 4:
                        ValidarExcepciones.probarNumberFormatException(scanner);
                        break;
                    case 5:
                        ValidarExcepciones.probarFileNotFoundException(scanner);
                        break;
                    case 6:
                        ValidarExcepciones.probarIOException(scanner);
                        break;
                    case 0:
                        System.out.println("¡Saliendo del programa. Adiós!");
                        break;
                    default:
                        System.out.println(" Opción no válida. Inténtate de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Error en el menú: Debes ingresar un número entero.");
                scanner.next(); /*Limpiar el token inválido del scanner*/
                opcion = -1; /*  Mantener el ciclo activo*/
            }
            
        } while (opcion != 0);

        scanner.close();
    }

    /** Aquí iremos implementando cada método dinámico... */
}