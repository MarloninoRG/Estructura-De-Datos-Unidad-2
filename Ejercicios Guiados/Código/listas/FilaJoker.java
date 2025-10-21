package listas;

/**
 *Administra un fila de personas en el cine
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * @param <T> Es un dato "Type" de tipo Generico
 */
public class FilaJoker<T> {
    //Atributos
    private Nodo<T> cabeza;
    
    //Constructor
    public FilaJoker() {
    }

    public FilaJoker(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }
    
    //Metodos
    /**
     * Recorre la lista muestra cada uno de los datos
     */
    public void recorrer() {
        Nodo<T> temp = cabeza;
        
        while(temp.getIzquierda() != null){
            System.out.println(temp.getDato());
            temp = temp.getIzquierda();
        }
    }
    /**
     * Cuenta cuantos elementos hay en la lista
     * @return numero de elementos
     */
    public int inspeccionar() {
        Nodo<T> temp = cabeza;
        int cont = 0;
        
        while(temp.getIzquierda() != null){
            cont ++;
            temp = temp.getIzquierda();
        }
        
        return cont;
    }
    /**
     * Inserta un elemento en la lista
     * @param n valor a insertar
     */
    public void insertar(Nodo n) {
        Nodo<T> temp = cabeza;
        while(temp.getIzquierda() != null) {
            temp = temp.getIzquierda();
        }
        n = temp.getIzquierda();
    }
    /**
     * Inserta un elemento dentro de una lista doblemente enlazada
     * @param n valor a insertar
     */
    public void insertar2(Nodo n) {
        Nodo<T> temp = cabeza;
        while(temp.getIzquierda() != null) {
            temp = temp.getIzquierda();
        }
        n = temp.getIzquierda();
        temp.setDerecha(temp);
    }
    /**
     * Imprime el contenido de la lista
     */
    public void imprimir() {
        Nodo<T> temp = cabeza;
        while (temp.getIzquierda() != null) {
            System.out.println(temp.getDato());
            temp = temp.getIzquierda();
        }
        System.out.println(temp.getDato());
    }
}
