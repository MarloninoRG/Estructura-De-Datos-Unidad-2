package ejerciciosGuiados.actividad2;

/**
 * Representa un nodo genérico de una lista enlazada simple.
 * Cada nodo almacena un dato de tipo T y una referencia al siguiente nodo.
 * 
 * Esta clase es el bloque fundamental para construir estructuras de datos
 * dinámicas como listas enlazadas, pilas y colas.
 * 
 * @param <T> Tipo de dato a almacenar en el nodo (String, Integer, Object, etc.)
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasgalindo@gmail.com
 * @version 1.0
 * @since 2025
 */
class Nodo<T> {
    
    /** Dato almacenado en el nodo (puede ser de cualquier tipo) */
    private T dato;
    
    /** Referencia al siguiente nodo en la lista (null si es el último) */
    private Nodo<T> siguiente;
    
    /**
     * Constructor que crea un nuevo nodo con un dato específico.
     * El enlace al siguiente nodo se inicializa como null.
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
     * Modifica el dato almacenado en el nodo.
     * 
     * @param dato Nuevo valor para el nodo
     */
    public void setDato(T dato) {
        this.dato = dato;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo.
     * 
     * @return Siguiente nodo en la lista, o null si es el último
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece la referencia al siguiente nodo.
     * Utilizado para enlazar nodos y construir la lista.
     * 
     * @param siguiente Nodo que seguirá a este en la lista
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}