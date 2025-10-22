package ejerciciosGuiados.actividad4;

/**
 * Implementación de un polinomio matemático utilizando una lista circular enlazada.
 * 
 * Esta clase representa un polinomio de la forma:
 * aₙxⁿ + aₙ₋₁xⁿ⁻¹ + ... + a₁x + a₀
 * 
 * Características principales:
 * - Estructura de datos circular para recorrido eficiente
 * - Tipo genérico para coeficientes (Double, Integer, Float, etc.)
 * - Inserción constante O(1) al final de la lista
 * - Verificación automática de circularidad
 * - Representación matemática estándar en notación polinómica
 * 
 * La lista circular mantiene una referencia al último nodo, permitiendo
 * acceso rápido tanto al final como al inicio de la lista.
 * 
 * Ejemplo de polinomio representado:
 * Términos: 3x⁴, -4x², 11
 * Representación: 3.00x^4 - 4.00x^2 + 11.00
 * 
 * @param <T> Tipo de dato numérico para los coeficientes (debe extender Number)
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
class PolinomioCircular<T extends Number> {
    
    /** Referencia al último nodo de la lista circular (punto de acceso principal) */
    private Nodo<T> ultimo;
    
    /** Número de términos en el polinomio */
    private int tamanio;
    
    /**
     * Constructor que inicializa un polinomio vacío.
     * 
     * Estado inicial:
     * - ultimo = null (sin nodos)
     * - tamanio = 0 (polinomio vacío)
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
     * @return true si el polinomio está vacío, false si contiene al menos un término
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * PolinomioCircular<Double> poly = new PolinomioCircular<>();
     * poly.estaVacio(); // true
     * poly.agregarTermino(3.0, 2);
     * poly.estaVacio(); // false
     */
    public boolean estaVacio() {
        return ultimo == null;
    }
    
    /**
     * Agrega un nuevo término al final del polinomio.
     * 
     * La inserción mantiene la circularidad de la lista:
     * - En polinomio vacío: el nodo se apunta a sí mismo
     * - En polinomio no vacío: se inserta después del último nodo
     * 
     * @param coeficiente Valor numérico del coeficiente del término
     * @param exponente Potencia de x en el término (debe ser ≥ 0)
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * PolinomioCircular<Double> poly = new PolinomioCircular<>();
     * poly.agregarTermino(3.0, 2);  // Agrega 3x²
     * poly.agregarTermino(-4.0, 1); // Agrega -4x
     * poly.agregarTermino(11.0, 0); // Agrega 11
     */
    public void agregarTermino(T coeficiente, int exponente) {
        Nodo<T> nuevoNodo = new Nodo<>(coeficiente, exponente);
        
        if (estaVacio()) {
            // Primer nodo: apunta a sí mismo para formar el círculo
            ultimo = nuevoNodo;
            ultimo.setSiguiente(ultimo);
        } else {
            // Insertar al final y mantener la circularidad
            nuevoNodo.setSiguiente(ultimo.getSiguiente()); // El nuevo apunta al primero
            ultimo.setSiguiente(nuevoNodo); // El antiguo último apunta al nuevo
            ultimo = nuevoNodo; // Actualizar la referencia al último
        }
        tamanio++;
    }
    
    /**
     * Realiza un recorrido circular completo del polinomio, mostrando todos los términos.
     * 
     * El recorrido comienza desde el primer nodo (siguiente al último) y continúa
     * hasta volver al punto de inicio, demostrando la circularidad de la estructura.
     * 
     * Salida formateada:
     * Término 1: Coeficiente = 3.00, Exponente = 2
     * Término 2: Coeficiente = -4.00, Exponente = 1
     * ...
     * 
     * Complejidad: O(n) donde n es el número de términos
     * 
     * Ejemplo de salida:
     * === Recorrido Circular del Polinomio ===
     * Término 1: Coeficiente = 3.00, Exponente = 2
     * Término 2: Coeficiente = -4.00, Exponente = 1
     * === Fin del recorrido ===
     */
    public void recorridoCircular() {
        if (estaVacio()) {
            System.out.println("El polinomio está vacío");
            return;
        }
        
        System.out.println("\n=== Recorrido Circular del Polinomio ===");
        Nodo<T> primerNodo = ultimo.getSiguiente(); // El primero es el siguiente al último
        Nodo<T> actual = primerNodo;
        int contador = 1;
        
        do {
            System.out.printf("Término %d: Coeficiente = %.2f, Exponente = %d%n",
                    contador++, 
                    actual.getCoeficiente().doubleValue(),
                    actual.getExponente());
            actual = actual.getSiguiente();
        } while (actual != primerNodo); // Detener al volver al inicio
        
        System.out.println("=== Fin del recorrido ===\n");
    }
    
    /**
     * Muestra el polinomio en notación matemática estándar.
     * 
     * Formato de salida:
     * - Coeficientes con 2 decimales
     * - Signos apropiados (+/-) entre términos
     * - Exponentes solo para potencias > 1
     * - Coeficiente 1 implícito en términos con variable
     * 
     * Ejemplos:
     * - 3.00x^4 - 4.00x^2 + 11.00
     * - -2.50x^3 + 1.00x - 5.00
     * - 4.00x (para 4x)
     * - 7.00 (para término constante)
     * 
     * Complejidad: O(n) donde n es el número de términos
     * 
     * @return Representación en String del polinomio (implícito via System.out)
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
     * Realiza un recorrido completo contando nodos y verifica:
     * 1. Que el recorrido termina correctamente al llegar al inicio
     * 2. Que el número de nodos recorridos coincide con el tamaño registrado
     * 3. Que no hay ciclos infinitos (conteo excede el tamaño)
     * 
     * @return true si la lista es correctamente circular, false si hay errores de estructura
     * 
     * Complejidad: O(n) donde n es el número de términos
     * 
     * Ejemplo:
     * poly.verificarCircularidad(); // true (estructura correcta)
     */
    public boolean verificarCircularidad() {
        if (estaVacio()) return true;
        
        Nodo<T> primerNodo = ultimo.getSiguiente();
        Nodo<T> actual = primerNodo;
        int conteo = 0;
        
        do {
            conteo++;
            actual = actual.getSiguiente();
            if (conteo > tamanio) return false; // Detectar error (ciclo infinito)
        } while (actual != primerNodo);
        
        return conteo == tamanio;
    }
    
    /**
     * Obtiene el número de términos en el polinomio.
     * 
     * @return Cantidad de términos (nodos) en el polinomio
     * 
     * Complejidad: O(1)
     * 
     * Ejemplo:
     * PolinomioCircular<Double> poly = new PolinomioCircular<>();
     * poly.agregarTermino(3.0, 2);
     * poly.agregarTermino(-4.0, 1);
     * poly.getTamanio(); // 2
     */
    public int getTamanio() {
        return tamanio;
    }
    
    /**
     * Muestra información de diagnóstico detallada sobre la estructura circular.
     * 
     * Información mostrada:
     * - Número total de términos
     * - Estado de vaciedad
     * - Referencias del último y primer nodo
     * - Resultado de verificación de circularidad
     * 
     * Útil para depuración y comprensión de la estructura interna.
     * 
     * Complejidad: O(1) para información básica, O(n) si incluye verificación
     * 
     * Ejemplo de salida:
     * === Información de la Lista Circular ===
     * Tamaño: 3
     * ¿Está vacía?: false
     * Último nodo: (11.00, 0)
     * Primer nodo (siguiente al último): (3.00, 2)
     * ¿Es circular?: true
     * =======================================
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

/*
 * NOTAS TÉCNICAS:
 * 
 * VENTAJAS DE LISTA CIRCULAR:
 * - Inserción O(1) al final (con referencia al último)
 * - Recorrido circular natural para operaciones repetitivas
 * - Acceso rápido tanto al inicio como al final
 * - Estructura eficiente en memoria
 * 
 * COMPLEJIDAD ALGORÍTMICA:
 * - Constructor: O(1)
 * - estaVacio(): O(1)
 * - agregarTermino(): O(1)
 * - recorridoCircular(): O(n)
 * - mostrarPolinomio(): O(n)
 * - verificarCircularidad(): O(n)
 * - getTamanio(): O(1)
 * - mostrarInformacionCircular(): O(n) por verificación
 * 
 * CONSIDERACIONES DE DISEÑO:
 * - Referencia 'ultimo' permite acceso eficiente a ambos extremos
 * - Tamaño mantenido explícitamente para O(1) en getTamanio()
 * - Verificación de circularidad para detectar corrupción de datos
 * - Genéricos permiten reutilización con diferentes tipos numéricos
 * 
 * CASOS ESPECIALES MANEJADOS:
 * - Polinomio vacío (ultimo = null)
 * - Polinomio con un solo término (autorreferencia circular)
 * - Coeficientes negativos en representación visual
 * - Coeficiente 1 implícito en términos con variable
 * - Términos constantes (exponente 0)
 * 
 * EJEMPLO DE USO COMPLETO:
 * PolinomioCircular<Double> poly = new PolinomioCircular<>();
 * poly.agregarTermino(3.0, 4);   // 3x⁴
 * poly.agregarTermino(-4.0, 2);  // -4x²
 * poly.agregarTermino(11.0, 0);  // 11
 * 
 * poly.mostrarPolinomio();        // "3.00x^4 - 4.00x^2 + 11.00"
 * poly.recorridoCircular();       // Muestra los 3 términos
 * poly.mostrarInformacionCircular(); // Info de estructura
 * 
 * MEJORAS POSIBLES:
 * - Método para eliminar términos por exponente
 * - Ordenamiento automático por exponente descendente
 * - Operaciones algebraicas (suma, resta, multiplicación)
 * - Evaluación del polinomio en un punto x
 * - Método para calcular la derivada
 * - Serialización/deserialización
 * - Iterador para enhanced for-loop
 * - Validación de exponentes únicos
 * - Optimización de memoria para términos con coeficiente cero
 */
