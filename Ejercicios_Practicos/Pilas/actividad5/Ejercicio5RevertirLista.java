package ejerciciosGuiadosPilas.actividad5;

import ejerciciosGuiadosPilas.modelo.Stack;

/**
 * Clase que implementa un Array y muestra sus elementos de manera inversa mediante un Stack
 * @author Marlon Rojas Galindo
 * @contact marlonrojasservices@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Secuencia:
 * 1. Se inicializa un Array de enteros
 * 2. Se crea el Stack
 * 3. Mediante un for-each, por cada entero en el Array se agrega al Stack
 * 4. Se muestra el Stack
 */
public class Ejercicio5RevertirLista {
    public static void main(String[] args) {
        //Inicializa el Array
        int [] numeros = {1,2,3,4,5};
        //Crea el Stack
        Stack <Integer> pila = new Stack<>();
        //Inserta los elementos en el Stack
        for (int n: numeros) pila.push(n);
        //Muestra el Array invertido
        System.out.print("Lista invertida: ");
        while(!pila.isEmpty()) System.out.print(pila.pop() + "");
    }
}
