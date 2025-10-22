package ejerciciosGuiados.actividad4;

/**
 * Clase principal para demostrar el funcionamiento de un polinomio implementado
 * con una lista circular genérica.
 * 
 * Esta clase proporciona una interfaz de consola interactiva para:
 * - Crear polinomios ingresando términos
 * - Visualizar la estructura circular
 * - Realizar operaciones sobre el polinomio
 * - Verificar propiedades de la lista circular
 * 
 * Características principales:
 * - Entrada/salida configurada para UTF-8
 * - Menú interactivo con múltiples opciones
 * - Validación de datos de entrada
 * - Visualización formateada de resultados
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Actividad4 {
    
    /**
     * Método principal que ejecuta la aplicación de demostración del polinomio circular.
     * 
     * Flujo del programa:
     * 1. Configuración de entrada/salida UTF-8
     * 2. Presentación inicial y entrada de datos
     * 3. Creación del polinomio con términos ingresados
     * 4. Visualización inicial de resultados
     * 5. Menú interactivo para operaciones adicionales
     * 
     * El menú ofrece las siguientes funcionalidades:
     * - Mostrar representación del polinomio
     * - Realizar recorrido circular completo
     * - Agregar nuevos términos
     * - Verificar integridad de la circularidad
     * - Mostrar información técnica de la estructura
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     * 
     * Ejemplo de uso:
     * Ingreso:
     *   Número de términos: 3
     *   Términos: 3 4, -4 2, 11 0
     *   
     * Resultado:
     *   Polinomio: 3.00x^4 -4.00x^2 + 11.00
     *   Estructura circular con 3 nodos
     * 
     * @see PolinomioCircular
     */
    public static void main(String[] args) {
        // Configurar salida UTF-8 para soportar caracteres especiales
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        // Configurar entrada UTF-8 con Scanner
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        PolinomioCircular<Double> polinomio = new PolinomioCircular<>();
        
        // Encabezado de la aplicación
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  POLINOMIO CON LISTA CIRCULAR GENÉRICA    ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Entrada del número de términos
        System.out.print("Ingrese el número de términos del polinomio: ");
        int numTerminos = scanner.nextInt();
        
        // Instrucciones para el formato de entrada
        System.out.println("\nIngrese los términos en formato: coeficiente exponente");
        System.out.println("Ejemplo para 3x^4 - 4x^2 + 11:");
        System.out.println("  3 4");
        System.out.println("  -4 2");
        System.out.println("  11 0\n");
        
        /**
         * Bucle para ingresar cada término del polinomio
         * Por cada término se solicita:
         * - Coeficiente: valor numérico (puede ser decimal o negativo)
         * - Exponente: potencia entera no negativa
         */
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
        
        // Información técnica de la estructura circular
        polinomio.mostrarInformacionCircular();
        
        // Demostración del recorrido circular
        polinomio.recorridoCircular();
        
        /**
         * Menú interactivo principal
         * Permite realizar diversas operaciones sobre el polinomio
         * sin necesidad de reiniciar el programa
         */
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
            
            /**
             * Switch para manejar las opciones del menú
             * Cada caso corresponde a una funcionalidad específica
             */
            switch (opcion) {
                case 1:
                    // Mostrar representación actual del polinomio
                    polinomio.mostrarPolinomio();
                    break;
                case 2:
                    // Demostrar el recorrido circular completo
                    polinomio.recorridoCircular();
                    break;
                case 3:
                    // Agregar un nuevo término al polinomio
                    System.out.print("Coeficiente: ");
                    double coef = scanner.nextDouble();
                    System.out.print("Exponente: ");
                    int exp = scanner.nextInt();
                    polinomio.agregarTermino(coef, exp);
                    System.out.println("✓ Término agregado exitosamente");
                    break;
                case 4:
                    // Verificar la correcta circularidad de la lista
                    System.out.println("La lista " + 
                        (polinomio.verificarCircularidad() ? "ES" : "NO ES") + 
                        " correctamente circular");
                    break;
                case 5:
                    // Mostrar información técnica de la estructura
                    polinomio.mostrarInformacionCircular();
                    break;
                case 0:
                    // Salir del programa
                    continuar = false;
                    System.out.println("\n¡Hasta pronto!");
                    break;
                default:
                    System.out.println("⚠ Opción inválida");
            }
        }
        
        // Cerrar scanner para liberar recursos
        scanner.close();
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * CARACTERÍSTICAS DE LA APLICACIÓN:
 * - Interfaz de usuario amigable con formato visual mejorado
 * - Validación básica de entrada de datos
 * - Manejo de caracteres UTF-8 para símbolos matemáticos
 * - Arquitectura modular que separa lógica de presentación
 * 
 * FLUJO DE EJECUCIÓN:
 * 1. Configuración inicial del entorno
 * 2. Entrada de parámetros del polinomio
 * 3. Construcción de la estructura de datos
 * 4. Presentación de resultados iniciales
 * 5. Bucle interactivo para operaciones adicionales
 * 6. Liberación de recursos y salida
 * 
 * MANEJO DE ENTRADA/SALIDA:
 * - Scanner configurado para UTF-8
 * - PrintStream para salida con soporte Unicode
 * - Formateo consistente de números decimales
 * - Mensajes de error descriptivos
 * 
 * INTERACCIÓN CON PolinomioCircular:
 * - Uso de genéricos para tipo Double
 * - Llamadas a métodos públicos de la clase
 * - Manejo de excepciones implícito
 * - Visualización de estado interno
 * 
 * MEJORAS POSIBLES:
 * - Validación más robusta de entrada de datos
 * - Manejo de excepciones personalizadas
 * - Persistencia de polinomios en archivos
 * - Operaciones algebraicas adicionales
 * - Interfaz gráfica de usuario
 * - Historial de operaciones realizadas
 * 
 * EJEMPLO DE EJECUCIÓN COMPLETA:
 * Entrada:
 *   Número de términos: 2
 *   Término 1: 5 3
 *   Término 2: -2 1
 *   
 * Salida:
 *   Polinomio: 5.00x^3 -2.00x
 *   Estructura circular con 2 nodos
 *   Recorrido: 5.00x^3 → -2.00x → (ciclo al inicio)
 */
