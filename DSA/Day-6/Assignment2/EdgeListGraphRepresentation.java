package Assignment2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Node;

import Assignment1.UndirectedGraph;

public class EdgeListGraphRepresentation<V> implements UndirectedGraph <V> {

    Set<V> verteces;
    List<Edge<V>> edgesList;

    public EdgeListGraphRepresentation(){
        verteces=new HashSet<>();
        edgesList=new ArrayList<>();   
    }

    public boolean addToGraph(V source, V destination, int weight){
        Edge<V> edgeObj=new Edge<V>(source, destination, weight);
        edgesList.add(edgeObj);
        return true;
    }

    public void helperForIsConnected(V vertex, Set<V> visited){
        if(visited.contains(vertex)){
            return ;
        }
        for(Edge<V> edge: edgesList ){
            if(edge.source==vertex){
                visited.add(edge.source);
                helperForIsConnected(edge.destination, visited);
            } else if(edge.destination==vertex){
                visited.add(edge.destination);
                helperForIsConnected(edge.source, visited);
            }
        }
    }

    public boolean isConnected() {
        Set<V> visited=new HashSet<>();
        V vertex=verteces.iterator().next();
        helperForIsConnected(vertex, visited);
        if(visited.size()!=verteces.size()){
            return false;
        }
        return true;
    }


    public void helperForReachable(V vertex, Set<V> visited, List<V> reachableVertexList){
        if(visited.contains(vertex)){
            return ;
        }
        for(Edge<V> edge: edgesList ){
            if(edge.source==vertex){
                visited.add(edge.source);
                reachableVertexList.add(edge.source);
                helperForReachable(edge.destination, visited, reachableVertexList);
            } else if(edge.destination==vertex){
                visited.add(edge.destination);
                reachableVertexList.add(edge.destination);
                helperForReachable(edge.source, visited, reachableVertexList);
            }
        }
    }

    public List<V> reachable(V vertex) {
        List<V> reachableVertexList = new ArrayList<>();
        Set<V> visited=new HashSet<>();
        helperForReachable(vertex, visited, reachableVertexList);
        return reachableVertexList;
    };

    public int mst() {
        return 1;
    };

    public int shortestPath(Node a, Node b) {
        return 1;
    };

}