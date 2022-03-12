import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        Scanner input = new Scanner (System.in);
        boolean exit = false;
        Factory factory = new Factory();
        File archivo = new File();

        System.out.println("Programa de cartas");

        while(!exit) {

            /* Mostrar opciones del menu */
            System.out.println("\r\n");
            System.out.println("Menú:");
            System.out.println(" 1 - Agregar carta a la colección del usuario:");
            System.out.println(" 2 - Mostrar tipo de carta");
            System.out.println(" 3 - Mostrar  nombre, tipo y cantidad de cada carta en la colección ");
            System.out.println(" 4 - Mostrar  nombre, tipo y cantidad de cada carta en la colección  ordenada por tipo");
            System.out.println(" 5 - Mostrar nombre y tipo de todas las cartas");
            System.out.println(" 6 - Mostrar nombre y tipo de todas las cartas, ordenadas por tipo");
            System.out.println(" 7 - Salir");

            System.out.println("Elija una opción");
            int option = input.nextInt();
            factory.NewMap(option);

        }
    }
}
