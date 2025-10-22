package ejerciciosGuiados.actividad3;

/**
 * Representa un polinomio matemático mediante una lista enlazada de términos.
 * Permite construir, evaluar y visualizar polinomios de cualquier grado.
 * 
 * Funcionalidades principales:
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
     * Los términos se agregan en el orden de entrada (sin ordenamiento automático).
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
     * 
     * Usa la fórmula: P(x) = Σ(coeficiente * x^exponente)
     * 
     * Complejidad: O(n) donde n es el número de términos
     * 
     * @param x Valor en el cual evaluar el polinomio
     * @return Resultado de la evaluación P(x)
     */
    public double evaluar(double x) {
        double resultado = 0.0;
        Nodo<Termino> actual = terminos.getCabeza();
        
        // Suma el valor de cada término evaluado en x
        while (actual != null) {
            resultado += actual.getDato().evaluar(x);
            actual = actual.getSiguiente();
        }
        
        return resultado;
    }
    
    /**
     * Muestra el polinomio en notación matemática estándar.
     * 
     * Formato de salida:
     * - Términos con exponente 0: Solo coeficiente (ej: "5")
     * - Términos con exponente 1: "3x" o "-2x"
     * - Términos con exponente > 1: "4x^3" o "-5x^2"
     * - Coeficientes 1 y -1: Omite el 1 (ej: "x^2" en lugar de "1x^2")
     * - Signos: Maneja automáticamente + y -
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
                // Término constante: solo coeficiente
                System.out.print(coef);
            } else if (exp == 1) {
                // Exponente 1: formato "cx" o "x"
                if (coef == 1) {
                    System.out.print("x");
                } else if (coef == -1) {
                    System.out.print("-x");
                } else {
                    System.out.print(coef + "x");
                }
            } else {
                // Exponente > 1: formato "cx^n" o "x^n"
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
     * La tabla incluye valores de x y sus correspondientes P(x) con
     * formato visual mejorado usando caracteres de caja Unicode.
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
        
        // Evalúa y muestra cada punto en el rango
        for (double x = inicio; x <= fin; x += incremento) {
            double resultado = evaluar(x);
            System.out.printf("║   %5.1f   ║   %16.4f   ║%n", x, resultado);
        }
        
        System.out.println("╚═══════════╩════════════════════════╝");
    }
    
    /**
     * Calcula el grado del polinomio.
     * El grado es el exponente más alto presente en el polinomio.
     * 
     * Complejidad: O(n) donde n es el número de términos
     * 
     * @return Grado máximo del polinomio, o 0 si está vacío
     */
    public int getGrado() {
        if (terminos.estaVacia()) {
            return 0;
        }
        
        int gradoMaximo = 0;
        Nodo<Termino> actual = terminos.getCabeza();
        
        // Busca el exponente más alto
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

/*
 * NOTAS TÉCNICAS:
 * 
 * CARACTERÍSTICAS:
 * - Estructura flexible: Número ilimitado de términos
 * - Evaluación eficiente: Recorrido único de la lista
 * - Formato elegante: Tabla con caracteres Unicode
 * - Sin simplificación: No combina términos semejantes automáticamente
 * 
 * COMPLEJIDAD:
 * - agregarTermino(): O(n) - agrega al final
 * - evaluar(): O(n) - recorre todos los términos
 * - mostrarPolinomio(): O(n) - recorre y formatea
 * - mostrarTablaEvaluacion(): O(n*m) donde m es el número de puntos
 * - getGrado(): O(n) - busca exponente máximo
 * 
 * CONSIDERACIONES:
 * - No valida términos duplicados (mismo exponente)
 * - No ordena términos por exponente
 * - Acepta coeficientes de cualquier valor (incluso 0)
 * - El orden de salida es el mismo que el de entrada
 * 
 * EJEMPLO DE USO:
 * Polinomio p = new Polinomio();
 * p.agregarTermino(3, 4);    // 3x^4
 * p.agregarTermino(-4, 2);   // -4x^2
 * p.agregarTermino(11, 0);   // 11
 * p.mostrarPolinomio();      // P(x) = 3x^4 - 4x^2 + 11
 * double resultado = p.evaluar(2.0);  // Evalúa en x=2
 * System.out.println(resultado);      // 35.0
 * 
 * MEJORAS POSIBLES:
 * - Ordenar términos por exponente decreciente
 * - Simplificar términos semejantes automáticamente
 * - Agregar operaciones: suma, resta, multiplicación de polinomios
 * - Implementar derivada e integral
 * - Validar que no se agreguen términos con coeficiente 0
 * - Calcular raíces del polinomio
 */
