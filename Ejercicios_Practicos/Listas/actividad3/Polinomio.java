package ejerciciosGuiados.actividad3;

/**
 * Representa un polinomio matemático mediante una lista enlazada de términos.
 * Permite construir, evaluar y visualizar polinomios de cualquier grado.
 * 
 * Funcionalidades:
 * - Agregar términos (coeficiente y exponente)
 * - Evaluar el polinomio en un punto específico
 * - Mostrar en notación matemática estándar
 * - Generar tablas de evaluación
 * - Calcular el grado del polinomio
 * 
 * Ejemplo: 3x² - 4x + 11
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Polinomio {
    
    /** Lista enlazada que almacena los términos del polinomio */
    private ListaEnlazada<Termino> terminos;
    
    /**
     * Constructor que inicializa un polinomio vacío.
     */
    public Polinomio() {
        this.terminos = new ListaEnlazada<>();
    }
    
    /**
     * Agrega un nuevo término al polinomio.
     * Los términos se agregan en el orden de entrada.
     * 
     * @param coeficiente Coeficiente del término (puede ser negativo)
     * @param exponente Exponente del término (debe ser no negativo)
     */
    public void agregarTermino(double coeficiente, int exponente) {
        Termino nuevoTermino = new Termino(coeficiente, exponente);
        terminos.agregarAlFinal(nuevoTermino);
    }
    
    /**
     * Evalúa el polinomio en un punto específico.
     * Usa la fórmula: P(x) = Σ(coeficiente * x^exponente)
     * 
     * Complejidad: O(n)
     * 
     * @param x Valor en el cual evaluar el polinomio
     * @return Resultado de la evaluación P(x)
     */
    public double evaluar(double x) {
        double resultado = 0.0;
        Nodo<Termino> actual = terminos.getCabeza();
        
        while (actual != null) {
            resultado += actual.getDato().evaluar(x);
            actual = actual.getSiguiente();
        }
        
        return resultado;
    }
    
    /**
     * Muestra el polinomio en notación matemática estándar.
     * 
     * Formato:
     * - Exponente 0: Solo coeficiente (ej: "5")
     * - Exponente 1: "3x" o "-2x"
     * - Exponente > 1: "4x^3" o "-5x^2"
     * - Coeficientes 1 y -1: Omite el 1 (ej: "x^2")
     * 
     * Ejemplo: P(x) = 3x^4 - 4x^2 + 11
     */
    public void mostrarPolinomio() {
        if (terminos.estaVacia()) {
            System.out.println("El polinomio está vacío.");
            return;
        }
        
        System.out.print("P(x) = ");
        Nodo<Termino> actual = terminos.getCabeza();
        boolean primero = true;
        
        while (actual != null) {
            Termino termino = actual.getDato();
            double coef = termino.getCoeficiente();
            int exp = termino.getExponente();
            
            // Agregar signo entre términos
            if (!primero) {
                if (coef > 0) {
                    System.out.print(" + ");
                } else {
                    System.out.print(" ");
                }
            }
            
            // Formatear según el exponente
            if (exp == 0) {
                System.out.print(coef);
            } else if (exp == 1) {
                if (coef == 1) {
                    System.out.print("x");
                } else if (coef == -1) {
                    System.out.print("-x");
                } else {
                    System.out.print(coef + "x");
                }
            } else {
                if (coef == 1) {
                    System.out.print("x^" + exp);
                } else if (coef == -1) {
                    System.out.print("-x^" + exp);
                } else {
                    System.out.print(coef + "x^" + exp);
                }
            }
            
            primero = false;
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
    
    /**
     * Genera y muestra una tabla de evaluación del polinomio en un rango.
     * 
     * @param inicio Valor inicial de x
     * @param fin Valor final de x (inclusivo)
     * @param incremento Paso entre cada evaluación
     */
    public void mostrarTablaEvaluacion(double inicio, double fin, double incremento) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   TABLA DE EVALUACIÓN              ║");
        System.out.println("╠═══════════╦════════════════════════╣");
        System.out.println("║     x     ║        P(x)            ║");
        System.out.println("╠═══════════╬════════════════════════╣");
        
        for (double x = inicio; x <= fin; x += incremento) {
            double resultado = evaluar(x);
            System.out.printf("║   %5.1f   ║   %16.4f   ║%n", x, resultado);
        }
        
        System.out.println("╚═══════════╩════════════════════════╝");
    }
    
    /**
     * Calcula el grado del polinomio.
     * El grado es el exponente más alto presente.
     * 
     * Complejidad: O(n)
     * 
     * @return Grado máximo del polinomio, o 0 si está vacío
     */
    public int getGrado() {
        if (terminos.estaVacia()) {
            return 0;
        }
        
        int gradoMaximo = 0;
        Nodo<Termino> actual = terminos.getCabeza();
        
        while (actual != null) {
            int exp = actual.getDato().getExponente();
            if (exp > gradoMaximo) {
                gradoMaximo = exp;
            }
            actual = actual.getSiguiente();
        }
        
        return gradoMaximo;
    }
}
