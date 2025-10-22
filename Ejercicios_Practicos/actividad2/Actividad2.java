package ejerciciosGuiados.actividad2;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Gestor de lista enlazada de palabras con persistencia en archivo.
 * Permite leer, agregar, eliminar y guardar palabras desde/hacia un archivo de texto.
 * 
 * Funcionalidades:
 * - Carga palabras desde archivo al iniciar
 * - Visualización de palabras almacenadas
 * - Agregar nuevas palabras
 * - Eliminar palabras existentes
 * - Guardar cambios en archivo al finalizar
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasservices@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Actividad2 {
    
    /**
     * Método principal que ejecuta el gestor de palabras con menú interactivo.
     * 
     * Flujo del programa:
     * 1. Lee palabras desde archivo y carga en lista enlazada
     * 2. Muestra menú con 4 opciones
     * 3. Procesa operaciones sobre la lista
     * 4. Guarda cambios en archivo al salir
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Inicialización de recursos
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        
        /** Ruta del archivo de texto que contiene las palabras */
        String nombreArchivo = "C:\\Users\\Marlon Rojas Galindo\\OneDrive\\Documentos\\NetBeansProjects\\Unidad2\\src\\ejerciciosGuiados\\actividad2\\Archivo.txt";
        
        System.out.println("=== GESTOR DE LISTA ENLAZADA DE PALABRAS ===\n");
        
        // Carga inicial: lee palabras del archivo y las almacena en lista enlazada
        ListaEnlazada<String> listaPalabras = GestorArchivos.leerArchivo(nombreArchivo);
        
        boolean continuar = true;
        
        // Ciclo principal del menú
        while (continuar) {
            mostrarMenu();
            String opcion = scanner.nextLine();
            
            switch (opcion) {
                case "1": // Mostrar palabras
                    mostrarPalabras(listaPalabras);
                    break;
                    
                case "2": // Agregar palabra
                    agregarPalabra(scanner, listaPalabras);
                    break;
                    
                case "3": // Eliminar palabra
                    eliminarPalabra(scanner, listaPalabras);
                    break;
                    
                case "4": // Guardar y salir
                    guardarYSalir(nombreArchivo, listaPalabras);
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("✗ Opción inválida. Intente de nuevo.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menú de opciones disponibles.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Mostrar palabras");
        System.out.println("2. Agregar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Guardar y salir");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Muestra todas las palabras de la lista con el total.
     * 
     * @param lista Lista enlazada de palabras
     */
    private static void mostrarPalabras(ListaEnlazada<String> lista) {
        System.out.println("\n--- PALABRAS EN LA LISTA ---");
        
        if (lista.estaVacia()) {
            System.out.println("No hay palabras en la lista.");
        } else {
            lista.mostrar();
            System.out.println("\nTotal: " + lista.getTamaño() + " palabras");
        }
    }
    
    /**
     * Solicita y agrega una nueva palabra a la lista.
     * Valida que la palabra no esté vacía.
     * 
     * @param scanner Scanner para lectura de entrada
     * @param lista Lista enlazada donde se agregará la palabra
     */
    private static void agregarPalabra(Scanner scanner, ListaEnlazada<String> lista) {
        System.out.print("\nIngrese la palabra a agregar: ");
        String nuevaPalabra = scanner.nextLine().trim();
        
        if (!nuevaPalabra.isEmpty()) {
            lista.agregarAlFinal(nuevaPalabra);
            System.out.println("✓ Palabra agregada: " + nuevaPalabra);
        } else {
            System.out.println("✗ No se puede agregar una palabra vacía.");
        }
    }
    
    /**
     * Solicita y elimina una palabra de la lista.
     * Informa si la palabra fue encontrada y eliminada.
     * 
     * @param scanner Scanner para lectura de entrada
     * @param lista Lista enlazada de donde se eliminará la palabra
     */
    private static void eliminarPalabra(Scanner scanner, ListaEnlazada<String> lista) {
        System.out.print("\nIngrese la palabra a eliminar: ");
        String palabraEliminar = scanner.nextLine().trim();
        
        if (lista.eliminar(palabraEliminar)) {
            System.out.println("✓ Palabra eliminada: " + palabraEliminar);
        } else {
            System.out.println("✗ La palabra no se encontró en la lista.");
        }
    }
    
    /**
     * Guarda los cambios en el archivo y despide al usuario.
     * 
     * @param nombreArchivo Ruta del archivo donde guardar
     * @param lista Lista enlazada con las palabras a guardar
     */
    private static void guardarYSalir(String nombreArchivo, ListaEnlazada<String> lista) {
        GestorArchivos.escribirArchivo(nombreArchivo, lista);
        System.out.println("\n¡Hasta luego!");
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * ESTRUCTURA:
 * - Patrón: Menú interactivo con ciclo while
 * - Persistencia: Archivo de texto para almacenamiento
 * - Estructura de datos: Lista enlazada genérica
 * 
 * DEPENDENCIAS:
 * - ListaEnlazada<String>: Estructura de datos principal
 * - GestorArchivos: Maneja lectura/escritura de archivos
 * - Scanner: Entrada de usuario
 * 
 * MEJORAS POSIBLES:
 * - Validar existencia del archivo antes de leer
 * - Agregar opción para buscar palabras
 * - Implementar ordenamiento alfabético
 * - Permitir modificar palabras existentes
 * - Usar path relativo en lugar de absoluto
 * - Agregar confirmación antes de salir si hay cambios sin guardar
 */
