package colas;

/**
 * Clase que construye un Nodo con tipos de datos genéricos
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Nodo<T> {
    //Atributos
    private T dato;
    private Nodo siguiente;
    
    //Constructor
    public Nodo(T data) {
        dato = data;
        siguiente = null;
    }
    
    //Metodos getters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    //Metodo toString para imprimir los datos del nodo
    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }
}
