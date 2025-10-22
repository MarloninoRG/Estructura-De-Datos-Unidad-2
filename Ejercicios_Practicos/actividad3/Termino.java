package ejerciciosGuiados.actividad3;

/**
 * Representa un término individual de un polinomio.
 * Un término tiene la forma: coeficiente * x^exponente
 * 
 * Ejemplos:
 * - 3x² → coeficiente=3, exponente=2
 * - -4x → coeficiente=-4, exponente=1
 * - 11 → coeficiente=11, exponente=0
 * 
 * Esta clase es inmutable: los valores no pueden cambiar después de la creación.
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Termino {
    
    /** Coeficiente numérico del término */
    private double coeficiente;
    
    /** Exponente de la variable x (potencia) */
    private int exponente;
    
    /**
     * Constructor que crea un nuevo término inmutable.
     * 
     * @param coeficiente Valor numérico del coeficiente (puede ser negativo)
     * @param exponente Potencia de x (debe ser no negativo)
     */
    public Termino(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
    
    /**
     * Obtiene el coeficiente del término.
     * 
     * @return Coeficiente numérico
     */
    public double getCoeficiente() {
        return coeficiente;
    }
    
    /**
     * Obtiene el exponente del término.
     * 
     * @return Exponente de la variable x
     */
    public int getExponente() {
        return exponente;
    }
    
    /**
     * Evalúa el término para un valor específico de x.
     * 
     * Fórmula: coeficiente * x^exponente
     * 
     * Ejemplos:
     * - Término 3x²: evaluar(2) = 3 * 2² = 12
     * - Término -4x: evaluar(2) = -4 * 2 = -8
     * - Término 11: evaluar(2) = 11 * 2⁰ = 11
     * 
     * Complejidad: O(1) usando Math.pow()
     * 
     * @param x Valor en el cual evaluar el término
     * @return Resultado de la evaluación: coeficiente * x^exponente
     */
    public double evaluar(double x) {
        return coeficiente * Math.pow(x, exponente);
    }
    
    /**
     * Retorna la representación en String del término en notación matemática.
     * 
     * Formatos según el exponente:
     * - Exponente 0: "5.00" (solo coeficiente)
     * - Exponente 1: "3.00x" (sin mostrar el ^1)
     * - Exponente > 1: "4.00x^3" (con exponente)
     * 
     * Coeficientes se muestran con 2 decimales.
     * 
     * @return Representación en String del término
     */
    @Override
    public String toString() {
        if (exponente == 0) {
            // Término constante: solo coeficiente
            return String.format("%.2f", coeficiente);
        } else if (exponente == 1) {
            // Exponente 1: formato "cx" (sin ^1)
            return String.format("%.2fx", coeficiente);
        } else {
            // Exponente > 1: formato "cx^n"
            return String.format("%.2fx^%d", coeficiente, exponente);
        }
    }
}

/*
 * NOTAS TÉCNICAS:
 * 
 * CARACTERÍSTICAS:
 * - Inmutable: Sin setters, valores fijos después de creación
 * - Evaluación eficiente: Usa Math.pow() de la biblioteca estándar
 * - toString() personalizado: Facilita depuración y visualización
 * - Formato matemático: Representación clara y estándar
 * 
 * INMUTABILIDAD:
 * Ventajas:
 * - Thread-safe: Seguro en programación concurrente
 * - Predecible: Los valores no cambian accidentalmente
 * - Cacheable: Resultados pueden almacenarse sin riesgo
 * 
 * COMPLEJIDAD:
 * - Constructor: O(1)
 * - getCoeficiente(): O(1)
 * - getExponente(): O(1)
 * - evaluar(): O(1) - Math.pow() es constante para enteros pequeños
 * - toString(): O(1)
 * 
 * CASOS ESPECIALES:
 * - Coeficiente 0: El término existe pero contribuye 0 al polinomio
 * - Exponente 0: Término constante (x⁰ = 1)
 * - Coeficiente negativo: Se maneja correctamente en evaluación
 * 
 * EJEMPLOS DE USO:
 * // Crear términos
 * Termino t1 = new Termino(3, 2);      // 3x²
 * Termino t2 = new Termino(-4, 1);     // -4x
 * Termino t3 = new Termino(11, 0);     // 11
 * 
 * // Evaluar en x=2
 * System.out.println(t1.evaluar(2));   // 12.0
 * System.out.println(t2.evaluar(2));   // -8.0
 * System.out.println(t3.evaluar(2));   // 11.0
 * 
 * // Mostrar términos
 * System.out.println(t1);              // "3.00x^2"
 * System.out.println(t2);              // "-4.00x"
 * System.out.println(t3);              // "11.00"
 * 
 * MEJORAS POSIBLES:
 * - Validar que exponente >= 0 en el constructor
 * - Agregar método para sumar términos semejantes
 * - Implementar equals() y hashCode() para comparaciones
 * - Agregar método derivar() que retorna la derivada del término
 * - Implementar Comparable para ordenar términos por exponente
 * - Optimizar toString() para coeficientes 1 y -1
 */
