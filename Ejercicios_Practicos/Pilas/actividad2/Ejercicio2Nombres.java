package ejerciciosGuiadosPilas.actividad2;

import ejerciciosGuiadosPilas.modelo.Stack;
import java.util.Scanner;

/**
 * Clase que implementa una pila y realiza operaciones de inserción e inversión de los elementos
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Secuencia:
 * 1. Se crean los objetos Scanner para leer los datos de entrada y Stack para almacenar los datos
 * 2. Se declara una variable para almacenar nombres
 * 3. Mediante un ciclo while se insertan las palabras hasta insertar la palabra "FIN"
 * 4. Se muestran los nombres de manera inversa con un ciclo while
 * 
 */
public class Ejercicio2Nombres {
    public static void main(String[] args) {
        //Inicia los objetos
        Scanner teclado = new Scanner(System.in);
        Stack<String> pila = new Stack<>();
        //Declara la variable nombre
        String nombre;
        //Inserta los datos
        while(true) {
            System.out.println("Ingrese un nombre (FIN para salir):");
            nombre = teclado.nextLine();
            if (nombre.equalsIgnoreCase("FIN")) break;
            pila.push(nombre);
        }
        //Muestra los datos de manera inversa
        System.out.println("Nombres en orden inverso:");
        while(!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}
