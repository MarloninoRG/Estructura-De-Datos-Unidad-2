package ejerciciosGuiados.actividad3;

/**
 * Representa un nodo genérico inmutable de una lista enlazada simple.
 * Cada nodo almacena un dato de tipo T y una referencia al siguiente nodo.
 * 
 * Esta versión es más restrictiva que otras implementaciones, ya que
 * no permite modificar el dato después de la creación (sin setDato()).
 * 
 * @param <T> Tipo de dato a almacenar en el nodo
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Nodo<T> {
    
    /** Dato almacenado en el nodo (inmutable después de la creación) */
    private T dato;
    
    /** Referencia al siguiente nodo en la lista (null si es el último) */
    private Nodo<T> siguiente;
    
    /**
     * Constructor que crea un nuevo nodo con un dato específico.
     * El dato no podrá modificarse después de la creación.
     * 
     * @param dato Valor a almacenar en el nodo
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el dato almacenado en el nodo.
     * 
     * @return Dato del nodo
     */
    public T getDato() {
        return dato;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo.
     * 
     * @return Siguiente nodo, o null si es el último
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece la referencia al siguiente nodo.
     * Utilizado para enlazar nodos al construir la lista.
     * 
     * @param siguiente Nodo que seguirá a este en la lista
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * CARACTERÍSTICAS:
 * - Visibilidad pública: Puede usarse desde otros paquetes
 * - Dato inmutable: No tiene setDato(), el valor no puede cambiarse
 * - Enlace mutable: El siguiente nodo sí puede modificarse
 * - Genérico: Funciona con cualquier tipo de dato
 * 
 * DIFERENCIAS CON LA ACTIVIDAD 2:
 * - Actividad 2: Tenía setDato() - dato mutable
 * - Actividad 3: Sin setDato() - dato inmutable
 * - Actividad 2: Visibilidad package
 * - Actividad 3: Visibilidad pública
 * 
 * VENTAJAS DE LA INMUTABILIDAD:
 * - Thread-safe: Seguro para programación concurrente
 * - Predecible: El dato no cambia accidentalmente
 * - Más seguro: Previene modificaciones no deseadas
 * 
 * USO TÍPICO:
 * Nodo<Integer> nodo1 = new Nodo<>(10);
 * Nodo<Integer> nodo2 = new Nodo<>(20);
 * nodo1.setSiguiente(nodo2);  // Enlaza: 10 -> 20
 * 
 * // No es posible modificar el dato:
 * // nodo1.setDato(15); // ❌ Método no existe
 * 
 * COMPLEJIDAD:
 * - Constructor: O(1)
 * - getDato(): O(1)
 * - getSiguiente(): O(1)
 * - setSiguiente(): O(1)
 * 
 * CUÁNDO USAR ESTA VERSIÓN:
 * - Cuando los datos no deben cambiar después de crearse
 * - En estructuras donde solo se reorganizan enlaces
 * - Para garantizar integridad de datos
 */
