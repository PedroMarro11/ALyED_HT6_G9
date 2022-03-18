import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static void main(String[] args) throws IOException {

        //Atributo wantsToContinue que permite al usuario repetir el programa sin necesidad de salirse.
        boolean wantsToContinue = true;

        Scanner input = new Scanner(System.in);
        Map <String, String> mainMap;
        Factory factory = new Factory();
        ArrayList<String> collection = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Selección del tipo de mapa que desea usar.

        int mapType = 0;
        while(true)
        {
            System.out.println("Seleccione el número del tipo de mapa que desea: ");
            System.out.println(factoryMenu);
            String opcion = input.next();
            if(Controlador.isInt(opcion))
            {
                mapType = Integer.parseInt(opcion);
                break;
            }
        }


        switch (mapType) {
            //Definir como HashMap
            case 1: {
                mainMap = factory.NewMap(1);
                break;
            }

            //Definir como TreeMap
            case 2: {
                mainMap = factory.NewMap(2);
                break;
            }

            //Definir como LinkedHashMap
            case 3: {
                mainMap = factory.NewMap(3);
                break;
            }

            default:
                mainMap = factory.NewMap(1);
                break;
        }

        //Programa principal.
        do {
            System.out.println(mainMenu);
            String option = input.next();

            switch (option) {

                case "1": {
                    try {
                        //Lectura del archivo de texto.
                        Stream<String> lines = Files.lines(
                                Paths.get(archivo),
                                StandardCharsets.UTF_8
                        );
                        //Para cada línea del arcivo de texto separa por "|" y se almacenan los datos en el Map.
                        lines.forEach(line -> {
                            String[] parts = line.split("[|]");
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
                            //input.next();
                            String name = br.readLine();


                            if (mainMap.containsKey(name)){
                                collection.add(name);

                            } else {
                                System.out.println("Revise que el nombre de la carta esté bien escrito o que exista.");
                            }

                        }

                        // 2. Mostrar el tipo de carta.
                        case 2: {
                            System.out.println("Ingrese el nombre de la carta: ");
                            String name = br.readLine();

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
                            for(String entry : collection) {
                                String key = entry;
                                String value = mainMap.get(key);

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
                            ArrayList<String> monstruoType = new ArrayList<>();
                            ArrayList<String> hechiceroType = new ArrayList<>();
                            ArrayList<String> trampaType = new ArrayList<>();

                            for(String entry : collection) {
                                String key = entry;
                                String value = mainMap.get(key);

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

                            for(String e: monstruoType){
                                System.out.println("Nombre: " + e + "| Tipo: " + mainMap.get(e));
                            }
                            for(String e: trampaType){
                                System.out.println("Nombre: " + e + "| Tipo: " + mainMap.get(e));
                            }
                            for(String e: hechiceroType){
                                System.out.println("Nombre: " + e + "| Tipo: " + mainMap.get(e));
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
                                System.out.println("Nombre: " + key + " | Tipo: " + value);
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
                                System.out.println("Nombre: " + e.getKey() + " | Tipo: " + e.getValue());
                            }
                            for(Map.Entry<String, String> e: trampaType){
                                System.out.println("Nombre: " + e.getKey() + " | Tipo: " + e.getValue());
                            }
                            for(Map.Entry<String, String> e: hechiceroType){
                                System.out.println("Nombre: " + e.getKey() + " | Tipo: " + e.getValue());
                            }
                            System.out.println("Cantidad de cartas tipo Monstruo: " + monstruoCont);
                            System.out.println("Cantidad de cartas tipo Trampa: " + trampaContador);
                            System.out.println("Cantidad de cartas tipo Hechizo: " + hechizoContador);
                            break;
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

                case "2": {
                    wantsToContinue = false;
                    break;
                }
                default:
                    break;
            }

        } while (wantsToContinue);

    }
}

