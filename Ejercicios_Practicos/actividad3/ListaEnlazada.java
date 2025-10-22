package ejerciciosGuiados.actividad3;

/**
 * Implementación simplificada de una lista enlazada genérica.
 * Proporciona operaciones básicas para agregar elementos y consultar estado.
 * 
 * Esta versión es más ligera que versiones anteriores, enfocada en
 * operaciones esenciales sin métodos de eliminación o visualización.
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
     * Proceso:
     * 1. Si la lista está vacía, el nuevo nodo se convierte en la cabeza
     * 2. Si no, recorre hasta el último nodo y enlaza el nuevo
     * 
     * Complejidad: O(n) donde n es el tamaño de la lista
     * 
     * @param dato Elemento a agregar al final
     */
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (cabeza == null) {
            // Lista vacía: nuevo nodo es la cabeza
            cabeza = nuevoNodo;
        } else {
            // Recorrer hasta el último nodo
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            // Enlazar el nuevo nodo al final
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

/*
 * NOTAS TÉCNICAS:
 * 
 * CARACTERÍSTICAS:
 * - Visibilidad package: Sin 'public', accesible solo en el mismo paquete
 * - Operaciones limitadas: Solo agregar, consultar tamaño y acceder a cabeza
 * - No incluye: mostrar(), eliminar(), obtenerTodos()
 * 
 * DIFERENCIAS CON OTRAS VERSIONES:
 * - Más simple: Menos métodos, enfoque en lo esencial
 * - getCabeza() expuesto: Permite recorridos externos
 * - Sin métodos de visualización: Delegado a otras clases
 * 
 * USO TÍPICO:
 * ListaEnlazada<String> lista = new ListaEnlazada<>();
 * lista.agregarAlFinal("Primero");
 * lista.agregarAlFinal("Segundo");
 * 
 * // Recorrido manual usando getCabeza()
 * Nodo<String> actual = lista.getCabeza();
 * while (actual != null) {
 *     System.out.println(actual.getDato());
 *     actual = actual.getSiguiente();
 * }
 * 
 * COMPLEJIDAD:
 * - agregarAlFinal(): O(n)
 * - estaVacia(): O(1)
 * - getTamaño(): O(1)
 * - getCabeza(): O(1)
 * 
 * MEJORAS POSIBLES:
 * - Mantener referencia al último nodo para inserción O(1)
 * - Agregar método agregarAlInicio() para inserción eficiente
 * - Implementar método mostrar() para visualización
 * - Agregar validación de dato null en agregarAlFinal()
 */
