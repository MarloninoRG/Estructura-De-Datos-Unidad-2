package ejerciciosGuiadosColas.modelo;

/**
 * Clase que representa un Nodo genérico para estructuras de datos enlazadas
 * Implementa un nodo con capacidad de almacenar cualquier tipo de dato
 * Utiliza genéricos para proporcionar flexibilidad y seguridad de tipos
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * @param <T> Tipo genérico del dato que almacenará el nodo
 */
public class Nodo<T> {
    //Atributos de la clase
    private T dato;
    private Nodo siguiente;
    
    /**
     * Constructor de la clase Nodo
     * Crea un nodo con un dato específico y sin enlace al siguiente nodo
     * @param data El dato de tipo genérico que almacenará el nodo
     */
    public Nodo(T data) {
        dato = data;
        siguiente = null;
    }
    
    /**
     * Obtiene el dato almacenado en el nodo
     * @return El dato de tipo genérico almacenado
     */
    public T getDato() {
        return dato;
    }
    
    /**
     * Establece el dato del nodo
     * @param dato El nuevo dato a almacenar en el nodo
     */
    public void setDato(T dato) {
        this.dato = dato;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo en la estructura
     * @return El nodo siguiente, o null si es el último nodo
     */
    public Nodo getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece la referencia al siguiente nodo
     * @param siguiente El nodo que seguirá a este en la estructura enlazada
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Genera una representación en texto del nodo
     * Incluye el dato almacenado y la referencia al siguiente nodo
     * Útil para depuración y visualización de la estructura de datos
     * @return String con formato "Nodo{dato=[valor], siguiente=[referencia]}"
     */
    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }
}
