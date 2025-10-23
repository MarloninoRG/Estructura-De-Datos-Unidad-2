package ejerciciosGuiados.actividad4;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Clase principal para demostrar el funcionamiento de un polinomio implementado
 * con una lista circular genérica.
 * 
 * Funcionalidades:
 * - Crear polinomios ingresando términos
 * - Visualizar la estructura circular
 * - Realizar operaciones sobre el polinomio
 * - Verificar propiedades de la lista circular
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Actividad4 {
    
    /**
     * Método principal que ejecuta la aplicación.
     * 
     * Flujo del programa:
     * 1. Configuración de entrada/salida UTF-8
     * 2. Entrada de datos y creación del polinomio
     * 3. Visualización inicial de resultados
     * 4. Menú interactivo para operaciones adicionales
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configurar salida UTF-8 para caracteres especiales
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        // Configurar entrada UTF-8
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        PolinomioCircular<Double> polinomio = new PolinomioCircular<>();
        
        // Encabezado
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  POLINOMIO CON LISTA CIRCULAR GENÉRICA    ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Entrada del número de términos
        System.out.print("Ingrese el número de términos del polinomio: ");
        int numTerminos = scanner.nextInt();
        
        // Instrucciones
        System.out.println("\nIngrese los términos en formato: coeficiente exponente");
        System.out.println("Ejemplo para 3x^4 - 4x^2 + 11:");
        System.out.println("  3 4");
        System.out.println("  -4 2");
        System.out.println("  11 0\n");
        
        // Ingresar términos
        for (int i = 0; i < numTerminos; i++) {
            System.out.print("Término " + (i + 1) + " -> Coeficiente: ");
            double coef = scanner.nextDouble();
            System.out.print("           -> Exponente: ");
            int exp = scanner.nextInt();
            polinomio.agregarTermino(coef, exp);
        }
        
        // Mostrar resultados iniciales
        System.out.println("\n" + "=".repeat(50));
        polinomio.mostrarPolinomio();
        System.out.println("=".repeat(50));
        
        polinomio.mostrarInformacionCircular();
        polinomio.recorridoCircular();
        
        // Menú interactivo
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║              MENÚ DE OPCIONES              ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║ 1. Mostrar polinomio                       ║");
            System.out.println("║ 2. Realizar recorrido circular             ║");
            System.out.println("║ 3. Agregar nuevo término                   ║");
            System.out.println("║ 4. Verificar circularidad                  ║");
            System.out.println("║ 5. Mostrar información de la estructura    ║");
            System.out.println("║ 0. Salir                                   ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    polinomio.mostrarPolinomio();
                    break;
                case 2:
                    polinomio.recorridoCircular();
                    break;
                case 3:
                    System.out.print("Coeficiente: ");
                    double coef = scanner.nextDouble();
                    System.out.print("Exponente: ");
                    int exp = scanner.nextInt();
                    polinomio.agregarTermino(coef, exp);
                    System.out.println("✓ Término agregado exitosamente");
                    break;
                case 4:
                    System.out.println("La lista " + 
                        (polinomio.verificarCircularidad() ? "ES" : "NO ES") + 
                        " correctamente circular");
                    break;
                case 5:
                    polinomio.mostrarInformacionCircular();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\n¡Hasta pronto!");
                    break;
                default:
                    System.out.println("⚠ Opción inválida");
            }
        }
        
        scanner.close();
    }
}