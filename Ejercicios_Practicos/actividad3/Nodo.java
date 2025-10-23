package ejerciciosGuiados.actividad3;

/**
 * Representa un nodo genérico de una lista enlazada simple.
 * Cada nodo almacena un dato de tipo T y una referencia al siguiente nodo.
 * 
 * El dato es inmutable después de la creación (no tiene setDato()).
 * 
 * @param <T> Tipo de dato a almacenar en el nodo
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Nodo<T> {
    
    /** Dato almacenado en el nodo (inmutable) */
    private T dato;
    
    /** Referencia al siguiente nodo (null si es el último) */
    private Nodo<T> siguiente;
    
    /**
     * Constructor que crea un nuevo nodo con un dato específico.
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
