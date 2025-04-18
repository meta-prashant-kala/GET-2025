package Assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DisjointSet<V> {
    Map<V, V> parent;
    Map<V, Integer> rank;

    /**
     * Constructor to initiate the class
     * 
     * @param verteces Set containing the verteces of the graph
     */
    public DisjointSet(Set<V> verteces) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for (V vertex : verteces) {
            parent.put(vertex, vertex);
            rank.put(vertex, 0);
        }
    }

    /**
     * Method to create the disjoint set of the graph by holding the rank and parent
     * information of the graph
     * 
     * @param source      starting vertex
     * @param destination end vertex
     */
    public void createUnionByRank(V source, V destination) {
        V sourceParent = findParent(source);
        V destinationParent = findParent(destination);
        if (!sourceParent.equals(destinationParent)) {
            if (rank.get(sourceParent) <= rank.get(destinationParent)) {
                parent.put(sourceParent, destinationParent);
                rank.put(destinationParent, rank.get(destinationParent) + 1);
            } else {
                parent.put(destinationParent, sourceParent);
                rank.put(sourceParent, rank.get(sourceParent) + 1);
            }
        }
    }

    /**
     * Method to find the ultimate parent of a vertex by traversing the parent map
     * recurrsively
     * 
     * @param vertex holds the vertex of which ultimate parent we need to find
     * @return the ultimate parent vertex
     */
    public V findParent(V vertex) {
        if (parent.get(vertex) == vertex) {
            return vertex;
        }
        V parentVertex = findParent(parent.get(vertex));
        parent.put(vertex, parentVertex);
        return parentVertex;
    }
}
