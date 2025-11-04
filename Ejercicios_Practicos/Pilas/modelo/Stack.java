package ejerciciosGuiadosPilas.modelo;

/**
 * Clase que sobreescribe los métodos de la interfaz IStack para realizar operaciones pop, push, peek y showStack
 * implementa la interfaz IStack y utiliza parametrización de datos genéricos
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Stack<E> implements IStack<E> {
    //Atributos
     
    private E[] elements; //Estructura de datos interna (Array)
    private int top; //indice de la cima

    //Constructores
    
    /**
     * Construye un StackArray con tamaño de 30 elementos
     */
    public Stack() {
        elements = (E[]) new Object[30];
        top = -1; //Inicializa la cima en -1
    }
    /**
     * Construye un StackArray especificando el tamaño
     * @param size el tamaño de la pila
     */
    public Stack(int size) {
        elements = (E[]) new Object[size];
        top = -1;
    }
    /**
     * Construye un StackArray con un arreglo de elementos de tipo genérico y especificando la cima
     * @param elements tipo de datos en la pila
     * @param top cima de la pila
     */
    public Stack(E[] elements, int top) {
        this.elements = elements;
        this.top = top;
    }
    
    //Metodos de la interfaz IStack

    /**
     * Inserta un elemento en la cima de la pila
     * @param element valor a agregar
     */
    @Override
    public void push(E element) {
        if(top < elements.length - 1) { //Verifica si la insercion no afecta la capacidad de la pila
            elements[++top] = element; //Inserta el elemento en la cima y la posicion de la cima aumenta
        } else {
            System.err.println("Stack Overflow");
        }
    }
    /**
     * Elimina el ultimo elemento agregado en la pila
     * @return el valor elimnado de la pila
     */
    @Override
    public E pop() {
        if(isEmpty()){ //Verifica si la pila esta vacía
            System.out.println("Stack Underflow");
            return null;
        } else {
            E value = elements[top]; //Inicializa un dato con el valor de la cima
            elements[top] = null; //Limpia el valor de la cima 
            top --; //Reduce el tamaño de la pila
            return value; //Retorno del valor eliminado
        }
    }
    /**
     * Recupera el ultimo valor agregado
     * @return el utlimo valor agregado
     */
    @Override
    public E peek() {
        if(isEmpty()) { //Verifica si la pila esta vacia
            System.out.println("Stack Empty");
            return null;
        } else {
            System.out.println("Knowing the last one of stack");
            return elements[top]; //Retorna el valor en la cima de la pila
        }
    }
    /**
     * Verifica si la pila está vacia
     * @return true si top = -1, false si top > -1
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
    
    //Metodos adicionales
    
    /**
     * Muestra todos los valores de la pila, exeptuando los valores nulos
     */
    public void showStack() {
        for(E e: elements){
            if(e != null){
                System.out.println(e);
            }
        }
    }
    /**
     * Metodo que imprime el contenido de la pila
     * @return El contenido de la pila
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(elements[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
