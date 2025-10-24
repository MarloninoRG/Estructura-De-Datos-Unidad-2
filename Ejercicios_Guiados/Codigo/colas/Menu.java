package colas;

import java.util.Scanner;

/**
 * Implementación de menú de las operaciones de un TAD cola
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Menu {
    
    public static void main(String[] args) {
        //Inicialización de objetos
        Cola<String> tareas = new Cola();
        Scanner teclado = new Scanner(System.in);
        int op = 0;
        
        while(op!=6){
        //Menu de operaciones
        op = menu(teclado);
        //Operaciones a realizar
        operacion(op, teclado, tareas);
        }
        
    }
    /**
     * Realiza las operaciones de un TAD Cola segun la opcion seleccionada
     * @param op Opción seleccionada por el usuario
     * @param teclado Scanner auxiliar
     * @param tareas Lista a modificar
     */
    private static void operacion(int op, Scanner teclado, Cola<String> tareas) {
        switch(op) {
            case 1 -> {
                teclado.nextLine(); //Se limpia el salto de linea
                System.out.println("Inserte un elemento: ");
                String elemento = teclado.nextLine();
                tareas.insertar(elemento); //Operacion de insercion
            }
            case 2 -> {
                System.out.println("El tamaño de la cola es: " + tareas.getTamano()); //Obtener tamaño
            }
            case 3 -> {
                System.out.println("El elemento del frente es: " + tareas.frente()); //Obtener el frente de la cola
            }
            case 4 -> {
                System.out.println("Se ha eliminado: " + tareas.quitar()); //Quitar el elemento del frente
            }
            case 5 -> {
                System.out.println("Los elementos en la cola son: "); //Muestra toda la lista
                tareas.mostrarTodo(tareas);
            }
            case 6 -> {
                System.out.println("HASTA PRONTO..."); //Mensaje de despedida
            }
            default -> {
                while(op>6 && op<1) {
                System.out.println("Opcion invalida");
                op = teclado.nextInt();
                }
            }
        }      
    }
    /**
     * Muestra un menú interactivo donde se puede seleccionar una operación de TAD Cola
     * @param Teclado Scanner para leer la opcion
     * @return La opcion seleccionada
     */
    private static int menu(Scanner teclado) {
        //Menú de operaciónes
        System.out.println("============================");
        System.out.println("BIENVENIDO");
        System.out.println("============================");
        System.out.println("Operaciones");
        System.out.println("[1]Agregar tarea");
        System.out.println("[2]Solicitar el tamaño");
        System.out.println("[3]Consultar frente");
        System.out.println("[4]Quitar tarea");
        System.out.println("[5]Mostrar todo");
        System.out.println("[6]Salir");
        
        return teclado.nextInt();
    }
}
