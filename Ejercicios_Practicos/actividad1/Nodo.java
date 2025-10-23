package ejerciciosGuiados.actividad1;

/**
 * Representa un nodo de una lista enlazada simple.
 * Cada nodo contiene un dato entero y una referencia al siguiente nodo.
 * 
 * Esta clase es el bloque fundamental para construir estructuras
 * de datos dinámicas como listas, pilas y colas enlazadas.
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Nodo {
    
    // Atributos
    
    /** Valor entero almacenado en el nodo */
    private int dato;
    
    /** Referencia al siguiente nodo en la lista (null si es el último) */
    private Nodo siguiente;
    
    /**
     * Constructor que crea un nuevo nodo con un valor específico.
     * El enlace al siguiente nodo se inicializa como null.
     * 
     * @param dato Valor entero a almacenar en el nodo
     */
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Métodos getters y setters
    
    /**
     * Obtiene el valor almacenado en el nodo.
     * 
     * @return Valor entero del nodo
     */
    public int getDato() {
        return dato;
    }
    
    /**
     * Modifica el valor almacenado en el nodo.
     * 
     * @param dato Nuevo valor entero para el nodo
     */
    public void setDato(int dato) {
        this.dato = dato;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     * 
     * @return Siguiente nodo, o null si es el último nodo
     */
    public Nodo getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece la referencia al siguiente nodo en la lista.
     * Utilizado para enlazar nodos y construir la lista.
     * 
     * @param siguiente Nodo que seguirá a este en la lista
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

/*
 * CARACTERÍSTICAS DE LA CLASE:
 * 
 * - Encapsulamiento: Atributos privados con acceso mediante getters/setters
 * - Inmutabilidad parcial: El dato puede modificarse después de la creación
 * - Simplicidad: Solo dos atributos esenciales para una lista enlazada
 * 
 * USO TÍPICO:
 * 
 * Nodo nodo1 = new Nodo(10);
 * Nodo nodo2 = new Nodo(20);
 * nodo1.setSiguiente(nodo2);  // Enlaza nodo1 -> nodo2
 * 
 * MEJORAS POSIBLES:
 * - Sobrescribir toString() para facilitar depuración
 * - Sobrescribir equals() y hashCode() para comparaciones
 * - Hacer la clase genérica: Nodo<T> para cualquier tipo de dato
 */