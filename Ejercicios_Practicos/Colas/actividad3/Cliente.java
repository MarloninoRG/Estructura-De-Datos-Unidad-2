package ejerciciosGuiadosColas.actividad3;

/**
 * Clase que simula un Cliente en un sistema de atención
 * Registra los tiempos de llegada, inicio de atención y salida del cliente
 * Permite calcular métricas como el tiempo de espera
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Características:
 * - Cada cliente tiene un identificador único
 * - Registra el minuto exacto de llegada al sistema
 * - Registra el minuto en que comienza a ser atendido
 * - Registra el minuto en que termina su atención y sale
 * - Calcula automáticamente el tiempo de espera en cola
 * - Proporciona representación textual con información de llegada
 */
public class Cliente {
    //Atributos de la clase
    private int id;
    private int tiempoLlegada;        // minuto en que llegó
    private int tiempoInicioAtencion; // minuto en que fue atendido
    private int tiempoSalida;         // minuto en que terminó su atención
    
    /**
     * Constructor de la clase Cliente
     * Crea un cliente con su identificador y tiempo de llegada
     * @param id Identificador único del cliente
     * @param tiempoLlegada Minuto en que el cliente llegó al sistema
     */
    public Cliente(int id, int tiempoLlegada) {
        this.id = id;
        this.tiempoLlegada = tiempoLlegada;
    }
    
    /**
     * Obtiene el identificador del cliente
     * @return El ID del cliente
     */
    public int getId() {
        return id;
    }
    
    /**
     * Obtiene el tiempo de llegada del cliente
     * @return El minuto en que el cliente llegó al sistema
     */
    public int getTiempoLlegada() {
        return tiempoLlegada;
    }
    
    /**
     * Establece el tiempo en que el cliente comenzó a ser atendido
     * @param tiempoInicioAtencion El minuto en que inició la atención
     */
    public void setTiempoInicioAtencion(int tiempoInicioAtencion) {
        this.tiempoInicioAtencion = tiempoInicioAtencion;
    }
    
    /**
     * Obtiene el tiempo en que el cliente comenzó a ser atendido
     * @return El minuto en que inició la atención
     */
    public int getTiempoInicioAtencion() {
        return tiempoInicioAtencion;
    }
    
    /**
     * Establece el tiempo en que el cliente terminó su atención
     * @param tiempoSalida El minuto en que el cliente salió del sistema
     */
    public void setTiempoSalida(int tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }
    
    /**
     * Obtiene el tiempo en que el cliente terminó su atención
     * @return El minuto en que el cliente salió del sistema
     */
    public int getTiempoSalida() {
        return tiempoSalida;
    }
    
    /**
     * Calcula el tiempo que el cliente esperó en cola antes de ser atendido
     * @return La diferencia en minutos entre el inicio de atención y la llegada
     */
    public int getTiempoEspera() {
        return tiempoInicioAtencion - tiempoLlegada;
    }
    
    /**
     * Genera una representación en texto del cliente
     * Incluye el ID del cliente y el minuto en que llegó al sistema
     * @return String con formato "Cliente #[id] (Llegó en min [tiempoLlegada])"
     */
    @Override
    public String toString() {
        return "Cliente #" + id + " (Llegó en min " + tiempoLlegada + ")";
    }
}