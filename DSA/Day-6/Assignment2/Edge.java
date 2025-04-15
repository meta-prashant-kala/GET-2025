package Assignment2;

public class Edge<V> {
    V source;
    V destination;
    int weight;

    public Edge(V source, V destination, int weight){
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }

    public V getSource() {
        return source;
    }
    public V getDestination() {
        return destination;
    }
    public int getWeight() {
        return weight;
    }
}
