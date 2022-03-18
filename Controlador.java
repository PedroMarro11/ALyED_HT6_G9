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
