package ejerciciosGuiados.actividad4;

/**
 * Clase Nodo genérica para representar un término individual en un polinomio
 * implementado con lista circular.
 * 
 * Cada nodo almacena:
 * - Coeficiente: Valor numérico del término (genérico, extendiendo Number)
 * - Exponente: Potencia de la variable x (entero no negativo)
 * - Siguiente: Referencia al siguiente nodo en la lista circular
 * 
 * La estructura del nodo sigue el formato: coeficiente * x^exponente
 * 
 * Ejemplos de nodos:
 * - 3x² → coeficiente=3.0, exponente=2
 * - -4.5x → coeficiente=-4.5, exponente=1  
 * - 7 → coeficiente=7.0, exponente=0
 * 
 * Esta clase es fundamental para la construcción de la lista circular
 * que representa el polinomio completo.
 * 
 * @param <T> Tipo de dato para el coeficiente (Double, Integer, Float, etc.)
 *            Debe extender Number para operaciones numéricas
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class Nodo<T extends Number> {
    
    /** Coeficiente numérico del término polinómico */
    private T coeficiente;
    
    /** Exponente (potencia) de la variable x en el término */
    private int exponente;
    
    /** Referencia al siguiente nodo en la lista circular */
    private Nodo<T> siguiente;
    
    /**
     * Constructor que crea un nuevo nodo término con coeficiente y exponente.
     * El nodo se inicializa con referencia siguiente nula, que será
     * establecida al insertarse en la lista circular.
     * 
     * @param coeficiente Valor numérico del coeficiente del término
     * @param exponente Potencia de x (debe ser entero no negativo)
     * 
     * Ejemplos:
     * - new Nodo<>(3.0, 2)  // Representa 3x²
     * - new Nodo<>(-4, 1)   // Representa -4x
     * - new Nodo<>(7.5, 0)  // Representa 7.5 (término constante)
     */
    public Nodo(T coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el coeficiente almacenado en el nodo.
     * 
     * @return Coeficiente del término (tipo genérico T)
     */
    public T getCoeficiente() { 
        return coeficiente; 
    }
    
    /**
     * Establece un nuevo valor para el coeficiente del término.
     * 
     * @param coeficiente Nuevo valor numérico para el coeficiente
     */
    public void setCoeficiente(T coeficiente) { 
        this.coeficiente = coeficiente; 
    }
    
    /**
     * Obtiene el exponente almacenado en el nodo.
     * 
     * @return Exponente del término (entero)
     */
    public int getExponente() { 
        return exponente; 
    }
    
    /**
     * Establece un nuevo valor para el exponente del término.
     * 
     * @param exponente Nuevo valor para el exponente (debe ser ≥ 0)
     */
    public void setExponente(int exponente) { 
        this.exponente = exponente; 
    }
    
    /**
     * Obtiene la referencia al siguiente nodo en la lista circular.
     * En una lista circular bien formada, este método nunca retorna null
     * excepto para nodos aislados no insertados.
     * 
     * @return Referencia al siguiente nodo en la lista circular
     */
    public Nodo<T> getSiguiente() { 
        return siguiente; 
    }
    
    /**
     * Establece la referencia al siguiente nodo en la lista circular.
     * Este método es crucial para mantener la estructura circular.
     * 
     * @param siguiente Nuevo nodo siguiente en la lista
     */
    public void setSiguiente(Nodo<T> siguiente) { 
        this.siguiente = siguiente; 
    }
    
    /**
     * Retorna una representación en String del nodo en formato legible.
     * El formato es: "(coeficiente, exponente)" con coeficiente mostrado
     * con 2 decimales para consistencia visual.
     * 
     * Ejemplos:
     * - (3.00, 2)   para 3x²
     * - (-4.50, 1)  para -4.5x
     * - (7.00, 0)   para 7
     * 
     * @return String representando el nodo en formato (coeficiente, exponente)
     */
    @Override
    public String toString() {
        return String.format("(%.2f, %d)", coeficiente.doubleValue(), exponente);
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * CARACTERÍSTICAS DEL DISEÑO:
 * - Genéricidad: Soporta cualquier tipo que extienda Number
 * - Encapsulamiento: Atributos privados con acceso controlado
 * - Flexibilidad: Permite modificar coeficiente y exponente
 * - Representación consistente: toString() formateado
 * 
 * USO EN LISTA CIRCULAR:
 * - El campo 'siguiente' permite enlazar nodos
 * - En lista circular, el último nodo apunta al primero
 * - Cada nodo representa un término del polinomio
 * - La lista mantiene el orden de los términos
 * 
 * CONSIDERACIONES DE TIPO GENÉRICO:
 * - T extends Number garantiza operaciones numéricas
 * - doubleValue() permite conversión uniforme en toString()
 * - Soporta Double, Integer, Float, Long, etc.
 * - Preserva tipo específico en getCoeficiente()
 * 
 * COMPLEJIDAD:
 * - Constructor: O(1)
 * - Getters/Setters: O(1)
 * - toString(): O(1)
 * 
 * EJEMPLOS DE USO:
 * // Crear nodos con diferentes tipos
 * Nodo<Double> nodo1 = new Nodo<>(3.5, 2);    // 3.5x²
 * Nodo<Integer> nodo2 = new Nodo<>(-4, 1);     // -4x
 * Nodo<Float> nodo3 = new Nodo<>(7.2f, 0);     // 7.2
 * 
 * // Establecer enlace circular
 * nodo1.setSiguiente(nodo2);
 * nodo2.setSiguiente(nodo3);
 * nodo3.setSiguiente(nodo1);  // Completar circularidad
 * 
 * // Acceder a datos
 * System.out.println(nodo1.getCoeficiente());  // 3.5
 * System.out.println(nodo1.getExponente());    // 2
 * System.out.println(nodo1);                   // "(3.50, 2)"
 * 
 * MEJORAS POSIBLES:
 * - Validar que exponente >= 0 en constructor y setter
 * - Implementar equals() y hashCode() para comparaciones
 * - Agregar método para evaluar el término en un punto x
 * - Implementar Cloneable para copias profundas
 * - Agregar método para derivar el término
 * - Incluir validación de tipo en setters
 * 
 * INTEGRACIÓN CON PolinomioCircular:
 * - Esta clase es el componente básico de PolinomioCircular
 * - PolinomioCircular gestiona la colección de nodos
 * - Mantiene la circularidad y orden de los términos
 * - Proporciona operaciones a nivel de polinomio completo
 */
