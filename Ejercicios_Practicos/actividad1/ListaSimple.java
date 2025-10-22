package ejerciciosGuiados.actividad1;

import java.util.Random;

/**
 * Implementación de una lista enlazada simple para almacenar enteros.
 * Proporciona operaciones básicas: inserción, generación aleatoria,
 * visualización y eliminación condicional.
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasgalindo@gmail.com
 * @version 1.0
 * @since 2025
 */
public class ListaSimple {
    
    /** Referencia al primer nodo de la lista (cabeza) */
    private Nodo head;
    
    /**
     * Constructor que inicializa una lista vacía.
     */
    public ListaSimple() {
        head = null;
    }
    
    /**
     * Inserta un nuevo nodo al final de la lista.
     * Si la lista está vacía, el nuevo nodo se convierte en la cabeza.
     * 
     * Complejidad: O(n) donde n es el tamaño de la lista
     * 
     * @param dato Valor entero a insertar
     */
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        
        if (head == null) {
            // Lista vacía: el nuevo nodo es la cabeza
            head = nuevo;
        } else {
            // Recorrer hasta el último nodo
            Nodo temp = head;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            // Enlazar el nuevo nodo al final
            temp.setSiguiente(nuevo);
        }
    }
    
    /**
     * Genera números aleatorios entre 1 y 100 y los inserta en la lista.
     * 
     * Complejidad: O(n²) debido a n inserciones de complejidad O(n) cada una
     * 
     * @param cantidad Número de elementos aleatorios a generar
     */
    public void generarNumeros(int cantidad) {
        Random r = new Random();
        
        for (int i = 0; i < cantidad; i++) {
            int num = r.nextInt(100) + 1; // Genera números entre 1 y 100
            insertar(num);
        }
    }
    
    /**
     * Muestra todos los elementos de la lista en formato:
     * Lista: 23 -> 45 -> 12 -> null
     * 
     * Complejidad: O(n)
     */
    public void mostrar() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        Nodo temp = head;
        System.out.print("Lista: ");
        
        // Recorrer e imprimir cada nodo
        while (temp != null) {
            System.out.print(temp.getDato() + " -> ");
            temp = temp.getSiguiente();
        }
        
        System.out.println("null");
    }
    
    /**
     * Elimina todos los nodos cuyo valor sea mayor que el límite especificado.
     * 
     * Algoritmo:
     * 1. Elimina nodos al inicio de la lista mientras sean mayores al límite
     * 2. Recorre el resto eliminando nodos que cumplan la condición
     * 
     * Complejidad: O(n)
     * 
     * @param limite Valor de referencia para eliminación (se eliminan valores > límite)
     */
    public void eliminarMayoresQue(int limite) {
        // Caso 1: Eliminar nodos desde la cabeza mientras sean mayores al límite
        while (head != null && head.getDato() > limite) {
            head = head.getSiguiente(); // Avanzar la cabeza al siguiente nodo
        }
        
        // Caso 2: Recorrer el resto de la lista
        Nodo actual = head;
        
        while (actual != null && actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato() > limite) {
                // El siguiente nodo debe eliminarse: saltar ese nodo
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
            } else {
                // El siguiente nodo se conserva: avanzar al siguiente
                actual = actual.getSiguiente();
            }
        }
    }
}

/*
 * CARACTERÍSTICAS DE LA IMPLEMENTACIÓN:
 * 
 * - Estructura: Lista enlazada simple unidireccional
 * - Inserción: Siempre al final (append)
 * - Búsqueda: No implementada
 * - Eliminación: Solo por criterio de valor (mayores que límite)
 * 
 * MEJORAS POSIBLES:
 * - Mantener referencia al último nodo para inserción O(1)
 * - Agregar método para obtener el tamaño de la lista
 * - Implementar eliminación por posición o valor específico
 * - Agregar validación de parámetros (cantidad >= 0)
 */
