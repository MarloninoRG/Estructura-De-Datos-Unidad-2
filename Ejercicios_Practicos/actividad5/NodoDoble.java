package ejerciciosGuiados.actividad5;

/**
 * Clase Nodo genérica para implementar listas doblemente enlazadas.
 * 
 * Representa la unidad fundamental de una lista doblemente enlazada,
 * conteniendo un dato y referencias al nodo anterior y siguiente.
 * Esta estructura permite recorridos bidireccionales eficientes.
 * 
 * Estructura: [anterior] ← [dato] → [siguiente]
 * 
 * @param <T> Tipo de dato a almacenar, debe implementar Comparable
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class NodoDoble<T extends Comparable<T>> {
    
    /** Dato almacenado en el nodo */
    private T dato;
    
    /** Referencia al nodo anterior */
    private NodoDoble<T> anterior;
    
    /** Referencia al nodo siguiente */
    private NodoDoble<T> siguiente;
    
    /**
     * Constructor que inicializa un nuevo nodo con el dato especificado.
     * Las referencias anterior y siguiente se inicializan como null.
     * 
     * @param dato Información a almacenar en el nodo
     * 
     * Complejidad: O(1)
     */
    public NodoDoble(T dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el dato almacenado en el nodo.
     * 
     * @return Dato almacenado
     * 
     * Complejidad: O(1)
     */
    public T getDato() { 
        return dato; 
    }
    
    /**
     * Establece un nuevo valor para el dato del nodo.
     * Útil para ordenamiento que intercambia datos sin reordenar nodos.
     * 
     * @param dato Nuevo valor a almacenar
     * 
     * Complejidad: O(1)
     */
    public void setDato(T dato) { 
        this.dato = dato; 
    }
    
    /**
     * Obtiene la referencia al nodo anterior en la lista.
     * 
     * @return Referencia al nodo anterior, o null si es el primer nodo
     * 
     * Complejidad: O(1)
     */
    public NodoDoble<T> getAnterior() { 
        return anterior; 
    }
    
    /**
     * Establece la referencia al nodo anterior.
     * Debe usarse junto con setSiguiente() para mantener consistencia bidireccional.
     * 
     * @param anterior Nueva referencia al nodo anterior
     * 
     * Complejidad: O(1)
     */
    public void setAnterior(NodoDoble<T> anterior) { 
        this.anterior = anterior; 
    }
    
    /**
     * Obtiene la referencia al nodo siguiente en la lista.
     * 
     * @return Referencia al nodo siguiente, o null si es el último nodo
     * 
     * Complejidad: O(1)
     */
    public NodoDoble<T> getSiguiente() { 
        return siguiente; 
    }
    
    /**
     * Establece la referencia al nodo siguiente.
     * Debe usarse junto con setAnterior() para mantener consistencia bidireccional.
     * 
     * @param siguiente Nueva referencia al nodo siguiente
     * 
     * Complejidad: O(1)
     */
    public void setSiguiente(NodoDoble<T> siguiente) { 
        this.siguiente = siguiente; 
    }
    
    /**
     * Retorna una representación en String del dato almacenado.
     * 
     * @return Representación en String del dato
     * 
     * Complejidad: O(1)
     */
    @Override
    public String toString() {
        return dato.toString();
    }
}