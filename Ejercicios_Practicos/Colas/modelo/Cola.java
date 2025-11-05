package ejerciciosGuiadosColas.modelo;

/**
 * Clase que implementa el Tipo Abstracto de Datos (TAD) Cola
 * Estructura de datos FIFO (First In, First Out) con operaciones básicas
 * Utiliza genéricos para almacenar cualquier tipo de dato
 * Implementación basada en nodos enlazados
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasservices@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * @param <T> Tipo genérico de los elementos que almacenará la cola
 */
public class Cola<T> {
    //Atributos de la clase
    private Nodo<T> cabeza;  // Apunta al primer elemento (frente de la cola)
    private Nodo<T> cola;     // Apunta al último elemento (final de la cola)
    private int tamano;       // Cantidad de elementos en la cola
    
    /**
     * Constructor de la clase Cola
     * Inicializa una cola vacía sin elementos
     * Cabeza y cola se establecen en null, tamaño en 0
     */
    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }
    
    /**
     * Obtiene la referencia al nodo cabeza (frente de la cola)
     * @return El nodo en la cabeza de la cola, o null si está vacía
     */
    public Nodo<T> getCabeza() {
        return cabeza;
    }
    
    /**
     * Establece la referencia al nodo cabeza
     * @param cabeza El nuevo nodo cabeza de la cola
     */
    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }
    
    /**
     * Obtiene la referencia al nodo cola (final de la cola)
     * @return El nodo en la cola de la estructura, o null si está vacía
     */
    public Nodo<T> getCola() {
        return cola;
    }
    
    /**
     * Establece la referencia al nodo cola
     * @param cola El nuevo nodo cola de la estructura
     */
    public void setCola(Nodo<T> cola) {
        this.cola = cola;
    }
    
    /**
     * Obtiene el tamaño actual de la cola
     * @return La cantidad de elementos en la cola
     */
    public int getTamano() {
        return tamano;
    }
    
    /**
     * Establece el tamaño de la cola
     * @param tamano El nuevo tamaño de la cola
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    /**
     * Verifica si la cola está vacía
     * Una cola está vacía cuando su cabeza es null
     * @return true si la cola no tiene elementos, false en caso contrario
     */
    public boolean colaVacia() {
        return cabeza == null;
    }
    
    /**
     * Inserta un elemento al final de la cola (operación Enqueue)
     * Maneja dos casos: cola vacía y cola con elementos
     * Incrementa automáticamente el tamaño de la cola
     * @param elemento El dato a insertar en la cola
     */
    public void insertar(T elemento) {
        //Crea un nuevo nodo con el elemento
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        
        if(colaVacia()) { 
            //Caso 1: La cola está vacía, el nuevo nodo es cabeza y cola
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else { 
            //Caso 2: La cola NO está vacía, se agrega al final
            //El nodo actual que era el 'final' ahora apunta al nuevo nodo
            this.cola.setSiguiente(nuevoNodo);
            //El puntero 'cola' (final) se mueve al nuevo nodo
            this.cola = nuevoNodo;
        }
        tamano++; //Incrementa el tamaño de la cola
        System.out.println("-> Insertado: " + elemento);
    }
    
    /**
     * Quita y retorna el primer elemento de la cola (operación Dequeue)
     * Remueve el elemento del frente y ajusta la cabeza
     * Maneja el caso de cola vacía y actualiza referencias
     * Decrementa automáticamente el tamaño de la cola
     * @return El dato del elemento removido del frente, o null si está vacía
     */
    public T quitar() {
        if (colaVacia()) {
            System.out.println("Error: La cola está vacía");
            return null;
        }
        
        //Guarda el dato del nodo a retirar
        T datoQuitado = this.cabeza.getDato();
        
        //Mueve la cabeza al siguiente nodo
        this.cabeza = this.cabeza.getSiguiente();
        
        //Si la cola quedó vacía, actualiza también el puntero cola
        if(this.cabeza == null) {
            this.cola = null;
        }
        tamano--; //Decrementa el tamaño
        return datoQuitado;
    }
    
    /**
     * Operación Frente (Peek): Consulta el elemento del frente sin removerlo
     * Permite ver el próximo elemento a ser retirado sin modificar la cola
     * @return El dato del elemento en el frente, o null si está vacía
     */
    public T frente() {
        if(colaVacia()) {
            System.out.println("Error: La cola está vacía");
            return null;
        }
        return this.cabeza.getDato();
    }
    
    /**
     * Muestra todos los elementos de la cola en orden
     * Recorre la cola desde la cabeza hasta el final sin modificarla
     * Útil para depuración y visualización del contenido
     * @param cola TAD Cola a recorrer y mostrar
     */
    public void mostrarTodo(Cola<T> cola) {
        if(cola.colaVacia()) {
            System.out.println("ERROR: La cola está vacía");
            return;
        }
        
        //Recorre todos los nodos desde la cabeza hasta el final
        Nodo<T> temp = cabeza;
        while(temp != null) {
            System.out.println("" + temp.getDato());
            temp = temp.getSiguiente();
        }
    }
}
