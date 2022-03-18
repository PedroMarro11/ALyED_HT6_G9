import java.util.Set;
import java.util.ArrayList;

public interface Map<K,V> {
    /**
     * @pre key and value are non-null
     * @post Inserts a key-value Association into the Map
     */
    public V put(K key, V value);
    /**
     * @pre Key is non-null
     *@post Obtain a Value by searching for a key
     */
    public V get(K key);

    /**
     * @pre key is non-null
     * @post removes the key-value Association
     * from the Map and returns the value
     */
    public V remove(K key);

    /**
     * @pre key is non-null
     * @post return true if the key exists within the map
     */
    public boolean containsKey(K key);

    /**
     * @pre value is non-null
     * @post returns true if the value is a value
     * of at least one key-value Association
     */
    public boolean containsValue(V value);

    /**
     * @return the size of the Map
     */
    public int size();

    /**
     * @return true if the Map has no key-value Associations
     */
    public boolean isEmpty();

    /**
     * @pre other is non-null
     * @post adds all key-value Associations from other into
     * this Map, overriding conflicting keys
     */
    public void putAll(Map<K,V> other);

    /**
     * @post removes all key-value Associations within the Map
     */
    public void clear();

    /**
     * @return a Set of all keys within the Map
     */
    public Set<K> keySet();

    /**
     * @return an ArrayList of all the values that exist
     * within the Map
     */
    public ArrayList<V> values();

    /**
     * @return a Set of all key-value Associations within the Map
     */
    public Set<Association<K,V>> entrySet();
}
