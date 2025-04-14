public class Pair<K extends Comparable<K>, V> implements Comparable<Pair<K, V>> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Pair<K, V> secondPairObj) {
        return this.getKey().compareTo(secondPairObj.getKey());
    }

    @Override
    public String toString() {
        return (this.getKey() + " : " + this.getValue());
    }
}
