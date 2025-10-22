package listas;

/**
 * La clase estudiante representa a todos los objetos estudiantes de la UTNG.
 * @author Marlon Rojas Galindo
 * @contact marlonrojasuniversity@gmail.com
 * @version 1.0
 * @since 2025
 */
public class Estudiante {
    //Atributos
    private String nombre; //Nombre del estudiante
    private byte edad; //Edad del estudiante
    private char sexo; //Sexo del estudiante
    
    //Constructores
    /**
     * Construye un objeto Estuiante
     */
    public Estudiante() {
    }
    /**
     * Construye un objeto Estudiante con nombre, edad y sexo
     * @param nombre el nombre del estudiante
     * @param edad la edad del estudiante
     * @param sexo el sexo del estudiante
     */
    public Estudiante(String nombre, byte edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }    
    
    //Metodos get y set
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //Metodos
    public void estudiar(){
        System.out.println("Estudiando");
    }
    
    public void dormir(){
        System.out.println("Durmiendo");
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + '}';
    }
}
