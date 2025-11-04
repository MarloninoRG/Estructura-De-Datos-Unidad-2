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
    
    /** Exponente de la variable x */
    private int exponente;
    
    /**
     * Constructor que crea un nuevo término inmutable.
     * 
     * @param coeficiente Valor numérico (puede ser negativo)
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
     * Fórmula: coeficiente * x^exponente
     * 
     * Ejemplos:
     * - Término 3x²: evaluar(2) = 3 * 2² = 12
     * - Término -4x: evaluar(2) = -4 * 2 = -8
     * - Término 11: evaluar(2) = 11 * 2⁰ = 11
     * 
     * @param x Valor en el cual evaluar el término
     * @return Resultado de coeficiente * x^exponente
     */
    public double evaluar(double x) {
        return coeficiente * Math.pow(x, exponente);
    }
    
    /**
     * Retorna la representación en String del término en notación matemática.
     * 
     * Formatos:
     * - Exponente 0: "5.00" (solo coeficiente)
     * - Exponente 1: "3.00x" (sin mostrar ^1)
     * - Exponente > 1: "4.00x^3"
     * 
     * @return Representación en String del término
     */
    @Override
    public String toString() {
        if (exponente == 0) {
            return String.format("%.2f", coeficiente);
        } else if (exponente == 1) {
            return String.format("%.2fx", coeficiente);
        } else {
            return String.format("%.2fx^%d", coeficiente, exponente);
        }
    }
}
