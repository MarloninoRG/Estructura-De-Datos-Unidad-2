package ejerciciosGuiadosColas.actividad2;

/**
 * Clase que simula el objeto Cliente para un sistema de gestión de supermercado
 * Representa un cliente que realiza compras, utiliza un carrito y pasa por diferentes estados
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 * 
 * Características:
 * - Cada cliente tiene un identificador único
 * - Puede tener asignado un carrito de compras
 * - Registra tiempos de compra y pago
 * - Mantiene un estado que indica su situación actual en el proceso de compra
 * - Estados posibles: esperando_carrito, comprando, esperando_caja, pagando, finalizado
 */
public class Cliente {
    //Atributos de la clase
    private int id;
    private Carrito carrito;
    private int tiempoCompra;
    private int tiempoPago;
    private String estado;
    
    /**
     * Constructor con parámetros completos
     * Crea un cliente con todos sus atributos inicializados
     * @param id Identificador único del cliente
     * @param carrito Objeto Carrito asignado al cliente
     * @param tiempoCompra Tiempo estimado que tomará realizar la compra (en unidades de tiempo)
     * @param tiempoPago Tiempo estimado que tomará realizar el pago (en unidades de tiempo)
     * @param estado Estado actual del cliente en el proceso de compra
     */
    public Cliente(int id, Carrito carrito, int tiempoCompra, int tiempoPago, String estado) {
        this.id = id;
        this.carrito = carrito;
        this.tiempoCompra = tiempoCompra;
        this.tiempoPago = tiempoPago;
        this.estado = estado;
    }
    
    /**
     * Constructor con identificador único
     * Crea un cliente con solo su ID, sin inicializar otros atributos
     * @param id Identificador único del cliente
     */
    public Cliente(int id) {
        this.id = id;
    }
    
    /**
     * Constructor con tiempos definidos
     * Crea un cliente con ID y tiempos de compra y pago
     * El cliente inicia en estado "esperando_carrito"
     * @param id Identificador único del cliente
     * @param tiempoCompra Tiempo estimado que tomará realizar la compra
     * @param tiempoPago Tiempo estimado que tomará realizar el pago
     */
    public Cliente(int id, int tiempoCompra, int tiempoPago) {
        this.id = id;
        this.tiempoCompra = tiempoCompra;
        this.tiempoPago = tiempoPago;
        this.estado = "esperando_carrito";
    }
    
    /**
     * Obtiene el identificador del cliente
     * @return El ID del cliente
     */
    public int getId() {
        return id;
    }
    
    /**
     * Establece el identificador del cliente
     * @param id El nuevo ID del cliente
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtiene el carrito asignado al cliente
     * @return El objeto Carrito del cliente, o null si no tiene carrito asignado
     */
    public Carrito getCarrito() {
        return carrito;
    }
    
    /**
     * Asigna un carrito al cliente
     * @param carrito El objeto Carrito a asignar
     */
    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
    
    /**
     * Obtiene el tiempo de compra del cliente
     * @return El tiempo estimado de compra en unidades de tiempo
     */
    public int getTiempoCompra() {
        return tiempoCompra;
    }
    
    /**
     * Establece el tiempo de compra del cliente
     * @param tiempoCompra El nuevo tiempo de compra
     */
    public void setTiempoCompra(int tiempoCompra) {
        this.tiempoCompra = tiempoCompra;
    }
    
    /**
     * Obtiene el tiempo de pago del cliente
     * @return El tiempo estimado de pago en unidades de tiempo
     */
    public int getTiempoPago() {
        return tiempoPago;
    }
    
    /**
     * Establece el tiempo de pago del cliente
     * @param tiempoPago El nuevo tiempo de pago
     */
    public void setTiempoPago(int tiempoPago) {
        this.tiempoPago = tiempoPago;
    }
    
    /**
     * Obtiene el estado actual del cliente
     * @return El estado del cliente (esperando_carrito, comprando, esperando_caja, pagando, finalizado)
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Establece el estado del cliente
     * @param estado El nuevo estado del cliente
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Genera una representación en texto del cliente
     * Incluye el ID, el carrito asignado (o "Ninguno") y el estado actual
     * @return String con formato "Cliente #[id] | Carrito: [id_carrito/Ninguno] | Estado: [estado]"
     */
    @Override
    public String toString() {
        return "Cliente #" + id +
               " | Carrito: " + (carrito != null ? carrito.getId() : "Ninguno") +
               " | Estado: " + estado;    
    }
}