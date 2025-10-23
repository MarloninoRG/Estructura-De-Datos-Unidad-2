package ejerciciosGuiados.actividad4;

/**
 * Implementación de un polinomio matemático utilizando una lista circular enlazada.
 * 
 * Representa un polinomio de la forma: aₙxⁿ + aₙ₋₁xⁿ⁻¹ + ... + a₁x + a₀
 * 
 * Características:
 * - Estructura circular para recorrido eficiente
 * - Tipo genérico para coeficientes (Double, Integer, Float, etc.)
 * - Inserción O(1) al final de la lista
 * - Verificación automática de circularidad
 * 
 * Ejemplo: 3x⁴ - 4x² + 11
 * 
 * @param <T> Tipo numérico para los coeficientes (debe extender Number)
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class PolinomioCircular<T extends Number> {
    
    /** Referencia al último nodo de la lista circular */
    private Nodo<T> ultimo;
    
    /** Número de términos en el polinomio */
    private int tamanio;
    
    /**
     * Constructor que inicializa un polinomio vacío.
     * 
     * Complejidad: O(1)
     */
    public PolinomioCircular() {
        this.ultimo = null;
        this.tamanio = 0;
    }
    
    /**
     * Verifica si el polinomio no contiene términos.
     * 
     * @return true si está vacío, false si contiene al menos un término
     * 
     * Complejidad: O(1)
     */
    public boolean estaVacio() {
        return ultimo == null;
    }
    
    /**
     * Agrega un nuevo término al final del polinomio.
     * 
     * Mantiene la circularidad:
     * - En polinomio vacío: el nodo se apunta a sí mismo
     * - En polinomio no vacío: se inserta después del último nodo
     * 
     * @param coeficiente Valor numérico del coeficiente
     * @param exponente Potencia de x (debe ser ≥ 0)
     * 
     * Complejidad: O(1)
     */
    public void agregarTermino(T coeficiente, int exponente) {
        Nodo<T> nuevoNodo = new Nodo<>(coeficiente, exponente);
        
        if (estaVacio()) {
            // Primer nodo: apunta a sí mismo
            ultimo = nuevoNodo;
            ultimo.setSiguiente(ultimo);
        } else {
            // Insertar al final y mantener circularidad
            nuevoNodo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        tamanio++;
    }
    
    /**
     * Realiza un recorrido circular completo del polinomio.
     * 
     * Comienza desde el primer nodo y continúa hasta volver al inicio,
     * mostrando todos los términos con formato.
     * 
     * Complejidad: O(n)
     */
    public void recorridoCircular() {
        if (estaVacio()) {
            System.out.println("El polinomio está vacío");
            return;
        }
        
        System.out.println("\n=== Recorrido Circular del Polinomio ===");
        Nodo<T> primerNodo = ultimo.getSiguiente();
        Nodo<T> actual = primerNodo;
        int contador = 1;
        
        do {
            System.out.printf("Término %d: Coeficiente = %.2f, Exponente = %d%n",
                    contador++, 
                    actual.getCoeficiente().doubleValue(),
                    actual.getExponente());
            actual = actual.getSiguiente();
        } while (actual != primerNodo);
        
        System.out.println("=== Fin del recorrido ===\n");
    }
    
    /**
     * Muestra el polinomio en notación matemática estándar.
     * 
     * Formato:
     * - Coeficientes con 2 decimales
     * - Signos apropiados (+/-) entre términos
     * - Exponentes solo para potencias > 1
     * 
     * Ejemplos:
     * - 3.00x^4 - 4.00x^2 + 11.00
     * - -2.50x^3 + 1.00x - 5.00
     * 
     * Complejidad: O(n)
     */
    public void mostrarPolinomio() {
        if (estaVacio()) {
            System.out.println("0");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        Nodo<T> primerNodo = ultimo.getSiguiente();
        Nodo<T> actual = primerNodo;
        boolean esPrimero = true;
        
        do {
            double coef = actual.getCoeficiente().doubleValue();
            int exp = actual.getExponente();
            
            // Agregar signo
            if (!esPrimero) {
                sb.append(coef >= 0 ? " + " : " - ");
                coef = Math.abs(coef);
            } else if (coef < 0) {
                sb.append("-");
                coef = Math.abs(coef);
            }
            
            // Agregar coeficiente
            if (coef != 1.0 || exp == 0) {
                sb.append(String.format("%.2f", coef));
            }
            
            // Agregar variable y exponente
            if (exp > 0) {
                sb.append("x");
                if (exp > 1) {
                    sb.append("^").append(exp);
                }
            }
            
            esPrimero = false;
            actual = actual.getSiguiente();
        } while (actual != primerNodo);
        
        System.out.println("Polinomio: " + sb.toString());
    }
    
    /**
     * Verifica la integridad de la circularidad de la lista.
     * 
     * Realiza un recorrido completo y verifica:
     * - Que el recorrido termina al llegar al inicio
     * - Que el número de nodos coincide con el tamaño registrado
     * - Que no hay ciclos infinitos
     * 
     * @return true si la lista es correctamente circular, false si hay errores
     * 
     * Complejidad: O(n)
     */
    public boolean verificarCircularidad() {
        if (estaVacio()) return true;
        
        Nodo<T> primerNodo = ultimo.getSiguiente();
        Nodo<T> actual = primerNodo;
        int conteo = 0;
        
        do {
            conteo++;
            actual = actual.getSiguiente();
            if (conteo > tamanio) return false;
        } while (actual != primerNodo);
        
        return conteo == tamanio;
    }
    
    /**
     * Obtiene el número de términos en el polinomio.
     * 
     * @return Cantidad de términos
     * 
     * Complejidad: O(1)
     */
    public int getTamanio() {
        return tamanio;
    }
    
    /**
     * Muestra información de diagnóstico sobre la estructura circular.
     * 
     * Información mostrada:
     * - Número total de términos
     * - Estado de vaciedad
     * - Referencias del último y primer nodo
     * - Resultado de verificación de circularidad
     * 
     * Complejidad: O(n)
     */
    public void mostrarInformacionCircular() {
        System.out.println("\n=== Información de la Lista Circular ===");
        System.out.println("Tamaño: " + tamanio);
        System.out.println("¿Está vacía?: " + estaVacio());
        
        if (!estaVacio()) {
            System.out.println("Último nodo: " + ultimo);
            System.out.println("Primer nodo (siguiente al último): " + ultimo.getSiguiente());
            System.out.println("¿Es circular?: " + verificarCircularidad());
        }
        System.out.println("=======================================\n");
    }
}