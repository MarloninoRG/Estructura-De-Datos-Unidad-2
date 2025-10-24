package colas;

/**
 * Prueba de un TAD Cola, implementado en java
 * @author Marlon Rojas Galindo
 * @contact marlonrojasservices@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Main {
    public static void main(String[] args) {
        //Inicializar objetos
        Cola<String> cola = new Cola();
        
        //Agregar tareas
        cola.insertar("Preparar café");
        cola.insertar("Revisar emails");
        cola.insertar("Iniciar proyecto");
        
        //Solicitar el tamaño
        System.out.println("El tamaño de la cola es: " + cola.getTamano());
        
        //Consultar frente
        System.out.println("El frente es: " + cola.frente());
        
        //Quitar tarea 1 y desplegar la tarea ejecutada
        System.out.println("Elemento eliminado: " + cola.quitar());
        
        //Quitar tarea 2 y desplegar la tarea ejecutada
        System.out.println("Elemento eliminado: " + cola.quitar());
        
        //Mostrar el estado final de la cola
        cola.mostrarTodo(cola);
    }
}
