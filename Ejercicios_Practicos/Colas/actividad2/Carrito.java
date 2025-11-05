package ejerciciosGuiadosColas.actividad2;

/**
 * Clase que simula el objeto Carrito para un sistema de gestión
 * Representa un carrito que puede estar ocupado o disponible
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Características:
 * - Cada carrito tiene un identificador único
 * - Mantiene un estado de ocupación (ocupado/disponible)
 * - Proporciona representación textual del estado del carrito
 */
public class Carrito {
    //Atributos de la clase
    private int id;
    private boolean ocupado;
    
    /**
     * Constructor por defecto
     * Crea un carrito sin inicializar sus atributos
     */
    public Carrito() {
    }
    
    /**
     * Constructor con parámetros completos
     * @param id Identificador único del carrito
     * @param ocupado Estado de ocupación del carrito (true = ocupado, false = disponible)
     */
    public Carrito(int id, boolean ocupado) {
        this.id = id;
        this.ocupado = ocupado;
    }
    
    /**
     * Constructor con identificador
     * Crea un carrito con ID específico, inicialmente no ocupado
     * @param id Identificador único del carrito
     */
    public Carrito(int id) {
        this.id = id;
    }
    
    /**
     * Obtiene el identificador del carrito
     * @return El ID del carrito
     */
    public int getId() {
        return id;
    }
    
    /**
     * Establece el identificador del carrito
     * @param id El nuevo ID del carrito
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Verifica si el carrito está ocupado
     * @return true si el carrito está ocupado, false si está disponible
     */
    public boolean isOcupado() {
        return ocupado;
    }
    
    /**
     * Establece el estado de ocupación del carrito
     * @param ocupado El nuevo estado (true = ocupado, false = disponible)
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    /**
     * Genera una representación en texto del carrito
     * Incluye el ID y el estado de ocupación
     * @return String con formato "Carrito #[id] (ocupado/disponible)"
     */
    @Override
    public String toString() {
        return "Carrito #" + id + (ocupado ? "(ocupado)" : "(disponible)");
    }
}
