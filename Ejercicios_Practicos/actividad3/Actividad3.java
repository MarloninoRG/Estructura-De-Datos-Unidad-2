package ejerciciosGuiados.actividad3;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Clase principal para la gestión y evaluación de polinomios
 * mediante listas enlazadas simples.
 * 
 * Este programa permite:
 * - Ingresar términos de un polinomio
 * - Mostrar el polinomio en notación matemática
 * - Evaluar el polinomio en diferentes puntos
 * - Generar tablas de evaluación
 * 
 * Clase para ejecutar el programa
 * @author Marlon Rojas Galindo
 * @contact marlonrojasgalindo@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Actividad3 {
    public static void main(String[] args) {
        /**
         * Scanner para lectura de entrada desde consola.
         * Se utiliza System.in como fuente de entrada estándar.
         * Configurar entrada UTF-8 con Scanner.
         */
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
      
        /**
         * Objeto Polinomio que almacenará los términos ingresados
         * mediante una estructura de lista enlazada simple.
         */
        Polinomio polinomio = new Polinomio();
        
        /**
         * Banner decorativo que indica el propósito del programa.
         * Utiliza caracteres de caja Unicode para mejor presentación visual.
         */
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  REPRESENTACIÓN Y EVALUACIÓN DE POLINOMIOS     ║");
        System.out.println("║         CON LISTAS ENLAZADAS                   ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        /**
         * Muestra las instrucciones de formato para ingresar términos.
         * 
         * Formato esperado: "coeficiente exponente"
         * Ejemplo: "3 4" representa el término 3x^4
         * 
         * El usuario debe escribir "fin" para terminar la entrada.
         */
        System.out.println("Ingrese los términos del polinomio:");
        System.out.println("Formato: coeficiente exponente");
        System.out.println("Ejemplo: 3 4 (representa 3x^4)");
        System.out.println("         -4 2 (representa -4x^2)");
        System.out.println("         11 0 (representa 11)");
        System.out.println("\nIngrese 'fin' para terminar.\n");
        
        /**
         * Contador para identificar el número de término actual.
         * Se incrementa con cada término válido agregado.
         */
        int numeroTermino = 1;
        
        /**
         * Bucle infinito para lectura continua de términos.
         * Se detiene cuando el usuario ingresa "fin".
         * 
         * Validaciones implementadas:
         * - Formato correcto (dos valores separados por espacio)
         * - Coeficiente numérico válido (double)
         * - Exponente numérico válido (integer)
         * - Exponente no negativo
         */
        while (true) {
            // Mostrar prompt con número de término actual
            System.out.print("Término " + numeroTermino + " (coeficiente exponente): ");
            
            /**
             * Lee la línea completa y elimina espacios al inicio/final.
             * trim() asegura que espacios extras no afecten el procesamiento.
             */
            String entrada = scanner.nextLine().trim();
            
            /**
             * Verifica si el usuario desea finalizar la entrada.
             * equalsIgnoreCase permite "fin", "FIN", "Fin", etc.
             */
            if (entrada.equalsIgnoreCase("fin")) {
                break; // Sale del bucle while
            }
            
            /**
             * Bloque try-catch para capturar errores de formato numérico.
             * Permite que el programa continúe aunque haya entradas inválidas.
             */
            try {
                /**
                 * Divide la entrada usando uno o más espacios como separador.
                 * \\s+ es una expresión regular que representa uno o más espacios.
                 * 
                 * Ejemplo: "3  4" (con espacios dobles) -> ["3", "4"]
                 */
                String[] partes = entrada.split("\\s+");
                
                // Validación: debe haber exactamente dos valores
                if (partes.length != 2) {
                    System.out.println("⚠ Error: Debe ingresar exactamente dos valores (coeficiente y exponente).");
                    continue; // Salta a la siguiente iteración
                }
                
                /**
                 * Conversión de cadenas a valores numéricos.
                 * 
                 * parseDouble: Convierte String a double (permite decimales)
                 * parseInt: Convierte String a int (solo enteros)
                 * 
                 * Si la conversión falla, lanza NumberFormatException
                 */
                double coeficiente = Double.parseDouble(partes[0]);
                int exponente = Integer.parseInt(partes[1]);
                
                // Validación: exponente debe ser no negativo
                if (exponente < 0) {
                    System.out.println("⚠ Error: El exponente debe ser mayor o igual a 0.");
                    continue; // Salta a la siguiente iteración
                }
                
                /**
                 * Si todas las validaciones pasan, agrega el término al polinomio.
                 * Este método debe implementar la lógica de lista enlazada.
                 */
                polinomio.agregarTermino(coeficiente, exponente);
                
                // Confirmación visual para el usuario
                System.out.println("✓ Término agregado correctamente.");
                
                /**
                 * Incrementa el contador solo cuando el término es válido.
                 * Esto mantiene la numeración consecutiva.
                 */
                numeroTermino++;
                
            } catch (NumberFormatException e) {
                /**
                 * Captura errores cuando la entrada no es numérica.
                 * Ejemplo: "abc 2" o "3 xyz"
                 * 
                 * El programa no se detiene, permite reintentar.
                 */
                System.out.println("⚠ Error: Ingrese valores numéricos válidos.");
            }
        }
        
        /**
         * Verifica si se ingresaron términos antes de continuar.
         * 
         * Condiciones para polinomio vacío:
         * - getGrado() retorna 0 (no hay términos con exponente > 0)
         * - numeroTermino sigue siendo 1 (no se agregó ningún término)
         * 
         * Si está vacío, termina el programa gracefully.
         */
        if (polinomio.getGrado() == 0 && numeroTermino == 1) {
            System.out.println("\n⚠ No se ingresaron términos. Saliendo del programa.");
            scanner.close(); // Importante: liberar recursos
            return; // Finaliza la ejecución del método main
        }
        
        /**
         * Crea un separador visual usando el método repeat().
         * repeat(50) genera una cadena de 50 signos "=".
         * 
         * Esto mejora la legibilidad de la salida en consola.
         */
        System.out.println("\n" + "=".repeat(50));
        System.out.println("POLINOMIO INGRESADO:");
        System.out.println("=".repeat(50));
        
        /**
         * Muestra el polinomio en notación matemática estándar.
         * Ejemplo: 3x^4 - 4x^2 + 11
         * 
         * Este método debe recorrer la lista enlazada y formatear la salida.
         */
        polinomio.mostrarPolinomio();
        
        /**
         * Muestra el grado del polinomio.
         * El grado es el exponente más alto presente en el polinomio.
         * 
         * Ejemplo: En 3x^4 - 4x^2 + 11, el grado es 4
         */
        System.out.println("Grado del polinomio: " + polinomio.getGrado());
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("EVALUACIÓN DEL POLINOMIO");
        System.out.println("=".repeat(50));
        
        /**
         * Evalúa el polinomio en un rango de valores y muestra una tabla.
         * 
         * Parámetros:
         * @param 0.0  - Valor inicial de x (desde)
         * @param 5.0  - Valor final de x (hasta)
         * @param 0.5  - Incremento entre evaluaciones (paso)
         * 
         * Esto evaluará el polinomio en: 0.0, 0.5, 1.0, 1.5, ..., 5.0
         * 
         * Ejemplo de salida:
         * x = 0.0 | P(x) = 11.0000
         * x = 0.5 | P(x) = 9.9375
         * x = 1.0 | P(x) = 10.0000
         * ...
         */
        polinomio.mostrarTablaEvaluacion(0.0, 5.0, 0.5);
        
        /**
         * Pregunta al usuario si desea evaluar el polinomio en puntos específicos.
         * Permite evaluaciones adicionales fuera del rango predefinido.
         */
        System.out.println("\n¿Desea evaluar el polinomio en otros puntos? (s/n): ");
        
        /**
         * Lee la respuesta y la normaliza:
         * - trim(): elimina espacios
         * - toLowerCase(): convierte a minúsculas ("S" -> "s")
         */
        String respuesta = scanner.nextLine().trim().toLowerCase();
        
        /**
         * Bucle que continúa mientras el usuario responda "s".
         * Permite múltiples evaluaciones consecutivas.
         */
        while (respuesta.equals("s")) {
            System.out.print("Ingrese el valor de x: ");
            
            /**
             * Bloque try-catch para manejar entradas no numéricas.
             * Si el usuario ingresa "abc", captura el error y solicita nuevo valor.
             */
            try {
                /**
                 * Lee el valor de x, elimina espacios y convierte a double.
                 * Permite valores decimales: 2.5, -3.7, 0.333, etc.
                 */
                double x = Double.parseDouble(scanner.nextLine().trim());
                
                /**
                 * Evalúa el polinomio en el punto x especificado.
                 * Este método debe implementar la regla de Horner o
                 * evaluación directa recorriendo la lista enlazada.
                 */
                double resultado = polinomio.evaluar(x);
                
                /**
                 * Formato de salida con precisión controlada:
                 * %.2f - muestra x con 2 decimales
                 * %.4f - muestra resultado con 4 decimales
                 * %n   - salto de línea multiplataforma
                 * 
                 * Ejemplo: P(2.50) = 42.1250
                 */
                System.out.printf("P(%.2f) = %.4f%n", x, resultado);
                
            } catch (NumberFormatException e) {
                /**
                 * Maneja el caso cuando la entrada no es un número válido.
                 * El bucle continúa, permitiendo al usuario reintentar.
                 */
                System.out.println("⚠ Error: Ingrese un valor numérico válido.");
            }
            
            /**
             * Pregunta si desea evaluar otro punto.
             * Si responde "n" o cualquier cosa diferente de "s", sale del bucle.
             */
            System.out.print("\n¿Evaluar otro punto? (s/n): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
        }
        
        /**
         * Mensaje de despedida para mejorar la experiencia del usuario.
         */
        System.out.println("\n¡Gracias por usar el programa!");
        
        /**
         * CRÍTICO: Cierra el Scanner para liberar recursos del sistema.
         * 
         * Importancia:
         * - Libera memoria
         * - Cierra el flujo de entrada
         * - Previene fugas de recursos (resource leaks)
         * - Buena práctica de programación
         * 
         * Nota: Al cerrar scanner, también se cierra System.in
         */
        scanner.close();
    }
}

/**
 * NOTAS ADICIONALES SOBRE LA IMPLEMENTACIÓN:
 * 
 * 1. MANEJO DE ERRORES:
 *    - Try-catch para NumberFormatException en conversiones numéricas
 *    - Validaciones de formato y rango
 *    - Mensajes de error descriptivos con símbolos visuales (⚠, ✓)
 * 
 * 2. EXPERIENCIA DE USUARIO:
 *    - Interfaz clara con banners y separadores
 *    - Instrucciones detalladas con ejemplos
 *    - Confirmaciones visuales de acciones exitosas
 *    - Opción de evaluaciones personalizadas
 * 
 * 3. ROBUSTEZ:
 *    - No se detiene ante entradas inválidas
 *    - Permite reintentar sin reiniciar el programa
 *    - Maneja casos especiales (polinomio vacío)
 *    - Libera recursos apropiadamente
 * 
 * 4. ESTRUCTURA DEL CÓDIGO:
 *    - Separación clara de responsabilidades
 *    - Comentarios descriptivos en cada sección
 *    - Nombres de variables autodescriptivos
 *    - Flujo lógico fácil de seguir
 * 
 * 5. MEJORAS POTENCIALES:
 *    - Implementar ordenamiento de términos por exponente
 *    - Agregar funcionalidad de simplificación (combinar términos semejantes)
 *    - Incluir operaciones entre polinomios (suma, resta, multiplicación)
 *    - Permitir guardar/cargar polinomios desde archivo
 *    - Agregar visualización gráfica del polinomio
 */

