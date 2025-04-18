package Assignment1;

import java.util.List;
import java.util.Set;

import Assignment2.Edge;

public interface UndirectedGraph<V> {
    public boolean isConnected();

    public Set<V> reachable(V vertex);

    public List<Edge<V>> mst();

    public List<V> shortestPath(V source, V destination);
}
