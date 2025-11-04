package ejerciciosGuiadosPilas.actividad3;

import ejerciciosGuiadosPilas.modelo.Stack;

/**
 * Clase que implementa un Stack y verifica si está vacía
 * @author Marlon Rojas Galindo
 * @contact marlonrojasservices@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Secuencia:
 * 1. Se crea la pila de enteros
 * 2. Se verifica si la pila está vacía
 * 3. Se inserta un elemento a la pila
 * 4. Se verifica si la pila está vacía
 * 
 */
public class Ejercicio3VerificarPila {
    public static void main(String[] args) {
        //Crea la pila
        Stack <Integer> pila = new Stack<>();
        //Verifica si está vacía
        System.out.println("¿Está vacía la pila?" + pila.isEmpty());
        //Inserta un elemento
        pila.push(1);
        //Verifica si está vacía
        System.out.println("¿Está vacía la pila?" + pila.isEmpty());
    }
}
