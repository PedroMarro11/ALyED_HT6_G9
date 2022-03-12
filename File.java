import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class File implements Readable {

    public File(String s) {

    }
    public class ReadFile {
        public static void main(String[] args) throws FileNotFoundException {
            File archivo = new File("cards_desc.txt");
            Scanner myReader = new Scanner(archivo);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
    }
    @Override
    public int read(CharBuffer cb) throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }
}
