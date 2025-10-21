package pilas;

/**
 *Clase con método main que realiza todas las operaciones de una pila y muestra los resultados en la terminal
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class MainStack {

    /**
     * Método main que inicializa una pila y realiza operaciones push, pop, peek y showStack
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StackArray <String> names = new StackArray<>(); //Inicializa una pila con 30 espacios 
        
        //Agrega 3 elementos a la pila
        names.push("Marlon");
        names.push("Cristian");
        names.push("Boneca");
        names.push("Gaelinho");
        
        //Muestra los datos agregados
        names.showStack();
        
        //Elimina el ultimo elemento y lo muestra
        System.out.println("Elemento eliminado: " + names.pop());
        
        names.showStack();
        
        System.out.println("Elemento eliminado: " + names.pop());
        
        //Muestra el elemento en la cima
        System.out.println("El elemento de la cima es: " + names.peek());
        
        names.push("Queli");
        
        names.showStack();
        
        names.push("Nicol");
        
        names.showStack();
        
        names.push("Hazel");
        
        names.showStack();
        
        System.out.println("El elemento de la cima es: " + names.peek());
        
        System.out.println("Elemento eliminado: " + names.pop());
        System.out.println("Elemento eliminado: " + names.pop());
        
        names.showStack();
    }
}
