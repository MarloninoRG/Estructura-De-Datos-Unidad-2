package ejerciciosGuiadosColas.actividad3;

import java.util.Random;
import ejerciciosGuiadosColas.modelo.Cola;

/**
 * Clase que simula el sistema de atención al cliente del Super Esperanza
 * Gestiona una fila única de clientes y hasta 4 cajas de atención durante 7 horas
 * Implementa apertura dinámica de la cuarta caja según demanda
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Secuencia:
 * 1. Se inicializan las estructuras de datos (fila de clientes y 4 cajas)
 * 2. Se simulan 7 horas (420 minutos) de operación minuto a minuto
 * 3. Llega un cliente nuevo cada minuto y se agrega a la fila
 * 4. Se verifica si hay más de 20 clientes en fila para abrir la cuarta caja
 * 5. Se asignan clientes de la fila a cajas disponibles
 * 6. Se genera un tiempo de atención aleatorio entre 2 y 6 minutos por cliente
 * 7. Se avanza el tiempo en todas las cajas activas
 * 8. Se recopilan estadísticas durante toda la simulación
 * 9. Se muestran los resultados finales al terminar la jornada
 * 
 */
public class Ejercicio3SuperEsperanza {
    public static void main(String[] args) {
        //Define las constantes del sistema
        final int DURACION = 7 * 60; // 7 horas convertidas a minutos
        final int TIEMPO_MIN_ATENCION = 2;
        final int TIEMPO_MAX_ATENCION = 6;
        
        //Crea la fila única de clientes y el arreglo de cajas
        Cola<Cliente> fila = new Cola<>();
        Caja[] cajas = new Caja[4];
        for (int i = 0; i < 4; i++) cajas[i] = new Caja(i + 1);
        
        //Crea el generador de números aleatorios
        Random random = new Random();
        
        //Inicializa las variables para recopilar estadísticas
        int totalClientes = 0;
        int atendidos = 0;
        int maxTamañoFila = 0;
        int sumaTamañoFila = 0;
        int tiempoMaxEspera = 0;
        int minutoApertura4taCaja = -1;
        
        //Simulación minuto a minuto durante toda la jornada
        for (int minuto = 0; minuto < DURACION; minuto++) {
            //Llega un nuevo cliente cada minuto
            totalClientes++;
            Cliente nuevo = new Cliente(totalClientes, minuto);
            fila.insertar(nuevo);
            
            //Verifica si se debe abrir la cuarta caja (más de 20 clientes esperando)
            if (fila.getTamano() > 20 && minutoApertura4taCaja == -1) {
                minutoApertura4taCaja = minuto;
                System.out.println("🟩 Se abre la cuarta caja en el minuto " + minuto);
            }
            
            //Intenta asignar clientes en espera a las cajas disponibles
            for (int i = 0; i < cajas.length; i++) {
                Caja caja = cajas[i];
                //Verifica que la caja esté libre, haya clientes esperando, y esté operativa
                if (caja.estaLibre() && !fila.colaVacia() && (i < 3 || minutoApertura4taCaja != -1)) {
                    //Quita el siguiente cliente de la fila
                    Cliente siguiente = fila.quitar();
                    
                    //Genera un tiempo de atención aleatorio
                    int tiempoAtencion = random.nextInt(TIEMPO_MAX_ATENCION - TIEMPO_MIN_ATENCION + 1) + TIEMPO_MIN_ATENCION;
                    
                    //Registra los tiempos del cliente
                    siguiente.setTiempoInicioAtencion(minuto);
                    siguiente.setTiempoSalida(minuto + tiempoAtencion);
                    
                    //Asigna el cliente a la caja
                    caja.asignarCliente(siguiente, tiempoAtencion);
                    atendidos++;
                    
                    //Actualiza el tiempo máximo de espera si es necesario
                    int espera = siguiente.getTiempoEspera();
                    if (espera > tiempoMaxEspera) tiempoMaxEspera = espera;
                }
            }
            
            //Avanza un minuto en todas las cajas
            for (Caja caja : cajas) {
                caja.avanzarTiempo();
            }
            
            //Recopila estadísticas del tamaño de la fila
            sumaTamañoFila += fila.getTamano();
            if (fila.getTamano() > maxTamañoFila) {
                maxTamañoFila = fila.getTamano();
            }
        }
        
        //Calcula el tamaño promedio de la fila durante toda la simulación
        double tamañoMedioFila = (double) sumaTamañoFila / DURACION;
        
        //Muestra las estadísticas finales de la simulación
        System.out.println("\n===== RESULTADOS DE LA SIMULACIÓN =====");
        System.out.println("🧍 Total de clientes llegados: " + totalClientes);
        System.out.println("✅ Total de clientes atendidos: " + atendidos);
        System.out.println("📏 Tamaño máximo de la fila: " + maxTamañoFila);
        System.out.println("📊 Tamaño medio de la fila: " + String.format("%.2f", tamañoMedioFila));
        System.out.println("⏱️ Tiempo máximo de espera: " + tiempoMaxEspera + " min");
        
        //Informa sobre el estado de la cuarta caja
        if (minutoApertura4taCaja != -1)
            System.out.println("🟢 Cuarta caja abierta en el minuto: " + minutoApertura4taCaja);
        else
            System.out.println("⚪ No fue necesario abrir la cuarta caja");
    }
}

