package ejerciciosGuiados.actividad1;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Programa para generar números aleatorios en una lista enlazada
 * y eliminar aquellos mayores a un límite especificado.
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasgalindo@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Actividad1 {
    
    /**
     * Método principal que ejecuta el programa.
     * 
     * Flujo:
     * 1. Solicita cantidad de números a generar
     * 2. Genera y muestra la lista con números aleatorios
     * 3. Solicita un valor límite
     * 4. Elimina números mayores al límite y muestra resultado
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Inicialización de recursos
        Scanner teclado = new Scanner(System.in, StandardCharsets.UTF_8);
        ListaSimple lista = new ListaSimple();
        
        // Solicita cantidad de números a generar
        System.out.print("¿Cuántos números aleatorios deseas generar?: ");
        int n = teclado.nextInt();
        
        // Genera números aleatorios y muestra la lista original
        lista.generarNumeros(n);
        lista.mostrar();
        
        // Solicita el valor límite para eliminar números mayores
        System.out.print("\nIngresa un valor límite: ");
        int limite = teclado.nextInt();
        
        // Elimina números mayores al límite y muestra lista resultante
        lista.eliminarMayoresQue(limite);
        System.out.println("\nLista después de eliminar mayores que " + limite + ":");
        lista.mostrar();
        
        // Libera recursos
        teclado.close();
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * - Complejidad temporal: O(n) donde n es la cantidad de números generados
 * - Complejidad espacial: O(n) para almacenar la lista
 * 
 * MEJORAS SUGERIDAS:
 * - Validar que n > 0
 * - Manejar excepciones de entrada (InputMismatchException)
 * - Usar try-with-resources para el Scanner
 */
