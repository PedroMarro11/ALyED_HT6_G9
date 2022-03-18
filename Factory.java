/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 6
 * @author Diana Díaz 21066
 * @author Pedro Marroquín 21801
 * @version 1.0 17/03/2022
 */
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
            case 2:
                mapa = new TreeMap<String,String>();
            case 3:
                mapa = new LinkedHashMap<String, String>();
            case 7:
                break;
        }
        return mapa;
    }
}
