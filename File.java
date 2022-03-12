
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File {

    public File(String s) {

    }
    public class ReadFile {
        public static void main(String[] args) {
            try {
                File archivo = new File("cards_desc.txt");
                Scanner myReader = new Scanner(archivo);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}
