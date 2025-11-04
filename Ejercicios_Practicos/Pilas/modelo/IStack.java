package ejerciciosGuiadosPilas.modelo;

/**
 *Interfaz con metodos para realizar operaciones de una pila
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public interface IStack<E> {
    /**
     *Metodo abstracto para agregar elementos de tipo genérico
     * @param element elemento a agregar
     */
    void push(E element);
    
    /**
     * Método abstracto para eliminar el ultimo elemento 
     * @return valor de tipo genérico
     */
    E pop();
    
    /**
     * Método abstracto para mostrar el valor en la cima de la pila
     * @return valor de tipo genérico
     */
    E peek();
    
    /**
     * Método abstracto para mostrar si la pila está vacia
     * @return valor true si está vacia, false si tiene un valor
     */
    boolean isEmpty();
}
