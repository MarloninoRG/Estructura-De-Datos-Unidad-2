package ejerciciosGuiadosColas.actividad3;

/**
 * Clase que simula una caja de atención al cliente en un sistema de servicios
 * Gestiona la asignación de clientes, el tiempo de atención y la disponibilidad
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Características:
 * - Cada caja tiene un identificador único
 * - Puede atender a un cliente a la vez
 * - Controla el tiempo restante de atención del cliente actual
 * - Se libera automáticamente cuando termina de atender
 * - Permite verificar su disponibilidad en tiempo real
 */
public class Caja {
    //Atributos de la clase
    private int id;
    private Cliente clienteActual;
    private int tiempoRestante; // minutos que faltan para terminar con el cliente
    
    /**
     * Constructor de la clase Caja
     * Crea una caja inicialmente libre y sin tiempo de atención
     * @param id Identificador único de la caja
     */
    public Caja(int id) {
        this.id = id;
        this.clienteActual = null;
        this.tiempoRestante = 0;
    }
    
    /**
     * Verifica si la caja está libre para atender
     * @return true si no hay cliente siendo atendido, false en caso contrario
     */
    public boolean estaLibre() {
        return clienteActual == null;
    }
    
    /**
     * Asigna un cliente a la caja para ser atendido
     * Establece el cliente actual y el tiempo necesario para su atención
     * @param cliente El cliente que será atendido
     * @param tiempoAtencion Tiempo en minutos que tomará atender al cliente
     */
    public void asignarCliente(Cliente cliente, int tiempoAtencion) {
        this.clienteActual = cliente;
        this.tiempoRestante = tiempoAtencion;
    }
    
    /**
     * Avanza el tiempo de atención en un minuto
     * Decrementa el tiempo restante y libera la caja cuando llega a cero
     * Este método simula el paso del tiempo en la atención del cliente
     */
    public void avanzarTiempo() {
        if (tiempoRestante > 0) {
            tiempoRestante--;
            //Si el tiempo llega a cero, libera la caja
            if (tiempoRestante == 0) {
                clienteActual = null;
            }
        }
    }
    
    /**
     * Obtiene el cliente que está siendo atendido actualmente
     * @return El cliente actual, o null si la caja está libre
     */
    public Cliente getClienteActual() {
        return clienteActual;
    }
    
    /**
     * Obtiene el identificador de la caja
     * @return El ID de la caja
     */
    public int getId() {
        return id;
    }
    
    /**
     * Obtiene el tiempo restante de atención del cliente actual
     * @return Los minutos restantes para terminar con el cliente, o 0 si está libre
     */
    public int getTiempoRestante() {
        return tiempoRestante;
    }
}

