package ejerciciosGuiadosPilas.actividad1;

import ejerciciosGuiadosPilas.modelo.Stack;

/**
 * Clase que ejecuta operaciones de una Pila
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Secuencia:
 * 1. Se crea una pila de enteros
 * 2. Se agregan valores a la pila
 * 3. Se eliminan elementos de la pila
 * 4. Se muestran los elementos que quedan el la pila
 * 
 */
public class Ejercicio1PilaSimple {
    public static void main(String[] args) {
        //Crea la pila
        Stack<Integer> pila = new Stack<>();
        //Agregar elementos
        pila.push(5);
        pila.push(10);
        pila.push(15);
        pila.push(20);
        //Elimina elementos
        pila.pop();
        pila.pop();
        //Muestra la pila
        System.out.println("Contenido actual: " + pila);
    }
}
