package ejerciciosGuiados.actividad2;

/**
 * Implementación de una lista enlazada simple con tipos genéricos.
 * Permite almacenar cualquier tipo de dato y realizar operaciones básicas.
 * 
 * Operaciones soportadas:
 * - Agregar elementos al final
 * - Eliminar elementos por valor
 * - Verificar si está vacía
 * - Mostrar elementos
 * - Convertir a lista de Java
 * 
 * @param <T> Tipo de dato a almacenar en la lista
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasgalindo@gmail.com
 * @version 1.0
 * @since 2025
 */
public class ListaEnlazada<T> {
    
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
     * 1. Crea un nuevo nodo con el dato
     * 2. Si la lista está vacía, el nuevo nodo es la cabeza
     * 3. Si no, recorre hasta el último nodo y enlaza el nuevo
     * 
     * Complejidad: O(n)
     * 
     * @param dato Elemento a agregar
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
     * Elimina la primera ocurrencia de un elemento en la lista.
     * 
     * Proceso:
     * 1. Verifica si la lista está vacía
     * 2. Si el elemento está en la cabeza, actualiza la cabeza
     * 3. Si no, recorre buscando el elemento y lo elimina
     * 
     * Complejidad: O(n)
     * 
     * @param dato Elemento a eliminar
     * @return true si el elemento fue encontrado y eliminado, false si no existe
     */
    public boolean eliminar(T dato) {
        if (cabeza == null) {
            return false; // Lista vacía
        }
        
        // Caso 1: El elemento está en la cabeza
        if (cabeza.getDato().equals(dato)) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
            return true;
        }
        
        // Caso 2: Buscar en el resto de la lista
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(dato)) {
                // Saltar el nodo a eliminar
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                tamaño--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        
        return false; // Elemento no encontrado
    }
    
    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista no tiene elementos, false en caso contrario
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
     * Muestra todos los elementos de la lista en formato numerado.
     * 
     * Formato de salida:
     * 1. elemento1
     * 2. elemento2
     * 3. elemento3
     * 
     * Complejidad: O(n)
     */
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        Nodo<T> actual = cabeza;
        int index = 1;
        
        // Recorrer e imprimir cada elemento con su índice
        while (actual != null) {
            System.out.println(index + ". " + actual.getDato());
            actual = actual.getSiguiente();
            index++;
        }
    }
    
    /**
     * Convierte la lista enlazada a una lista de Java (ArrayList).
     * Útil para operaciones que requieren acceso por índice o iteración.
     * 
     * Complejidad: O(n)
     * 
     * @return Lista de Java con todos los elementos en el mismo orden
     */
    public java.util.List<T> obtenerTodos() {
        java.util.List<T> elementos = new java.util.ArrayList<>();
        Nodo<T> actual = cabeza;
        
        // Recorrer y agregar cada elemento a la lista de Java
        while (actual != null) {
            elementos.add(actual.getDato());
            actual = actual.getSiguiente();
        }
        
        return elementos;
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * CARACTERÍSTICAS:
 * - Genérica: Acepta cualquier tipo de dato (String, Integer, etc.)
 * - Tamaño mantenido: Contador actualizado en cada operación
 * - Encapsulamiento: Atributos privados con métodos públicos
 * 
 * COMPLEJIDAD TEMPORAL:
 * - agregarAlFinal(): O(n) - recorre toda la lista
 * - eliminar(): O(n) - búsqueda lineal
 * - estaVacia(): O(1) - verificación directa
 * - getTamaño(): O(1) - retorna atributo
 * - mostrar(): O(n) - recorre toda la lista
 * - obtenerTodos(): O(n) - recorre y copia elementos
 * 
 * COMPLEJIDAD ESPACIAL:
 * - Lista en sí: O(n) donde n es el número de elementos
 * - obtenerTodos(): O(n) adicional para la copia
 * 
 * MEJORAS POSIBLES:
 * - Mantener referencia al último nodo para inserción O(1)
 * - Agregar método agregarAlInicio() para inserción eficiente
 * - Implementar método buscar() que retorne boolean
 * - Agregar método obtenerPorIndice(int index)
 * - Implementar interfaz Iterable para usar en for-each
 * - Sobrescribir toString() para representación de texto
 * - Agregar método limpiar() para vaciar la lista
 */
