public interface Dictionary <K extends Comparable<K>,V> {

    public boolean addValue(Pair<K, V> pairObj);
    public void deleteValue(K key);
    public V getValue(K key);
    
} 