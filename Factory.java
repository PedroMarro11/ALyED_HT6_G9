import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Factory {

    public Factory()
    {

    }

    public Map<String,String> NewMap(int type)
    {
        Map<String, String> mapa = null;
        switch(type)
        {
            case 1:
                mapa = new HashMap<String, String>();
                System.out.println("Hola");
            case 2:
                mapa = new TreeMap<String,String>();
                System.out.println("funcion 2");
            case 3:
                mapa = new LinkedHashMap<String, String>();
                System.out.printf("funcion 3");
            case 7:
                break;
        }
        return mapa;
    }
}
