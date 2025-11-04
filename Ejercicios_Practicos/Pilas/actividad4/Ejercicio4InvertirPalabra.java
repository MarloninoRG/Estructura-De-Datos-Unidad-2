package ejerciciosGuiadosPilas.actividad4;

import ejerciciosGuiadosPilas.modelo.Stack;
import java.util.Scanner;

/**
 * Clase que ivierte una palabra mediante el uso de un Stack
 * @author Marlon Rojas Galindo
 * @contact marlonrojasservices@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Secuencia:
 * 1. Se crea el objeto Scanner para leer el teclado
 * 2. Se inserta la palabra
 * 3. Se crea el Stack con datos de tipo Character
 * 4. Mediante un ciclo for-each se convierte la palabra en un arreglo
 * de chars y cada char se agrega al Stack.
 * 5. Se muestra la palabra invertida mediante un ciclo while, mostrando
 * desde el ultimo hasta el primer elemento
 * 
 */
public class Ejercicio4InvertirPalabra {
    public static void main(String[] args) {
        //Objeto para leer el teclado
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese una palabra: ");
        //Lee la palabra
        String palabra = teclado.nextLine();
        //Crea el Stack
        Stack<Character> pila = new Stack<>();
        //Inserta cada letra en el Stack
        for (char c : palabra.toCharArray()) pila.push(c);
        //Muestra la palabra invertida
        System.out.println("Invertida: ");
        while (!pila.isEmpty()) System.out.print(pila.pop());
    }
}
