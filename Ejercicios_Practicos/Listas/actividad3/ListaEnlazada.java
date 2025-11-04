package ejerciciosGuiados.actividad3;

/**
 * Implementación de una lista enlazada genérica simple.
 * Proporciona operaciones básicas para agregar elementos y consultar estado.
 * 
 * @param <T> Tipo de dato a almacenar en la lista
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class ListaEnlazada<T> {
    
    /** Referencia al primer nodo de la lista */
    private Nodo<T> cabeza;
    
    /** Contador de elementos en la lista */
    private int tamaño;
    
    /**
     * Constructor que inicializa una lista vacía.
     */
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * 
     * Si la lista está vacía, el nuevo nodo se convierte en la cabeza.
     * Si no, recorre hasta el último nodo y enlaza el nuevo.
     * 
     * Complejidad: O(n)
     * 
     * @param dato Elemento a agregar al final
     */
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            // Recorre hasta el último nodo
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }
    
    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si no hay elementos, false en caso contrario
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    /**
     * Obtiene el número de elementos en la lista.
     * 
     * @return Cantidad de elementos
     */
    public int getTamaño() {
        return tamaño;
    }
    
    /**
     * Obtiene la referencia al primer nodo de la lista.
     * Útil para recorridos externos o procesamiento personalizado.
     * 
     * @return Nodo cabeza, o null si la lista está vacía
     */
    public Nodo<T> getCabeza() {
        return cabeza;
    }
}
