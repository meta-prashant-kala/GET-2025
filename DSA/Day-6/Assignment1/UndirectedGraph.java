package Assignment1;

import java.util.List;

import org.w3c.dom.Node;

public interface UndirectedGraph <V>{
    public boolean isConnected();
    public List<V> reachable(Node a);
    public int mst();
    public int shortestPath(Node a,Node b);
} 
