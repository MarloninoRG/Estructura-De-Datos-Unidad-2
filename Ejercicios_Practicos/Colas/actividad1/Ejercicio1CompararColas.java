package ejerciciosGuiadosColas.actividad1;

import ejerciciosGuiadosColas.modelo.Cola;
import ejerciciosGuiadosColas.modelo.Nodo;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

/**
 * Clase que verifica si dos TAD Cola son iguales
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Secuencia:
 * 1. Se crean los objetos cola1, cola2, Scanner y la variable palabra
 * 2. Se insertan los datos en cada una de las colas
 * 3. Se verifica si el contenido de las colas son iguales y se muestra en pantalla
 * 4. Se muestra el contenido de ambas colas
 * 
 */
public class Ejercicio1CompararColas {
    public static void main(String[] args) {
        //Crea los objetos necesarios
        Cola <String> cola1 = new Cola<>();
        Cola <String> cola2 = new Cola<>();
        Scanner teclado = new Scanner(System.in, StandardCharsets.UTF_8);
        String palabra = "";
        
        //Inserta los elementos de la cola 1
        while(!palabra.contentEquals("STOP")) {
            System.out.println("Inserte una palabra en la cola 1: ");
            palabra = teclado.nextLine();
            if(!palabra.contains("STOP")) cola1.insertar(palabra);
        }
        //Limpia la variable palabra
        palabra = "";
        
        //Inserta los elementos de la cola 2
        while(!palabra.contentEquals("STOP")) {
            System.out.println("Inserte una palabra en la cola 2: ");
            palabra = teclado.nextLine();
            if(!palabra.contains("STOP")) cola2.insertar(palabra);
        }
        
        //Verifica y muestra si las Colas son iguales
        System.out.println("¿Son iguales?: " + verificar(cola1, cola2));
        
        //Muestra el contenido de las colas
        System.out.println("Contenido de la cola 1: ");
        cola1.mostrarTodo(cola1);
        System.out.println("Contenido de la cola 2: ");
        cola2.mostrarTodo(cola2);
        
    }
    
    public static <T> boolean verificar(Cola cola1,Cola cola2) {
        // Si alguna cola es null, no se pueden comparar
        if (cola1 == null || cola2 == null) {
            return false;
        }

        // Si tienen diferente tamaño, no son iguales
        if (cola1.getTamano() != cola2.getTamano()) {
            return false;
        }

        // Recorremos nodo por nodo desde la cabeza de ambas colas
        Nodo<T> actual1 = cola1.getCabeza();
        Nodo<T> actual2 = cola2.getCabeza();

        while (actual1 != null && actual2 != null) {
            T dato1 = actual1.getDato();
            T dato2 = actual2.getDato();

            // Si alguno es null o no son iguales, retorna false
            if ((dato1 == null && dato2 != null) ||
                (dato1 != null && !dato1.equals(dato2))) {
                return false;
        }

        actual1 = actual1.getSiguiente();
        actual2 = actual2.getSiguiente();
    }

    // Si se recorrieron ambas completamente sin diferencias
    return true;
    }
}
