package ejerciciosGuiados.actividad2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase utilitaria para operaciones de lectura y escritura de archivos.
 * Maneja la persistencia de palabras almacenadas en una lista enlazada.
 * 
 * @author Marlon Rojas Galindo
 * @contact marlonrojasgalindo@gmail.com
 * @version 1.0
 * @since 2025
 */
public class GestorArchivos {
    
    /**
     * Lee un archivo de texto y carga las palabras en una lista enlazada.
     * 
     * Proceso:
     * 1. Abre el archivo con BufferedReader
     * 2. Lee línea por línea
     * 3. Separa cada línea por espacios en blanco
     * 4. Agrega cada palabra no vacía a la lista
     * 
     * Manejo de errores:
     * - FileNotFoundException: Crea lista vacía para nuevo archivo
     * - IOException: Muestra error pero retorna lista (vacía o parcial)
     * 
     * @param nombreArchivo Ruta completa del archivo a leer
     * @return Lista enlazada con las palabras del archivo (vacía si no existe)
     */
    public static ListaEnlazada<String> leerArchivo(String nombreArchivo) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        
        // Try-with-resources: cierra automáticamente el BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            
            // Lee cada línea hasta el final del archivo (null)
            while ((linea = br.readLine()) != null) {
                // Separa por uno o más espacios en blanco (\\s+)
                // trim() elimina espacios al inicio y final de la línea
                String[] palabras = linea.trim().split("\\s+");
                
                // Agrega cada palabra no vacía a la lista
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        lista.agregarAlFinal(palabra);
                    }
                }
            }
            
            System.out.println("✓ Archivo leído exitosamente: " + nombreArchivo);
            
        } catch (FileNotFoundException e) {
            // Archivo no existe: se creará uno nuevo al guardar
            System.out.println("⚠ Archivo no encontrado. Se creará uno nuevo.");
            
        } catch (IOException e) {
            // Error de lectura: problema de permisos, disco, etc.
            System.out.println("✗ Error al leer el archivo: " + e.getMessage());
        }
        
        return lista;
    }
    
    /**
     * Escribe el contenido de la lista enlazada en un archivo de texto.
     * 
     * Proceso:
     * 1. Obtiene todas las palabras de la lista
     * 2. Escribe cada palabra separada por un espacio
     * 3. No agrega espacio después de la última palabra
     * 
     * Formato del archivo: "palabra1 palabra2 palabra3 ..."
     * 
     * Nota: Sobrescribe el archivo si ya existe
     * 
     * @param nombreArchivo Ruta completa del archivo donde guardar
     * @param lista Lista enlazada con las palabras a escribir
     */
    public static void escribirArchivo(String nombreArchivo, ListaEnlazada<String> lista) {
        // Try-with-resources: cierra automáticamente el BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Convierte la lista enlazada a List para fácil iteración
            List<String> palabras = lista.obtenerTodos();
            
            // Escribe cada palabra con espacio separador
            for (int i = 0; i < palabras.size(); i++) {
                bw.write(palabras.get(i));
                
                // Agrega espacio entre palabras, excepto después de la última
                if (i < palabras.size() - 1) {
                    bw.write(" ");
                }
            }
            
            System.out.println("✓ Archivo guardado exitosamente: " + nombreArchivo);
            
        } catch (IOException e) {
            // Error de escritura: permisos, disco lleno, ruta inválida, etc.
            System.out.println("✗ Error al escribir el archivo: " + e.getMessage());
        }
    }
}