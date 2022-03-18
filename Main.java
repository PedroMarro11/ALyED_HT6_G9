import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static String archivo = "cards_desc.txt";

    public static String mainMenu = "MENÚ: \n" +
            " 1. Usar programa. \n" +
            " 2. Salir del programa.";

    public static String factoryMenu = "MENÚ: \n" +
            " 1. Usar HashMap. \n" +
            " 2. Usar TreeMap. \n" +
            " 3. Usar LinkedHashMap. \n";

    public static String menu = "MENÚ: \n" +
            " 1. Agregar una carta a la colección del usuario. \n" +
            " 2. Mostrar el tipo de carta. \n" +
            " 3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección. \n" +
            " 4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo. \n" +
            " 5. Mostrar el nombre y tipo de todas las cartas existentes. \n" +
            " 6. Mostrar el nombre y tipo de todas las cartas existentes ordenadas por tipo. \n" +
            " 7. Salir ";

    public static void main(String[] args) {

        //Atributo wantsToContinue que permite al usuario repetir el programa sin necesidad de salirse.
        boolean wantsToContinue = true;

        Scanner input = new Scanner(System.in);
        Map <String, String> mainMap;
        Map <String, String> collection;
        Factory factory = new Factory();


        //Selección del tipo de mapa que desea usar.
        System.out.println("Seleccione el número del tipo de mapa que desea: ");
        System.out.println(factoryMenu);
        int mapType = Integer.parseInt(input.next());

        switch (mapType) {
            //Definir como ArrayPila
            case 1: {
                mainMap = factory.("HashMap");
                collection = factory.NewMap("HashMap");
                break;
            }

            //Definir como VectorPila
            case 2: {
                mainMap = factory.NewMap("TreeMap");
                collection = factory.NewMap("TreeMap");
                break;
            }

            //Definir como lista (elegir el tipo de lista).
            case 3: {
                mainMap = factory.NewMap("LinkedHashMap");
                collection = factory.NewMap("LinkedHashMap");
                break;
            }

            default:
                mainMap = factory.NewMap("HashMap");
                collection = factory.NewMap("HashMap");
                break;
        }

        //Programa principal.
        do {
            System.out.println(mainMenu);
            int option = Integer.parseInt(input.next());

            switch (option) {

                case 1: {
                    try {
                        //Lectura del archivo de texto.
                        Stream<String> lines = Files.lines(
                                Paths.get(archivo),
                                StandardCharsets.UTF_8
                        );
                        //Para cada línea del arcivo de texto separa por "|" y se almacenan los datos en el Map.
                        lines.forEach(line -> {
                            String[] parts = line.split("|");
                            String key = parts[0];
                            String val = parts[1];
                            mainMap.put(key, val);
                        });

                        System.out.println("Se han almacenado los datos con éxito! ");

                    } catch (IOException exception) {
                        System.out.println("Error!");
                    }

                    //Opciones de modificación luego de almacenar los datos del archivo.
                    System.out.println(menu);
                    System.out.print("Que desea hacer? ");
                    int op = Integer.parseInt(input.next());

                    //Difentes opciones según la elección del usuario.
                    switch (op){
                        // 1. Agregar una carta a la colección del usuario.
                        case 1: {
                            //Pedir el nombre de la carta
                            System.out.println("Cuál es el nombre de la carta que desea agregar a su colección? ");
                            String name = input.nextLine();

                            if (mainMap.containsKey(name) && !collection.containsKey(name)){
                                collection.put(name, mainMap.get(name));
                            } else {
                                System.out.println("Revise que el nombre de la carta no esté tomado o que no exista. ");
                            }

                            break;
                        }

                        // 2. Mostrar el tipo de carta.
                        case 2: {
                            System.out.println("Ingrese el nombre de la carta: ");
                            String name = input.next();

                            if (mainMap.containsKey(name)){

                                System.out.println(mainMap.get(name));
                            } else {
                                System.out.println("El nombre de la carta que ingresó no es válido. ");
                            }
                            break;
                        }
                        // 3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.
                        case 3: {
                            int monstruoCont = 0;
                            int trampaContador = 0;
                            int hechizoContador = 0;
                            for(Map.Entry<String, String> entry : collection.entrySet()) {
                                String key = entry.getKey();
                                String value = entry.getValue();

                                //Suma a los contadores dependiendo del tipo de la carta.
                                System.out.println("Nombre: " + key + " Tipo: " + value);
                                if(value.equals("Monstruo")){
                                    monstruoCont ++;
                                } else if (value.equals("Trampa")){
                                    trampaContador ++;
                                } else {
                                    hechizoContador ++;
                                }
                            }

                            System.out.println("Cantidad de cartas tipo Monstruo: " + monstruoCont);
                            System.out.println("Cantidad de cartas tipo Trampa: " + trampaContador);
                            System.out.println("Cantidad de cartas tipo Hechizo: " + hechizoContador);
                            break;
                        }

                        // 4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo.
                        case 4: {
                            int monstruoCont = 0;
                            int trampaContador = 0;
                            int hechizoContador = 0;
                            ArrayList<Map.Entry<String, String>> monstruoType = new ArrayList<>();
                            ArrayList<Map.Entry<String, String>> hechiceroType = new ArrayList<>();
                            ArrayList<Map.Entry<String, String>> trampaType = new ArrayList<>();
                            for(Map.Entry<String, String> entry : collection.entrySet()) {
                                String key = entry.getKey();
                                String value = entry.getValue();

                                //Suma a los contadores dependiendo del tipo de la carta.
                                if(value.equals("Monstruo")){
                                    monstruoCont ++;
                                    monstruoType.add(entry);

                                } else if (value.equals("Trampa")){
                                    trampaContador ++;
                                    hechiceroType.add(entry);
                                } else {
                                    hechizoContador ++;
                                    hechiceroType.add(entry);
                                }
                            }

                            for(Map.Entry<String, String> e: monstruoType){
                                System.out.println("Nombre: " + e.getKey() + "| Tipo: " + e.getValue());
                            }
                            for(Map.Entry<String, String> e: trampaType){
                                System.out.println("Nombre: " + e.getKey() + "| Tipo: " + e.getValue());
                            }
                            for(Map.Entry<String, String> e: hechiceroType){
                                System.out.println("Nombre: " + e.getKey() + "| Tipo: " + e.getValue());
                            }
                            System.out.println("Cantidad de cartas tipo Monstruo: " + monstruoCont);
                            System.out.println("Cantidad de cartas tipo Trampa: " + trampaContador);
                            System.out.println("Cantidad de cartas tipo Hechizo: " + hechizoContador);

                        }

                        // 5. Mostrar el nombre y tipo de todas las cartas existentes.
                        case 5: {
                            int monstruoCont = 0;
                            int trampaContador = 0;
                            int hechizoContador = 0;
                            for(Map.Entry<String, String> entry : mainMap.entrySet()) {
                                String key = entry.getKey();
                                String value = entry.getValue();

                                //Suma a los contadores dependiendo del tipo de la carta.
                                System.out.println("Nombre: " + key + "| Tipo: " + value);
                                if(value.equals("Monstruo")){
                                    monstruoCont ++;
                                } else if (value.equals("Trampa")){
                                    trampaContador ++;
                                } else {
                                    hechizoContador ++;
                                }
                            }

                            System.out.println("Cantidad de cartas tipo Monstruo: " + monstruoCont);
                            System.out.println("Cantidad de cartas tipo Trampa: " + trampaContador);
                            System.out.println("Cantidad de cartas tipo Hechizo: " + hechizoContador);
                        }

                        // 6. Mostrar el nombre y tipo de todas las cartas existentes ordenadas por tipo.
                        case 6: {
                            int monstruoCont = 0;
                            int trampaContador = 0;
                            int hechizoContador = 0;
                            ArrayList<Map.Entry<String, String>> monstruoType = new ArrayList<>();
                            ArrayList<Map.Entry<String, String>> hechiceroType = new ArrayList<>();
                            ArrayList<Map.Entry<String, String>> trampaType = new ArrayList<>();
                            for(Map.Entry<String, String> entry : mainMap.entrySet()) {
                                String key = entry.getKey();
                                String value = entry.getValue();

                                //Suma a los contadores dependiendo del tipo de la carta.
                                if(value.equals("Monstruo")){
                                    monstruoCont ++;
                                    monstruoType.add(entry);

                                } else if (value.equals("Trampa")){
                                    trampaContador ++;
                                    trampaType.add(entry);
                                } else {
                                    hechizoContador ++;
                                    hechiceroType.add(entry);
                                }
                            }

                            //Por cada entry en la lista de tipos Monstruo imprime el nombre y el tipo
                            for(Map.Entry<String, String> e: monstruoType){
                                System.out.println("Nombre: " + e.getKey() + "| Tipo: " + e.getValue());
                            }
                            for(Map.Entry<String, String> e: trampaType){
                                System.out.println("Nombre: " + e.getKey() + "| Tipo: " + e.getValue());
                            }
                            for(Map.Entry<String, String> e: hechiceroType){
                                System.out.println("Nombre: " + e.getKey() + "| Tipo: " + e.getValue());
                            }
                            System.out.println("Cantidad de cartas tipo Monstruo: " + monstruoCont);
                            System.out.println("Cantidad de cartas tipo Trampa: " + trampaContador);
                            System.out.println("Cantidad de cartas tipo Hechizo: " + hechizoContador);
                        }
                        case 7: {
                            wantsToContinue = false;
                            break;
                        }

                        default:
                            break;

                    }

                    break;
                }

                case 2: {
                    wantsToContinue = false;
                    break;
                }
            }

        } while (wantsToContinue);

    }
}

