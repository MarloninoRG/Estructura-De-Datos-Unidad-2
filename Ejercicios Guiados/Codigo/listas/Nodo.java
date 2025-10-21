package listas;

/**
 * Clase que permite crear un nodo para una lista simple
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Nodo<T> {
    //Datos
    private T dato;
    private Nodo izquierda;
    private Nodo derecha;

    //Constructores
    public Nodo() {
    }

    public Nodo(T dato) {
        this.dato = dato;
    }

    public Nodo(T dato, Nodo izquierda, Nodo derecha) {
        this.dato = dato;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }
    
    //Metodos getters y setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }
    
    public Nodo getDerecha() {
        return derecha;
    }
    
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }
}
