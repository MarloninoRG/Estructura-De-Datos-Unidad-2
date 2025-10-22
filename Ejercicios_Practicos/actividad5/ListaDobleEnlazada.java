package ejerciciosGuiados.actividad5;

/**
 * Implementación de una lista doblemente enlazada genérica con capacidades
 * avanzadas de ordenamiento y verificación de integridad.
 * 
 * Esta clase representa una estructura de datos lineal donde cada nodo contiene
 * referencias tanto al nodo siguiente como al anterior, permitiendo recorridos
 * bidireccionales eficientes.
 * 
 * Características principales:
 * - Tipo genérico con restricción Comparable para ordenamiento
 * - Tres algoritmos de ordenamiento implementados (Burbuja, Inserción, Selección)
 * - Verificación automática de integridad estructural
 * - Recorridos bidireccionales (adelante y atrás)
 * - Operaciones de inserción eficientes O(1) al final
 * - Métodos de visualización flexibles
 * 
 * La lista mantiene referencias tanto al primer como al último nodo para
 * operaciones eficientes en ambos extremos.
 * 
 * Ejemplo de uso:
 * ListaDobleEnlazada<Character> lista = new ListaDobleEnlazada<>();
 * lista.agregarAlFinal('c');
 * lista.agregarAlFinal('a');
 * lista.agregarAlFinal('b');
 * lista.ordenarBurbuja(); // Resultado: ['a' ↔ 'b' ↔ 'c']
 * 
 * @param <T> Tipo de dato que debe implementar Comparable para permitir ordenamiento
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class ListaDobleEnlazada<T extends Comparable<T>> {
    
    /** Referencia al primer nodo de la lista (cabeza) */
    private NodoDoble<T> primero;
    
    /** Referencia al último nodo de la lista (cola) */
    private NodoDoble<T> ultimo;
    
    /** Contador del número de elementos en la lista */
    private int tamanio;
    
    /**
     * Constructor que inicializa una lista doblemente enlazada vacía.
     * 
     * Estado inicial:
     * - primero = null (sin nodo inicial)
     * - ultimo = null (sin nodo final)  
     * - tamanio = 0 (lista vacía)
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
     * @return true si la lista está vacía, false si contiene al menos un elemento
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * ListaDobleEnlazada<Integer> lista = new ListaDobleEnlazada<>();
     * lista.estaVacia(); // true
     * lista.agregarAlFinal(5);
     * lista.estaVacia(); // false
     */
    public boolean estaVacia() {
        return primero == null;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * 
     * La operación mantiene la doble vinculación:
     * - En lista vacía: establece primero y ultimo al nuevo nodo
     * - En lista no vacía: enlaza el último nodo con el nuevo y actualiza referencias
     * 
     * @param dato Elemento a agregar al final de la lista (no nulo recomendado)
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * Lista antes: [A ↔ B]
     * agregarAlFinal('C')
     * Lista después: [A ↔ B ↔ C]
     */
    public void agregarAlFinal(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        
        if (estaVacia()) {
            // Primer nodo de la lista
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            // Agregar al final
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
        tamanio++;
    }
    
    /**
     * Muestra la lista completa en dirección hacia adelante (primero a último).
     * 
     * Formato de salida:
     * "Lista (adelante): A <-> B <-> C"
     * 
     * Los elementos se muestran separados por " <-> " para representar
     * visualmente la doble vinculación.
     * 
     * Complejidad: O(n) donde n es el número de elementos
     * 
     * Ejemplo:
     * Lista: [1 ↔ 2 ↔ 3]
     * mostrarAdelante() → "Lista (adelante): 1 <-> 2 <-> 3"
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
     * Muestra la lista completa en dirección hacia atrás (último a primero).
     * 
     * Formato de salida:
     * "Lista (atras): C <-> B <-> A"
     * 
     * Demuestra la capacidad de recorrido bidireccional de la lista
     * doblemente enlazada.
     * 
     * Complejidad: O(n) donde n es el número de elementos
     * 
     * Ejemplo:
     * Lista: [1 ↔ 2 ↔ 3]
     * mostrarAtras() → "Lista (atras): 3 <-> 2 <-> 1"
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
     * Muestra los elementos de la lista sin separadores, útil para
     * representación compacta de cadenas de caracteres.
     * 
     * Formato de salida:
     * "ABC" (sin espacios ni separadores)
     * 
     * Especialmente útil cuando la lista contiene caracteres y se desea
     * visualizar como una cadena continua.
     * 
     * Complejidad: O(n) donde n es el número de elementos
     * 
     * Ejemplo:
     * Lista: ['H' ↔ 'o' ↔ 'l' ↔ 'a']
     * mostrarCaracteres() → "Hola"
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
     * Ordena la lista usando el algoritmo de Burbuja (Bubble Sort).
     * 
     * Características del algoritmo:
     * - Estable (mantiene orden relativo de elementos iguales)
     * - Complejidad: O(n²) en peor caso y promedio
     * - Complejidad: O(n) en mejor caso (lista ordenada)
     * - Ordenamiento in-place (intercambia datos, no nodos)
     * 
     * El algoritmo realiza múltiples pasadas, comparando e intercambiando
     * elementos adyacentes hasta que no se requieren más intercambios.
     * 
     * Ejemplo:
     * Lista antes: [3, 1, 4, 2]
     * ordenarBurbuja()
     * Lista después: [1, 2, 3, 4]
     */
    public void ordenarBurbuja() {
        if (estaVacia() || tamanio == 1) {
            return; // No hay nada que ordenar
        }
        
        boolean intercambio;
        NodoDoble<T> actual;
        
        do {
            intercambio = false;
            actual = primero;
            
            while (actual.getSiguiente() != null) {
                // Comparar dato actual con el siguiente
                if (actual.getDato().compareTo(actual.getSiguiente().getDato()) > 0) {
                    // Intercambiar los datos
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
     * Ordena la lista usando el algoritmo de Inserción (Insertion Sort).
     * 
     * Características del algoritmo:
     * - Estable (mantiene orden relativo de elementos iguales)
     * - Complejidad: O(n²) en peor caso y promedio
     * - Complejidad: O(n) en mejor caso (lista ordenada)
     * - Eficiente para listas pequeñas o parcialmente ordenadas
     * - Ordenamiento in-place con desplazamiento de datos
     * 
     * El algoritmo construye una sublista ordenada e inserta cada elemento
     * en su posición correcta dentro de esta sublista.
     * 
     * Ejemplo:
     * Lista antes: [3, 1, 4, 2]
     * ordenarInsercion()
     * Lista después: [1, 2, 3, 4]
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
            
            // Buscar posición de inserción
            NodoDoble<T> temp = ordenado;
            boolean insertado = false;
            
            while (temp != actual) {
                if (valorActual.compareTo(temp.getDato()) < 0) {
                    // Insertar antes de temp
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
     * Estrategia:
     * 1. Guardar el dato del nodo a insertar
     * 2. Desplazar todos los datos desde la referencia hacia la derecha
     * 3. Colocar el dato guardado en la posición de referencia
     * 
     * @param nodo Nodo que contiene el dato a insertar
     * @param referencia Nodo antes del cual se insertará el dato
     * 
     * Complejidad: O(k) donde k es la distancia entre nodo y referencia
     */
    private void insertarAntesDe(NodoDoble<T> nodo, NodoDoble<T> referencia) {
        T temp = nodo.getDato();
        NodoDoble<T> actual = nodo;
        
        // Desplazar datos hacia la derecha
        while (actual != referencia) {
            NodoDoble<T> ant = actual.getAnterior();
            actual.setDato(ant.getDato());
            actual = ant;
        }
        
        referencia.setDato(temp);
    }
    
    /**
     * Ordena la lista usando el algoritmo de Selección (Selection Sort).
     * 
     * Características del algoritmo:
     * - Inestable (puede alterar orden relativo de elementos iguales)
     * - Complejidad: O(n²) en todos los casos
     * - Realiza mínimo número de intercambios (n-1)
     * - Ordenamiento in-place (intercambia datos, no nodos)
     * 
     * El algoritmo encuentra repetidamente el elemento mínimo del segmento
     * no ordenado y lo coloca al final del segmento ordenado.
     * 
     * Ejemplo:
     * Lista antes: [3, 1, 4, 2]
     * ordenarSeleccion()
     * Lista después: [1, 2, 3, 4]
     */
    public void ordenarSeleccion() {
        if (estaVacia() || tamanio == 1) {
            return;
        }
        
        NodoDoble<T> actual = primero;
        
        while (actual != null) {
            NodoDoble<T> minimo = actual;
            NodoDoble<T> buscador = actual.getSiguiente();
            
            // Buscar el mínimo en el resto de la lista
            while (buscador != null) {
                if (buscador.getDato().compareTo(minimo.getDato()) < 0) {
                    minimo = buscador;
                }
                buscador = buscador.getSiguiente();
            }
            
            // Intercambiar datos
            if (minimo != actual) {
                T temp = actual.getDato();
                actual.setDato(minimo.getDato());
                minimo.setDato(temp);
            }
            
            actual = actual.getSiguiente();
        }
    }
    
    /**
     * Verifica la integridad estructural de la lista doblemente enlazada.
     * 
     * Realiza las siguientes comprobaciones:
     * 1. El primer nodo no tiene anterior (debe ser null)
     * 2. El último nodo no tiene siguiente (debe ser null)
     * 3. Todos los enlaces dobles son consistentes
     * 4. El conteo de nodos coincide con el tamaño registrado
     * 
     * @return true si la estructura es correcta, false si hay inconsistencias
     * 
     * Complejidad: O(n) donde n es el número de elementos
     * 
     * Ejemplo de estructura correcta:
     * primero ↔ nodo1 ↔ nodo2 ↔ ... ↔ ultimo
     * donde: nodo1.anterior = primero, nodo1.siguiente = nodo2, etc.
     */
    public boolean verificarIntegridad() {
        if (estaVacia()) return true;
        
        // Verificar que primero no tenga anterior
        if (primero.getAnterior() != null) return false;
        
        // Verificar que último no tenga siguiente
        if (ultimo.getSiguiente() != null) return false;
        
        // Verificar enlaces dobles
        NodoDoble<T> actual = primero;
        int conteo = 0;
        
        while (actual != null) {
            conteo++;
            
            // Si hay siguiente, verificar que apunte de vuelta
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
     * @return Número de elementos almacenados en la lista
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * Lista: [A ↔ B ↔ C]
     * getTamanio() → 3
     */
    public int getTamanio() {
        return tamanio;
    }
    
    /**
     * Muestra información detallada y de diagnóstico de la lista.
     * 
     * Información mostrada:
     * - Tamaño de la lista
     * - Estado de vaciedad
     * - Primer y último elemento (si existe)
     * - Resultado de verificación de integridad
     * 
     * Formato de salida:
     * ========================================
     *          INFORMACION DE LA LISTA        
     * ========================================
     * Tamanio: 3
     * Esta vacia: No
     * Primer elemento: A
     * Ultimo elemento: C
     * Integridad correcta: Si
     * ========================================
     * 
     * Complejidad: O(1) para información básica, O(n) si incluye verificación
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

/*
 * NOTAS TÉCNICAS:
 * 
 * COMPARACIÓN DE ALGORITMOS DE ORDENAMIENTO:
 * 
 * BURBUJA:
 * - Ventajas: Simple, estable, detecta lista ordenada tempranamente
 * - Desventajas: Lento para listas grandes, muchas comparaciones e intercambios
 * - Uso recomendado: Listas pequeñas o casi ordenadas
 * 
 * INSERCIÓN:
 * - Ventajas: Estable, eficiente para listas pequeñas, buen comportamiento en casi ordenadas
 * - Desventajas: O(n²) en promedio, desplazamientos costosos
 * - Uso recomendado: Listas pequeñas o inserción de pocos elementos en lista ordenada
 * 
 * SELECCIÓN:
 * - Ventajas: Mínimo número de intercambios (n-1), simple implementación
 * - Desventajas: Inestable, siempre O(n²) sin detección temprana
 * - Uso recomendado: Cuando los intercambios son costosos
 * 
 * COMPLEJIDAD ALGORÍTMICA GENERAL:
 * - Constructor: O(1)
 * - estaVacia(): O(1)
 * - agregarAlFinal(): O(1)
 * - mostrarAdelante(): O(n)
 * - mostrarAtras(): O(n)
 * - mostrarCaracteres(): O(n)
 * - ordenarBurbuja(): O(n²)
 * - ordenarInsercion(): O(n²)
 * - ordenarSeleccion(): O(n²)
 * - verificarIntegridad(): O(n)
 * - getTamanio(): O(1)
 * - mostrarInformacion(): O(n) por verificación
 * 
 * DISEÑO DE LA LISTA DOBLEMENTE ENLAZADA:
 * - Ventajas: Recorrido bidireccional, eliminación eficiente, inserción antes/después
 * - Desventajas: Mayor uso de memoria (2 punteros por nodo), mayor complejidad de mantenimiento
 * - Aplicaciones típicas: Navegadores (historial), editores de texto, sistemas de undo/redo
 * 
 * CONSIDERACIONES DE IMPLEMENTACIÓN:
 * - Los algoritmos de ordenamiento intercambian datos, no nodos (más eficiente)
 * - La verificación de integridad es crucial para detectar corrupción
 * - El mantenimiento de 'tamanio' evita recorridos para contar
 * - Referencias a primero y ultimo permiten operaciones O(1) en extremos
 * 
 * MEJORAS POSIBLES:
 * - Implementar ordenamiento Merge Sort O(n log n) para listas grandes
 * - Agregar métodos para eliminar elementos
 * - Implementar búsqueda binaria después de ordenar
 * - Agregar iteradores para enhanced for-loop
 * - Implementar serialización/deserialización
 * - Agregar métodos para invertir la lista
 * - Implementar ordenamiento descendente como opción
 * - Agregar validación de nulidad en parámetros
 * - Implementar versiones que reorganicen nodos en lugar de intercambiar datos
 */
