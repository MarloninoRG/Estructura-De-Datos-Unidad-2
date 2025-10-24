package colas;

/**
 * Clase que implementa una TAD Cola
 * @author Marlon Rojas Galindo
 * @contact marlonrojasservices@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Cola<T> {
    //Atributos
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;
    
    //Constructor
    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }
    
    //Metodos get y set
    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo<T> getCola() {
        return cola;
    }

    public void setCola(Nodo<T> cola) {
        this.cola = cola;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    /**
     * Verifica si la cola está vacía
     * @return true si la cabeza está vacía
     */
    public boolean colaVacia() {
        return cabeza==null;
    }
    /**
     * Inserta un elemento al final de la cola
     * @param elemento Elemento a insertar
     */
    public void insertar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        
        if(colaVacia()) { //Caso 1. La cola está vacía
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else { //Caso 2. La cola NO está vacía
            //El nodo actual que era el 'final' ahora apunta al nuevo nodo
            this.cola.setSiguiente(nuevoNodo);
            //El puntero 'cola' (final) se mueve al nuevo nodo
            this.cola = nuevoNodo;
        }
        tamano ++; //Incrementar tamaño
        System.out.println("-> Insertado: " + elemento);
    }
    /**
     * Quita el primer elemento de la cola
     * @return El dato retirado
     */
    public T quitar() {
        if (colaVacia()) {
            System.out.println("Error: La cola está vacía");
        }
        
        T datoQuitado = this.cabeza.getDato(); //Guardamos el dato a devolver
        
        this.cabeza = this.cabeza.getSiguiente(); //Cabeza siguiente nodo
        
        if(this.cabeza == null) { //Actualiza no hay elementos
            this.cola = null;
        }
        tamano --;
        return datoQuitado;
    }
    /**
     * Operación: Frente(Peek)
     * @return El elemento del FRENTE sin retirarlo
     */
    public T frente() {
        if(colaVacia()) {
            System.out.println("Error: La cola está vacía");
        }
        return this.cabeza.getDato();
    }
    /**
     * Muestra todos los elementos de la cola
     * @param cola TAD Cola a recorrer
     */
    public void mostrarTodo(Cola<T> cola) {
        if(cola.colaVacia()) {
            System.out.println("ERROR: La cola está vacía");
        }
        
        Nodo<T> temp = cabeza;
        while(temp != null) {
            System.out.println("" + temp.getDato());
            temp = temp.getSiguiente();
        }
    }
}
