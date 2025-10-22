package ejerciciosGuiados.actividad5;

/**
 * Clase Nodo genérica para implementar listas doblemente enlazadas.
 * 
 * Esta clase representa la unidad fundamental de una lista doblemente enlazada,
 * conteniendo un dato y referencias tanto al nodo anterior como al siguiente
 * en la secuencia. Esta estructura permite recorridos bidireccionales eficientes.
 * 
 * Características principales:
 * - Almacenamiento genérico de datos con restricción Comparable
 * - Doble vinculación (anterior y siguiente)
 * - Encapsulamiento completo de atributos
 * - Métodos de acceso controlados (getters/setters)
 * - Representación textual mediante toString()
 * 
 * Estructura típica de un nodo en la lista:
 * [anterior] ← [dato] → [siguiente]
 * 
 * Ejemplo de uso en lista:
 * primero ↔ nodo1 ↔ nodo2 ↔ ... ↔ último
 * donde cada nodo mantiene referencias consistentes a sus vecinos.
 * 
 * @param <T> Tipo de dato a almacenar en el nodo, debe implementar Comparable
 *            para permitir operaciones de ordenamiento y comparación
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class NodoDoble<T extends Comparable<T>> {
    
    /** Dato almacenado en el nodo (tipo genérico T) */
    private T dato;
    
    /** Referencia al nodo anterior en la lista doblemente enlazada */
    private NodoDoble<T> anterior;
    
    /** Referencia al nodo siguiente en la lista doblemente enlazada */
    private NodoDoble<T> siguiente;
    
    /**
     * Constructor que inicializa un nuevo nodo con el dato especificado.
     * 
     * El nodo se crea con referencias nulas a anterior y siguiente, lo que
     * indica que está aislado. Estas referencias se establecerán cuando
     * el nodo sea insertado en una lista doblemente enlazada.
     * 
     * @param dato Información a almacenar en el nodo (no nulo recomendado)
     * 
     * Complejidad: O(1)
     * 
     * Ejemplos:
     * - new NodoDoble<>("Hola")    → Nodo con dato String "Hola"
     * - new NodoDoble<>(42)        → Nodo con dato Integer 42
     * - new NodoDoble<>('A')       → Nodo con dato Character 'A'
     * 
     * @throws NullPointerException si dato es null (depende del uso posterior)
     */
    public NodoDoble(T dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el dato almacenado en el nodo.
     * 
     * @return Dato almacenado en el nodo (tipo genérico T)
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * NodoDoble<String> nodo = new NodoDoble<>("Texto");
     * String valor = nodo.getDato(); // "Texto"
     */
    public T getDato() { 
        return dato; 
    }
    
    /**
     * Establece un nuevo valor para el dato del nodo.
     * 
     * Este método permite modificar el contenido del nodo sin alterar
     * su posición en la lista. Útil para operaciones de ordenamiento
     * que intercambian datos en lugar de reordenar nodos.
     * 
     * @param dato Nuevo valor a almacenar en el nodo
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * NodoDoble<Integer> nodo = new NodoDoble<>(10);
     * nodo.setDato(20); // Cambia el dato de 10 a 20
     */
    public void setDato(T dato) { 
        this.dato = dato; 
    }
    
    /**
     * Obtiene la referencia al nodo anterior en la lista.
     * 
     * En una lista doblemente enlazada correctamente formada:
     * - Para el primer nodo: anterior = null
     * - Para otros nodos: anterior apunta al nodo precedente
     * 
     * @return Referencia al nodo anterior, o null si es el primer nodo
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * // En lista: A ↔ B ↔ C
     * nodoB.getAnterior(); // Retorna nodoA
     * nodoA.getAnterior(); // Retorna null
     */
    public NodoDoble<T> getAnterior() { 
        return anterior; 
    }
    
    /**
     * Establece la referencia al nodo anterior en la lista.
     * 
     * Este método es fundamental para mantener la integridad de la
     * lista doblemente enlazada. Debe usarse junto con setSiguiente()
     * para garantizar la consistencia bidireccional.
     * 
     * @param anterior Nueva referencia al nodo anterior
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * NodoDoble<String> nodoA = new NodoDoble<>("A");
     * NodoDoble<String> nodoB = new NodoDoble<>("B");
     * nodoB.setAnterior(nodoA); // Establece A como anterior de B
     */
    public void setAnterior(NodoDoble<T> anterior) { 
        this.anterior = anterior; 
    }
    
    /**
     * Obtiene la referencia al nodo siguiente en la lista.
     * 
     * En una lista doblemente enlazada correctamente formada:
     * - Para el último nodo: siguiente = null
     * - Para otros nodos: siguiente apunta al nodo sucesor
     * 
     * @return Referencia al nodo siguiente, o null si es el último nodo
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * // En lista: A ↔ B ↔ C
     * nodoB.getSiguiente(); // Retorna nodoC
     * nodoC.getSiguiente(); // Retorna null
     */
    public NodoDoble<T> getSiguiente() { 
        return siguiente; 
    }
    
    /**
     * Establece la referencia al nodo siguiente en la lista.
     * 
     * Este método es fundamental para mantener la integridad de la
     * lista doblemente enlazada. Debe usarse junto con setAnterior()
     * para garantizar la consistencia bidireccional.
     * 
     * @param siguiente Nueva referencia al nodo siguiente
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * NodoDoble<String> nodoA = new NodoDoble<>("A");
     * NodoDoble<String> nodoB = new NodoDoble<>("B");
     * nodoA.setSiguiente(nodoB); // Establece B como siguiente de A
     */
    public void setSiguiente(NodoDoble<T> siguiente) { 
        this.siguiente = siguiente; 
    }
    
    /**
     * Retorna una representación en String del dato almacenado en el nodo.
     * 
     * Esta implementación delega en el método toString() del dato almacenado,
     * lo que permite una representación significativa del contenido del nodo.
     * 
     * @return Representación en String del dato almacenado
     * 
     * Complejidad: O(1) (depende de la implementación de toString() de T)
     * 
     * Ejemplos:
     * - Si dato = "Hola" → "Hola"
     * - Si dato = 42 → "42"
     * - Si dato = 'A' → "A"
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return dato.toString();
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * DISEÑO DE NODO DOBLEMENTE ENLAZADO:
 * 
 * VENTAJAS:
 * - Recorrido bidireccional: Permite navegar hacia adelante y atrás
 * - Eliminación eficiente: O(1) con referencias a vecinos
 * - Inserción flexible: Antes/después de cualquier nodo en O(1)
 * - Estructura fundamental para listas complejas
 * 
 * DESVENTAJAS:
 * - Mayor overhead de memoria: 2 punteros adicionales por nodo
 * - Mayor complejidad de mantenimiento: Doble vinculación a verificar
 * - Operaciones más complejas: Requiere actualizar ambos enlaces
 * 
 * INTEGRIDAD ESTRUCTURAL:
 * Para un nodo correctamente enlazado en una lista:
 * - Si anterior != null, entonces anterior.siguiente == this
 * - Si siguiente != null, entonces siguiente.anterior == this
 * - Un nodo aislado tiene anterior = null y siguiente = null
 * - El primer nodo tiene anterior = null
 * - El último nodo tiene siguiente = null
 * 
 * COMPLEJIDAD COMPUTACIONAL:
 * - Constructor: O(1)
 * - getDato(): O(1)
 * - setDato(): O(1)
 * - getAnterior(): O(1)
 * - setAnterior(): O(1)
 * - getSiguiente(): O(1)
 * - setSiguiente(): O(1)
 * - toString(): O(1) (depende de T.toString())
 * 
 * APLICACIONES TÍPICAS:
 * - Listas doblemente enlazadas (obvio)
 * - Navegadores web (historial adelante/atrás)
 * - Editores de texto (navegación entre caracteres)
 * - Sistemas de undo/redo (mantener historial de estados)
 * - Reproductores multimedia (lista de reproducción)
 * - Implementación de Deque (double-ended queue)
 * - Cachés LRU (Least Recently Used)
 * 
 * CONSIDERACIONES DE IMPLEMENTACIÓN:
 * - La restricción Comparable<T> permite ordenamiento en la lista contenedora
 * - Los setters no verifican consistencia cíclica (responsabilidad del contenedor)
 * - El diseño favorece la reutilización con diferentes tipos de datos
 * - La encapsulación protege la integridad de los enlaces
 * 
 * PATRONES DE USO COMUNES:
 * 
 * 1. Inserción entre dos nodos existentes:
 *    nuevoNodo.setAnterior(nodoExistente);
 *    nuevoNodo.setSiguiente(nodoExistente.getSiguiente());
 *    nodoExistente.getSiguiente().setAnterior(nuevoNodo);
 *    nodoExistente.setSiguiente(nuevoNodo);
 * 
 * 2. Eliminación de un nodo:
 *    nodo.getAnterior().setSiguiente(nodo.getSiguiente());
 *    nodo.getSiguiente().setAnterior(nodo.getAnterior());
 * 
 * 3. Recorrido hacia adelante:
 *    NodoDoble<T> actual = primero;
 *    while (actual != null) {
 *        procesar(actual.getDato());
 *        actual = actual.getSiguiente();
 *    }
 * 
 * 4. Recorrido hacia atrás:
 *    NodoDoble<T> actual = ultimo;
 *    while (actual != null) {
 *        procesar(actual.getDato());
 *        actual = actual.getAnterior();
 *    }
 * 
 * MEJORAS POSIBLES:
 * - Validar que anterior y siguiente no formen ciclos
 * - Implementar equals() y hashCode() basados en el dato
 * - Agregar método clone() para copias profundas
 * - Implementar Comparable<NodoDoble> para comparar por dato
 * - Agregar validación de nulidad en setters
 * - Implementar método para verificar si el nodo está aislado
 * - Agregar método para desconectar el nodo (anular ambos enlaces)
 * - Implementar serialización personalizada
 * 
 * EJEMPLO DE INTEGRACIÓN CON ListaDobleEnlazada:
 * 
 * ListaDobleEnlazada<Character> lista = new ListaDobleEnlazada<>();
 * 
 * // Crear nodos
 * NodoDoble<Character> nodoA = new NodoDoble<>('A');
 * NodoDoble<Character> nodoB = new NodoDoble<>('B');
 * NodoDoble<Character> nodoC = new NodoDoble<>('C');
 * 
 * // Establecer enlaces (simplificado - normalmente lo hace ListaDobleEnlazada)
 * nodoA.setSiguiente(nodoB);
 * nodoB.setAnterior(nodoA);
 * nodoB.setSiguiente(nodoC);
 * nodoC.setAnterior(nodoB);
 * 
 * // Resultado: A ↔ B ↔ C
 */