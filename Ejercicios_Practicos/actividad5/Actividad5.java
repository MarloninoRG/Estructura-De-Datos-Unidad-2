package ejerciciosGuiados.actividad5;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Clase principal que implementa un programa interactivo para manipular
 * listas doblemente enlazadas de caracteres con capacidades de ordenamiento.
 * 
 * Funcionalidades:
 * - Crear listas a partir de cadenas de texto
 * - Visualizar listas en ambas direcciones
 * - Ordenar caracteres usando tres algoritmos (burbuja, inserción, selección)
 * - Verificar la integridad estructural de la lista
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Actividad5 {
    
    /**
     * Construye una lista doblemente enlazada a partir de una cadena de texto.
     * Cada carácter se convierte en un nodo individual.
     * 
     * @param cadena Cadena de texto de entrada
     * @return Lista doblemente enlazada con los caracteres
     * 
     * Complejidad: O(n)
     */
    public static ListaDobleEnlazada<Character> construirListaDesdeTexto(String cadena) {
        ListaDobleEnlazada<Character> lista = new ListaDobleEnlazada<>();
        
        for (int i = 0; i < cadena.length(); i++) {
            lista.agregarAlFinal(cadena.charAt(i));
        }
        
        return lista;
    }
    
    /**
     * Muestra el menú principal de opciones disponibles.
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
     * Método principal que ejecuta el programa interactivo.
     * 
     * Flujo:
     * 1. Configuración del entorno (UTF-8)
     * 2. Entrada inicial de cadena
     * 3. Bucle interactivo con menú
     * 4. Liberación de recursos
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configurar UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.out.println("Advertencia: No se pudo configurar UTF-8");
        }
        
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        ListaDobleEnlazada<Character> lista = null;
        
        // Encabezado
        System.out.println("========================================");
        System.out.println("  LISTA DOBLEMENTE ENLAZADA ORDENADA   ");
        System.out.println("========================================");
        System.out.println();
        
        boolean continuar = true;
        
        while (continuar) {
            // Solicitar cadena inicial si no hay lista
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
                scanner.nextLine(); // Limpiar buffer
                
                System.out.println();
                
                switch (opcion) {
                    case 1:
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
                        if (lista != null) {
                            lista.mostrarAdelante();
                        } else {
                            System.out.println("No hay lista para mostrar.");
                        }
                        break;
                        
                    case 3:
                        if (lista != null) {
                            lista.mostrarAtras();
                        } else {
                            System.out.println("No hay lista para mostrar.");
                        }
                        break;
                        
                    case 4:
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
                        if (lista != null) {
                            lista.mostrarInformacion();
                        } else {
                            System.out.println("No hay lista.");
                        }
                        break;
                        
                    case 8:
                        if (lista != null) {
                            boolean integra = lista.verificarIntegridad();
                            System.out.println("Verificacion de integridad: " + 
                                (integra ? "CORRECTA" : "ERROR - Lista daniada"));
                        } else {
                            System.out.println("No hay lista para verificar.");
                        }
                        break;
                        
                    case 0:
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
                scanner.nextLine(); // Limpiar buffer
            }
        }
        
        scanner.close();
    }
}