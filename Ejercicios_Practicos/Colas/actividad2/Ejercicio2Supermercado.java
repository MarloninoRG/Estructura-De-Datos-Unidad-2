package ejerciciosGuiadosColas.actividad2;

import ejerciciosGuiadosColas.modelo.Cola;
import java.util.Random;

/**
 * Clase que simula el sistema de gestión de un supermercado
 * Administra carritos, clientes y cajas de pago utilizando estructuras de Cola
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Secuencia:
 * 1. Se inicializan las colas de carritos disponibles y las tres cajas de pago
 * 2. Se crean 25 carritos y se insertan en la cola de carritos disponibles
 * 3. Se simula la llegada de 40 clientes con tiempos aleatorios de compra y pago
 * 4. Cada cliente toma un carrito si está disponible, caso contrario espera
 * 5. Los clientes se forman en la caja con menos personas
 * 6. Se simula aleatoriamente que clientes terminan de pagar y liberan carritos
 * 7. Se muestra un resumen final con el estado de carritos y cajas
 * 
 */
public class Ejercicio2Supermercado {
    public static void main(String[] args) {
        //Crea las colas necesarias para el sistema
        Cola<Carrito> carritos = new Cola<>();
        Cola<Cliente> caja1 = new Cola<>();
        Cola<Cliente> caja2 = new Cola<>();
        Cola<Cliente> caja3 = new Cola<>();
        
        //Crear los 25 carritos disponibles e insertarlos en la cola
        for (int i = 1; i <= 25; i++) {
            carritos.insertar(new Carrito(i));
        }
        
        //Crea el generador de números aleatorios
        Random random = new Random();
        
        //Simula la llegada de 40 clientes al supermercado
        for (int i = 1; i <= 40; i++) {
            //Crea un nuevo cliente con tiempos aleatorios
            Cliente cliente = new Cliente(
                    i,
                    random.nextInt(5) + 3,   // tiempoCompra entre 3 y 7 unidades
                    random.nextInt(4) + 2    // tiempoPago entre 2 y 5 unidades
            );
            System.out.println("\n🛒 Llega " + cliente);
            
            //Verifica si hay carritos disponibles
            if (!carritos.colaVacia()) {
                //Asigna un carrito al cliente
                Carrito carrito = carritos.quitar();
                cliente.setCarrito(carrito);
                cliente.setEstado("comprando");
                System.out.println("➡️ " + cliente + " toma el " + carrito);
                
                //Selecciona la caja con menos clientes en espera
                Cola<Cliente> cajaMenosLlena = caja1;
                if (caja2.getTamano() < cajaMenosLlena.getTamano()) cajaMenosLlena = caja2;
                if (caja3.getTamano() < cajaMenosLlena.getTamano()) cajaMenosLlena = caja3;
                
                //Inserta el cliente en la caja seleccionada
                cajaMenosLlena.insertar(cliente);
                System.out.println("📦 " + cliente + " se forma en la caja con menos clientes.");
            } else {
                //Si no hay carritos disponibles, el cliente debe esperar
                cliente.setEstado("esperando_carrito");
                System.out.println("⏳ No hay carritos, " + cliente + " espera...");
            }
            
            //Simula aleatoriamente que un cliente termine de pagar (25% de probabilidad)
            if (random.nextInt(4) == 0) {
                //Selecciona aleatoriamente una de las tres cajas
                Cola<Cliente>[] cajas = new Cola[]{caja1, caja2, caja3};
                Cola<Cliente> cajaAleatoria = cajas[random.nextInt(3)];
                
                //Si la caja tiene clientes, atiende al primero
                if (!cajaAleatoria.colaVacia()) {
                    Cliente atendido = cajaAleatoria.quitar();
                    atendido.setEstado("pagando");
                    System.out.println("💰 " + atendido + " termina de pagar y deja el carrito.");
                    
                    //Libera el carrito del cliente atendido
                    Carrito carritoLibre = atendido.getCarrito();
                    atendido.setCarrito(null);
                    atendido.setEstado("salio");
                    
                    //Devuelve el carrito a la cola de carritos disponibles
                    carritos.insertar(carritoLibre);
                    System.out.println("✅ Carrito #" + carritoLibre.getId() + " vuelve a estar disponible.");
                }
            }
        }
        
        //Muestra el resumen final del estado del sistema
        System.out.println("\n===== RESUMEN FINAL =====");
        System.out.println("Carritos disponibles: " + carritos.getTamano());
        System.out.println("Clientes en caja 1: " + caja1.getTamano());
        System.out.println("Clientes en caja 2: " + caja2.getTamano());
        System.out.println("Clientes en caja 3: " + caja3.getTamano());
    }
}
