public class Factory {

    public Factory()
    {

    }

    public Map<String,String> NewMap(int type)
    {
        switch(type)
        {
            case 1:
                return new HashMap<String, String>();
            case 2:
                return new TreeMap<String,String>();
            case 3:
                return new LinkedHashMap<String, String>();
        }
    }
}
