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
        }
        return mapa;
    }
}
