package ejerciciosGuiados.actividad4;

/**
 * Clase Nodo genérica para representar un término individual en un polinomio
 * implementado con lista circular.
 * 
 * Cada nodo almacena:
 * - Coeficiente: Valor numérico del término
 * - Exponente: Potencia de la variable x
 * - Siguiente: Referencia al siguiente nodo en la lista circular
 * 
 * Ejemplos de nodos:
 * - 3x² → coeficiente=3.0, exponente=2
 * - -4.5x → coeficiente=-4.5, exponente=1  
 * - 7 → coeficiente=7.0, exponente=0
 * 
 * @param <T> Tipo de dato para el coeficiente (debe extender Number)
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class Nodo<T extends Number> {
    
    /** Coeficiente numérico del término */
    private T coeficiente;
    
    /** Exponente (potencia) de la variable x */
    private int exponente;
    
    /** Referencia al siguiente nodo en la lista circular */
    private Nodo<T> siguiente;
    
    /**
     * Constructor que crea un nuevo nodo con coeficiente y exponente.
     * La referencia siguiente se inicializa como null.
     * 
     * @param coeficiente Valor numérico del coeficiente
     * @param exponente Potencia de x (debe ser no negativo)
     */
    public Nodo(T coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el coeficiente almacenado en el nodo.
     * 
     * @return Coeficiente del término
     */
    public T getCoeficiente() { 
        return coeficiente; 
    }
    
    /**
     * Establece un nuevo valor para el coeficiente.
     * 
     * @param coeficiente Nuevo valor numérico
     */
    public void setCoeficiente(T coeficiente) { 
        this.coeficiente = coeficiente; 
    }
    
    /**
     * Obtiene el exponente almacenado en el nodo.
     * 
     * @return Exponente del término
     */
    public int getExponente() { 
        return exponente; 
    }
    
    /**
     * Establece un nuevo valor para el exponente.
     * 
     * @param exponente Nuevo valor (debe ser ≥ 0)
     */
    public void setExponente(int exponente) { 
        this.exponente = exponente; 
    }
    
    /**
     * Obtiene la referencia al siguiente nodo en la lista circular.
     * 
     * @return Referencia al siguiente nodo
     */
    public Nodo<T> getSiguiente() { 
        return siguiente; 
    }
    
    /**
     * Establece la referencia al siguiente nodo en la lista circular.
     * 
     * @param siguiente Nuevo nodo siguiente
     */
    public void setSiguiente(Nodo<T> siguiente) { 
        this.siguiente = siguiente; 
    }
    
    /**
     * Retorna una representación en String del nodo.
     * Formato: (coeficiente, exponente)
     * 
     * Ejemplos:
     * - (3.00, 2) para 3x²
     * - (-4.50, 1) para -4.5x
     * - (7.00, 0) para 7
     * 
     * @return String en formato (coeficiente, exponente)
     */
    @Override
    public String toString() {
        return String.format("(%.2f, %d)", coeficiente.doubleValue(), exponente);
    }
}