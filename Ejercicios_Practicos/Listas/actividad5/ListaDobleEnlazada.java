package ejerciciosGuiados.actividad5;

/**
 * Implementación de una lista doblemente enlazada genérica con capacidades
 * de ordenamiento y verificación de integridad.
 * 
 * Esta estructura permite recorridos bidireccionales eficientes, donde cada nodo
 * contiene referencias al nodo siguiente y anterior.
 * 
 * Características:
 * - Tipo genérico con restricción Comparable para ordenamiento
 * - Tres algoritmos de ordenamiento (Burbuja, Inserción, Selección)
 * - Verificación automática de integridad estructural
 * - Recorridos bidireccionales (adelante y atrás)
 * - Operaciones de inserción O(1) al final
 * 
 * @param <T> Tipo de dato que debe implementar Comparable
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class ListaDobleEnlazada<T extends Comparable<T>> {
    
    /** Referencia al primer nodo de la lista */
    private NodoDoble<T> primero;
    
    /** Referencia al último nodo de la lista */
    private NodoDoble<T> ultimo;
    
    /** Contador del número de elementos */
    private int tamanio;
    
    /**
     * Constructor que inicializa una lista vacía.
     * 
     * Complejidad: O(1)
     */
    public ListaDobleEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }
    
    /**
     * Verifica si la lista no contiene elementos.
     * 
     * @return true si está vacía, false si contiene al menos un elemento
     * 
     * Complejidad: O(1)
     */
    public boolean estaVacia() {
        return primero == null;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * 
     * Mantiene la doble vinculación:
     * - Lista vacía: establece primero y ultimo
     * - Lista no vacía: enlaza el último nodo con el nuevo
     * 
     * @param dato Elemento a agregar
     * 
     * Complejidad: O(1)
     */
    public void agregarAlFinal(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        
        if (estaVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
        tamanio++;
    }
    
    /**
     * Muestra la lista en dirección hacia adelante (primero a último).
     * Formato: "Lista (adelante): A <-> B <-> C"
     * 
     * Complejidad: O(n)
     */
    public void mostrarAdelante() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }
        
        NodoDoble<T> actual = primero;
        System.out.print("Lista (adelante): ");
        
        while (actual != null) {
            System.out.print(actual.getDato());
            if (actual.getSiguiente() != null) {
                System.out.print(" <-> ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
    
    /**
     * Muestra la lista en dirección hacia atrás (último a primero).
     * Formato: "Lista (atras): C <-> B <-> A"
     * 
     * Complejidad: O(n)
     */
    public void mostrarAtras() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }
        
        NodoDoble<T> actual = ultimo;
        System.out.print("Lista (atras): ");
        
        while (actual != null) {
            System.out.print(actual.getDato());
            if (actual.getAnterior() != null) {
                System.out.print(" <-> ");
            }
            actual = actual.getAnterior();
        }
        System.out.println();
    }
    
    /**
     * Muestra los elementos sin separadores.
     * Útil para visualizar cadenas de caracteres.
     * 
     * Complejidad: O(n)
     */
    public void mostrarCaracteres() {
        if (estaVacia()) {
            System.out.println("(vacia)");
            return;
        }
        
        NodoDoble<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato());
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
    
    /**
     * Ordena la lista usando el algoritmo de Burbuja.
     * 
     * Características:
     * - Estable (mantiene orden relativo de elementos iguales)
     * - Complejidad: O(n²) peor caso y promedio, O(n) mejor caso
     * - Ordenamiento in-place (intercambia datos, no nodos)
     * 
     * Complejidad: O(n²)
     */
    public void ordenarBurbuja() {
        if (estaVacia() || tamanio == 1) {
            return;
        }
        
        boolean intercambio;
        NodoDoble<T> actual;
        
        do {
            intercambio = false;
            actual = primero;
            
            while (actual.getSiguiente() != null) {
                if (actual.getDato().compareTo(actual.getSiguiente().getDato()) > 0) {
                    T temp = actual.getDato();
                    actual.setDato(actual.getSiguiente().getDato());
                    actual.getSiguiente().setDato(temp);
                    intercambio = true;
                }
                actual = actual.getSiguiente();
            }
        } while (intercambio);
    }
    
    /**
     * Ordena la lista usando el algoritmo de Inserción.
     * 
     * Características:
     * - Estable
     * - Complejidad: O(n²) peor caso y promedio, O(n) mejor caso
     * - Eficiente para listas pequeñas o parcialmente ordenadas
     * 
     * Complejidad: O(n²)
     */
    public void ordenarInsercion() {
        if (estaVacia() || tamanio == 1) {
            return;
        }
        
        NodoDoble<T> ordenado = primero;
        NodoDoble<T> actual = primero.getSiguiente();
        
        while (actual != null) {
            NodoDoble<T> siguiente = actual.getSiguiente();
            T valorActual = actual.getDato();
            
            NodoDoble<T> temp = ordenado;
            boolean insertado = false;
            
            while (temp != actual) {
                if (valorActual.compareTo(temp.getDato()) < 0) {
                    insertarAntesDe(actual, temp);
                    insertado = true;
                    break;
                }
                temp = temp.getSiguiente();
            }
            
            if (!insertado) {
                ordenado = actual;
            }
            
            actual = siguiente;
        }
    }
    
    /**
     * Método auxiliar para insertar un nodo antes de otro mediante
     * desplazamiento de datos.
     * 
     * @param nodo Nodo que contiene el dato a insertar
     * @param referencia Nodo antes del cual se insertará el dato
     * 
     * Complejidad: O(k) donde k es la distancia entre nodos
     */
    private void insertarAntesDe(NodoDoble<T> nodo, NodoDoble<T> referencia) {
        T temp = nodo.getDato();
        NodoDoble<T> actual = nodo;
        
        while (actual != referencia) {
            NodoDoble<T> ant = actual.getAnterior();
            actual.setDato(ant.getDato());
            actual = ant;
        }
        
        referencia.setDato(temp);
    }
    
    /**
     * Ordena la lista usando el algoritmo de Selección.
     * 
     * Características:
     * - Inestable
     * - Complejidad: O(n²) en todos los casos
     * - Realiza mínimo número de intercambios (n-1)
     * 
     * Complejidad: O(n²)
     */
    public void ordenarSeleccion() {
        if (estaVacia() || tamanio == 1) {
            return;
        }
        
        NodoDoble<T> actual = primero;
        
        while (actual != null) {
            NodoDoble<T> minimo = actual;
            NodoDoble<T> buscador = actual.getSiguiente();
            
            while (buscador != null) {
                if (buscador.getDato().compareTo(minimo.getDato()) < 0) {
                    minimo = buscador;
                }
                buscador = buscador.getSiguiente();
            }
            
            if (minimo != actual) {
                T temp = actual.getDato();
                actual.setDato(minimo.getDato());
                minimo.setDato(temp);
            }
            
            actual = actual.getSiguiente();
        }
    }
    
    /**
     * Verifica la integridad estructural de la lista.
     * 
     * Comprobaciones:
     * - El primer nodo no tiene anterior
     * - El último nodo no tiene siguiente
     * - Todos los enlaces dobles son consistentes
     * - El conteo de nodos coincide con el tamaño
     * 
     * @return true si la estructura es correcta, false si hay inconsistencias
     * 
     * Complejidad: O(n)
     */
    public boolean verificarIntegridad() {
        if (estaVacia()) return true;
        
        if (primero.getAnterior() != null) return false;
        if (ultimo.getSiguiente() != null) return false;
        
        NodoDoble<T> actual = primero;
        int conteo = 0;
        
        while (actual != null) {
            conteo++;
            
            if (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getAnterior() != actual) {
                    return false;
                }
            }
            
            actual = actual.getSiguiente();
        }
        
        return conteo == tamanio;
    }
    
    /**
     * Obtiene el número de elementos en la lista.
     * 
     * @return Número de elementos
     * 
     * Complejidad: O(1)
     */
    public int getTamanio() {
        return tamanio;
    }
    
    /**
     * Muestra información detallada de la lista.
     * 
     * Incluye: tamaño, estado, primer/último elemento, integridad.
     * 
     * Complejidad: O(n)
     */
    public void mostrarInformacion() {
        System.out.println("\n========================================");
        System.out.println("         INFORMACION DE LA LISTA        ");
        System.out.println("========================================");
        System.out.println("Tamanio: " + tamanio);
        System.out.println("Esta vacia: " + (estaVacia() ? "Si" : "No"));
        
        if (!estaVacia()) {
            System.out.println("Primer elemento: " + primero.getDato());
            System.out.println("Ultimo elemento: " + ultimo.getDato());
            System.out.println("Integridad correcta: " + (verificarIntegridad() ? "Si" : "No"));
        }
        System.out.println("========================================\n");
    }
}