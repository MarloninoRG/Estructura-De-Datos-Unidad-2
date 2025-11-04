package ejerciciosGuiados.actividad3;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Clase principal para la gestión y evaluación de polinomios
 * mediante listas enlazadas simples.
 * 
 * Funcionalidades:
 * - Ingresar términos de un polinomio
 * - Mostrar el polinomio en notación matemática
 * - Evaluar el polinomio en diferentes puntos
 * - Generar tablas de evaluación
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasgalindo@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Actividad3 {
    public static void main(String[] args) {
        // ========================================
        // 1. INICIALIZACIÓN
        // ========================================
        
        // Scanner con codificación UTF-8 para lectura de entrada
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
      
        // Objeto para almacenar los términos del polinomio
        Polinomio polinomio = new Polinomio();
        
        // ========================================
        // 2. PRESENTACIÓN
        // ========================================
        
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  REPRESENTACIÓN Y EVALUACIÓN DE POLINOMIOS     ║");
        System.out.println("║         CON LISTAS ENLAZADAS                   ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        // ========================================
        // 3. INSTRUCCIONES
        // ========================================
        
        System.out.println("Ingrese los términos del polinomio:");
        System.out.println("Formato: coeficiente exponente");
        System.out.println("Ejemplo: 3 4 (representa 3x^4)");
        System.out.println("         -4 2 (representa -4x^2)");
        System.out.println("         11 0 (representa 11)");
        System.out.println("\nIngrese 'fin' para terminar.\n");
        
        // ========================================
        // 4. LECTURA DE TÉRMINOS
        // ========================================
        
        int numeroTermino = 1;
        
        while (true) {
            System.out.print("Término " + numeroTermino + " (coeficiente exponente): ");
            String entrada = scanner.nextLine().trim();
            
            // Condición de salida
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            
            // Procesamiento y validación
            try {
                // Divide la entrada por espacios (\\s+ = uno o más espacios)
                String[] partes = entrada.split("\\s+");
                
                if (partes.length != 2) {
                    System.out.println("⚠ Error: Debe ingresar exactamente dos valores (coeficiente y exponente).");
                    continue;
                }
                
                // Convierte los valores a numéricos
                double coeficiente = Double.parseDouble(partes[0]);
                int exponente = Integer.parseInt(partes[1]);
                
                if (exponente < 0) {
                    System.out.println("⚠ Error: El exponente debe ser mayor o igual a 0.");
                    continue;
                }
                
                // Agrega el término al polinomio
                polinomio.agregarTermino(coeficiente, exponente);
                System.out.println("✓ Término agregado correctamente.");
                numeroTermino++;
                
            } catch (NumberFormatException e) {
                System.out.println("⚠ Error: Ingrese valores numéricos válidos.");
            }
        }
        
        // ========================================
        // 5. VERIFICACIÓN DE POLINOMIO VACÍO
        // ========================================
        
        if (polinomio.getGrado() == 0 && numeroTermino == 1) {
            System.out.println("\n⚠ No se ingresaron términos. Saliendo del programa.");
            scanner.close();
            return;
        }
        
        // ========================================
        // 6. VISUALIZACIÓN DEL POLINOMIO
        // ========================================
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("POLINOMIO INGRESADO:");
        System.out.println("=".repeat(50));
        
        polinomio.mostrarPolinomio();
        System.out.println("Grado del polinomio: " + polinomio.getGrado());
        
        // ========================================
        // 7. EVALUACIÓN EN RANGO PREDEFINIDO
        // ========================================
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("EVALUACIÓN DEL POLINOMIO");
        System.out.println("=".repeat(50));
        
        // Evalúa de 0.0 a 5.0 con incrementos de 0.5
        polinomio.mostrarTablaEvaluacion(0.0, 5.0, 0.5);
        
        // ========================================
        // 8. EVALUACIONES PERSONALIZADAS
        // ========================================
        
        System.out.println("\n¿Desea evaluar el polinomio en otros puntos? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        
        while (respuesta.equals("s")) {
            System.out.print("Ingrese el valor de x: ");
            
            try {
                double x = Double.parseDouble(scanner.nextLine().trim());
                double resultado = polinomio.evaluar(x);
                
                // Muestra el resultado con formato: P(x) = resultado
                System.out.printf("P(%.2f) = %.4f%n", x, resultado);
                
            } catch (NumberFormatException e) {
                System.out.println("⚠ Error: Ingrese un valor numérico válido.");
            }
            
            System.out.print("\n¿Evaluar otro punto? (s/n): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
        }
        
        // ========================================
        // 9. FINALIZACIÓN
        // ========================================
        
        System.out.println("\n¡Gracias por usar el programa!");
        scanner.close(); // Libera recursos del sistema
    }
}

