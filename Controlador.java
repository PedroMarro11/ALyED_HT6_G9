/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 6
 * @author Diana Díaz 21066
 * @author Pedro Marroquín 21801
 * @version 1.0 17/03/2022
 */
public class Controlador {
    /**
     * Método para verificar que la entrada del usuario sea
     * un int
     * @param entrada
     * @return true si es un entero
     */
    public static boolean isInt(String entrada)
    {
       try {
           Integer.parseInt(entrada);
           return true;
       }catch(Exception e)
       {
           return false;
       }
    }
}
