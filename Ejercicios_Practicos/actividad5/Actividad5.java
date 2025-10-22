package ejerciciosGuiados.actividad5;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Clase principal que implementa un programa interactivo para manipular
 * listas doblemente enlazadas de caracteres con capacidades de ordenamiento.
 * 
 * El programa permite:
 * - Crear listas a partir de cadenas de texto
 * - Visualizar listas en ambas direcciones (adelante y atrás)
 * - Ordenar caracteres usando tres algoritmos diferentes
 * - Verificar la integridad estructural de la lista
 * - Realizar operaciones de diagnóstico y análisis
 * 
 * Características principales:
 * - Interfaz de usuario interactiva con menú navegable
 * - Soporte completo para caracteres UTF-8
 * - Manejo robusto de excepciones y entradas inválidas
 * - Comparación de diferentes algoritmos de ordenamiento
 * - Verificación de integridad de la estructura de datos
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Actividad5 {
    
    /**
     * Construye una lista doblemente enlazada a partir de una cadena de texto.
     * 
     * Cada carácter de la cadena se convierte en un nodo individual en la lista.
     * Los caracteres se agregan en el orden de aparición en la cadena.
     * 
     * @param cadena Cadena de texto de entrada (no nula, puede estar vacía)
     * @return Lista doblemente enlazada conteniendo todos los caracteres de la cadena
     * 
     * Complejidad: O(n) donde n es la longitud de la cadena
     * 
     * Ejemplo:
     * construirListaDesdeTexto("Hola") → Lista: ['H' ↔ 'o' ↔ 'l' ↔ 'a']
     * 
     * @throws NullPointerException si cadena es null
     */
    public static ListaDobleEnlazada<Character> construirListaDesdeTexto(String cadena) {
        ListaDobleEnlazada<Character> lista = new ListaDobleEnlazada<>();
        
        for (int i = 0; i < cadena.length(); i++) {
            lista.agregarAlFinal(cadena.charAt(i));
        }
        
        return lista;
    }
    
    /**
     * Muestra el menú principal de opciones disponibles en el programa.
     * 
     * El menú incluye operaciones para:
     * - Gestión de listas (crear, mostrar)
     * - Algoritmos de ordenamiento (burbuja, inserción, selección)
     * - Diagnóstico y verificación de integridad
     * - Control del programa (salir)
     * 
     * Formato de salida:
     * ========================================
     *             MENU DE OPCIONES            
     * ========================================
     * 1. Ingresar nueva cadena
     * 2. Mostrar lista (adelante)
     * 3. Mostrar lista (atras)
     * ...
     * ========================================
     * 
     * El menú se muestra centrado y con bordes para mejor legibilidad.
     */
    public static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("            MENU DE OPCIONES            ");
        System.out.println("========================================");
        System.out.println("1. Ingresar nueva cadena");
        System.out.println("2. Mostrar lista (adelante)");
        System.out.println("3. Mostrar lista (atras)");
        System.out.println("4. Ordenar con Burbuja");
        System.out.println("5. Ordenar con Insercion");
        System.out.println("6. Ordenar con Seleccion");
        System.out.println("7. Mostrar informacion de la lista");
        System.out.println("8. Verificar integridad");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }
    
    /**
     * Método principal que ejecuta el programa interactivo de listas doblemente enlazadas.
     * 
     * Flujo de ejecución:
     * 1. Configuración del entorno (UTF-8, Scanner)
     * 2. Presentación inicial del programa
     * 3. Bucle principal interactivo
     * 4. Gestión de menú y operaciones
     * 5. Liberación de recursos y salida
     * 
     * Características de la interfaz:
     * - Entrada inicial obligatoria de cadena
     * - Validación de entradas vacías
     * - Manejo de excepciones robusto
     * - Mensajes informativos y de error claros
     * - Formato visual consistente
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     * 
     * Ejemplo de sesión típica:
     * Ingrese una cadena de texto: programacion
     * Lista creada exitosamente!
     * Número de caracteres: 12
     * 
     * [Menú interactivo con opciones 1-8 y 0]
     * 
     * @see ListaDobleEnlazada
     */
    public static void main(String[] args) {
        // Configurar codificación UTF-8 para soportar caracteres internacionales
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.out.println("Advertencia: No se pudo configurar UTF-8");
        }
        
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        ListaDobleEnlazada<Character> lista = null;
        
        // Encabezado del programa
        System.out.println("========================================");
        System.out.println("  LISTA DOBLEMENTE ENLAZADA ORDENADA   ");
        System.out.println("========================================");
        System.out.println();
        
        boolean continuar = true;
        
        /**
         * Bucle principal del programa
         * Mantiene la ejecución hasta que el usuario selecciona salir
         */
        while (continuar) {
            // Si no hay lista, solicitar una cadena inicial obligatoria
            if (lista == null) {
                System.out.print("Ingrese una cadena de texto: ");
                String cadena = scanner.nextLine();
                
                if (cadena.isEmpty()) {
                    System.out.println("\nAdvertencia: La cadena esta vacia. Intente nuevamente.");
                    continue;
                }
                
                lista = construirListaDesdeTexto(cadena);
                
                System.out.println("\n========================================");
                System.out.println("Lista creada exitosamente!");
                System.out.println("Numero de caracteres: " + lista.getTamanio());
                System.out.println("========================================");
                
                System.out.print("\nCadena original: ");
                lista.mostrarCaracteres();
            }
            
            mostrarMenu();
            
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer del newline
                
                System.out.println();
                
                /**
                 * Switch principal para manejar todas las opciones del menú
                 * Cada caso corresponde a una funcionalidad específica
                 */
                switch (opcion) {
                    case 1:
                        // Opción 1: Crear nueva lista desde cadena
                        System.out.print("Ingrese una nueva cadena de texto: ");
                        String nuevaCadena = scanner.nextLine();
                        
                        if (nuevaCadena.isEmpty()) {
                            System.out.println("Advertencia: La cadena esta vacia.");
                        } else {
                            lista = construirListaDesdeTexto(nuevaCadena);
                            System.out.println("Nueva lista creada!");
                            System.out.print("Cadena: ");
                            lista.mostrarCaracteres();
                        }
                        break;
                        
                    case 2:
                        // Opción 2: Mostrar lista en dirección hacia adelante
                        if (lista != null) {
                            lista.mostrarAdelante();
                        } else {
                            System.out.println("No hay lista para mostrar.");
                        }
                        break;
                        
                    case 3:
                        // Opción 3: Mostrar lista en dirección hacia atrás
                        if (lista != null) {
                            lista.mostrarAtras();
                        } else {
                            System.out.println("No hay lista para mostrar.");
                        }
                        break;
                        
                    case 4:
                        // Opción 4: Ordenar usando algoritmo Burbuja
                        if (lista != null) {
                            System.out.print("Lista antes de ordenar: ");
                            lista.mostrarCaracteres();
                            
                            lista.ordenarBurbuja();
                            
                            System.out.println("Lista ordenada con Burbuja!");
                            System.out.print("Lista ordenada: ");
                            lista.mostrarCaracteres();
                        } else {
                            System.out.println("No hay lista para ordenar.");
                        }
                        break;
                        
                    case 5:
                        // Opción 5: Ordenar usando algoritmo Inserción
                        if (lista != null) {
                            System.out.print("Lista antes de ordenar: ");
                            lista.mostrarCaracteres();
                            
                            lista.ordenarInsercion();
                            
                            System.out.println("Lista ordenada con Insercion!");
                            System.out.print("Lista ordenada: ");
                            lista.mostrarCaracteres();
                        } else {
                            System.out.println("No hay lista para ordenar.");
                        }
                        break;
                        
                    case 6:
                        // Opción 6: Ordenar usando algoritmo Selección
                        if (lista != null) {
                            System.out.print("Lista antes de ordenar: ");
                            lista.mostrarCaracteres();
                            
                            lista.ordenarSeleccion();
                            
                            System.out.println("Lista ordenada con Seleccion!");
                            System.out.print("Lista ordenada: ");
                            lista.mostrarCaracteres();
                        } else {
                            System.out.println("No hay lista para ordenar.");
                        }
                        break;
                        
                    case 7:
                        // Opción 7: Mostrar información técnica de la lista
                        if (lista != null) {
                            lista.mostrarInformacion();
                        } else {
                            System.out.println("No hay lista.");
                        }
                        break;
                        
                    case 8:
                        // Opción 8: Verificar integridad estructural de la lista
                        if (lista != null) {
                            boolean integra = lista.verificarIntegridad();
                            System.out.println("Verificacion de integridad: " + 
                                (integra ? "CORRECTA" : "ERROR - Lista daniada"));
                        } else {
                            System.out.println("No hay lista para verificar.");
                        }
                        break;
                        
                    case 0:
                        // Opción 0: Salir del programa
                        continuar = false;
                        System.out.println("========================================");
                        System.out.println("       Gracias por usar el programa     ");
                        System.out.println("========================================");
                        break;
                        
                    default:
                        System.out.println("Opcion invalida. Intente nuevamente.");
                }
                
            } catch (Exception e) {
                System.out.println("Error: Entrada invalida. Intente nuevamente.");
                scanner.nextLine(); // Limpiar buffer de entrada inválida
            }
        }
        
        scanner.close();
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * ARQUITECTURA DEL PROGRAMA:
 * - Separación clara entre lógica de UI y lógica de datos
 * - Patrón MVC implícito: Actividad5 (Vista/Controlador), ListaDobleEnlazada (Modelo)
 * - Flujo de control basado en estado (variable 'lista')
 * - Manejo centralizado de excepciones en bucle principal
 * 
 * CARACTERÍSTICAS DE USABILIDAD:
 * - Interfaz intuitiva con numeración consistente
 * - Validación de entradas en tiempo real
 * - Mensajes de confirmación para operaciones críticas
 * - Formato visual atractivo con separadores
 * - Navegación fluida entre opciones
 * 
 * MANEJO DE ENTRADA/SALIDA:
 * - Configuración UTF-8 para soporte multilingüe
 * - Scanner con manejo explícito de encoding
 * - Limpieza de buffer después de cada entrada numérica
 * - Salida formateada para mejor legibilidad
 * 
 * ALGORITMOS DE ORDENAMIENTO IMPLEMENTADOS:
 * - Burbuja: O(n²) estable, comparaciones adyacentes
 * - Inserción: O(n²) estable, eficiente para listas casi ordenadas
 * - Selección: O(n²) inestable, mínimo número de intercambios
 * 
 * FLUJO DE EJECUCIÓN ROBUSTO:
 * - Verificación de nulidad antes de cada operación
 * - Manejo de listas vacías
 * - Recuperación graceful de errores de entrada
 * - Liberación explícita de recursos (Scanner)
 * 
 * EJEMPLO DE USO COMPLETO:
 * Entrada: "programacion"
 * Opción 4 (Burbuja): "aacgimnoporr"
 * Opción 5 (Inserción): "aacgimnoporr" 
 * Opción 6 (Selección): "aacgimnoporr"
 * Opción 7: Muestra tamaño, primer/último nodo, etc.
 * Opción 8: "CORRECTA"
 * 
 * MEJORAS POSIBLES:
 * - Persistencia de listas en archivos
 * - Comparación de rendimiento entre algoritmos
 * - Ordenamiento descendente como opción
 * - Búsqueda de caracteres específicos
 * - Estadísticas de frecuencia de caracteres
 * - Interfaz gráfica de usuario (GUI)
 * - Historial de operaciones realizadas
 * - Exportación de resultados a formato texto
 * - Soporte para diferentes criterios de ordenamiento
 * - Análisis de complejidad en tiempo real
 */
