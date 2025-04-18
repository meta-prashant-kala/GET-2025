package Assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import Assignment1.UndirectedGraph;

public class EdgeListGraphRepresentation<V> implements UndirectedGraph<V> {

    Set<V> verteces;
    List<Edge<V>> edgesList;

    /**
     * Constructor to initialise the class
     */
    public EdgeListGraphRepresentation() {
        verteces = new HashSet<>();
        edgesList = new ArrayList<>();
    }

    /**
     * Method to add an edge having vertex type of V to the graph
     * 
     * @param source      is the starting vertex
     * @param destination is the ending vertex
     * @param weight      is the wight of the edge
     * @return true if the edge is added succesfully
     */
    public boolean addToGraph(V source, V destination, int weight) {
        Edge<V> edgeObj = new Edge<V>(source, destination, weight);
        if (!verteces.contains(source)) {
            verteces.add(source);
        }
        if (!verteces.contains(destination)) {
            verteces.add(destination);
        }
        edgesList.add(edgeObj);
        return true;
    }

    // Helper method to isConnected method to excute the Depth first traversal
    private void helperForIsConnected(V vertex, Set<V> visited) {
        if (visited.contains(vertex)) {
            return;
        }
        for (Edge<V> edge : edgesList) {
            if (edge.source == vertex) {
                visited.add(edge.source);
                helperForIsConnected(edge.destination, visited);
            } else if (edge.destination == vertex) {
                visited.add(edge.destination);
                helperForIsConnected(edge.source, visited);
            }
        }
    }

    /**
     * Method to check if the graph is connected or not. The method performs the dfs
     * traversal and includes the vertex in the set and then checks if the size of
     * the verteces array and set size are equal or not
     * 
     * @return trur if the graph is connected, otherwise false
     */
    public boolean isConnected() {
        Set<V> visited = new HashSet<>();
        V vertex = verteces.iterator().next();
        helperForIsConnected(vertex, visited);
        if (visited.size() != verteces.size()) {
            return false;
        }
        return true;
    }

    // Helper Method to perform the dfs traversal for the rechable method
    private void helperForReachable(V vertex, Set<V> visited) {
        if (visited.contains(vertex)) {
            return;
        }
        // System.out.println("I am done");
        for (Edge<V> edge : edgesList) {
            if (edge.source.equals(vertex)) {
                visited.add(edge.source);
                helperForReachable(edge.destination, visited);
            } else if (edge.destination.equals(vertex)) {
                visited.add(edge.destination);
                helperForReachable(edge.source, visited);
            }
        }
    }

    /**
     * Method to get the list of nodes reachable form the input vertex.
     * 
     * @param vertex starting vertex of the graph.
     * @return List of vertex that are reachable from starting vertex.
     */
    public Set<V> reachable(V vertex) {
        // List<V> reachableVertexList = new ArrayList<>();
        Set<V> visited = new HashSet<>();
        helperForReachable(vertex, visited);
        return visited;
    };

    /**
     * Method to find the shortest path from the source vertex to destination vertex
     * 
     * @param source      starting vertex of the graph
     * @param destination vertex user wants to reach
     * @return the list containing the shortest path from the source to destination
     */
    public List<V> shortestPath(V source, V destination) {
        Map<V, Integer> distance = new HashMap<>();
        Map<V, V> predecesor = new HashMap<>();
        Set<V> visited = new HashSet<>();
        PriorityQueue<V> queue = new PriorityQueue<V>();
        LinkedList<V> pathList = new LinkedList<>();
        for (V vertex : verteces) {
            distance.put(vertex, Integer.MAX_VALUE);
        }
        queue.add(source);
        distance.put(source, 0);

        while (!queue.isEmpty()) {
            V currVertex = queue.poll();
            if (visited.contains(currVertex)) {
                continue;
            }
            visited.add(currVertex);
            for (Edge<V> edge : edgesList) {
                if (edge.source.equals(currVertex)) {
                    if (!visited.contains(edge.destination)) {
                        queue.add(edge.destination);
                    }
                    int currWeight = edge.weight + distance.get(currVertex);
                    if (currWeight < distance.get(edge.destination)) {
                        distance.put(edge.destination, currWeight);
                        predecesor.put(edge.destination, currVertex);
                    }
                } else if (edge.destination.equals(currVertex)) {
                    if (!visited.contains(edge.source)) {
                        queue.add(edge.source);
                    }
                    int currWeight = edge.weight + distance.get(currVertex);
                    if (currWeight < distance.get(edge.source)) {
                        distance.put(edge.source, currWeight);
                        predecesor.put(edge.source, currVertex);
                    }
                }
            }

        }

        V step = destination;
        if (predecesor.get(step) == null && !source.equals(destination)) {
            return Collections.emptyList();
        }
        while (step != null) {
            pathList.addFirst(step);
            step = predecesor.get(step);

        }
        return pathList;
    }

    /**
     * Method to get the verteces in the minimum spannig tree
     * 
     * @return list holding the verteces in the minimum spanning tree
     */
    public List<Edge<V>> mst() {
        Collections.sort(edgesList);
        DisjointSet<V> disjointSet = new DisjointSet<V>(verteces);
        List<Edge<V>> mstPath = new ArrayList<>();
        for (Edge<V> edge : edgesList) {

            V ultimateParentSource = disjointSet.findParent(edge.source);

            V ultimateParentDestination = disjointSet.findParent(edge.destination);

            if (!ultimateParentSource.equals(ultimateParentDestination)) {
                disjointSet.createUnionByRank(edge.source, edge.destination);
                mstPath.add(edge);
            }
        }
        return mstPath;
    }

}
