package Assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class EdgeListGraphRepresentationTest {

    @Test
    public void testAddToGraph() {
        EdgeListGraphRepresentation<String> graph = new EdgeListGraphRepresentation<>();
        assertTrue(graph.addToGraph("A", "B", 1));
        assertTrue(graph.addToGraph("B", "C", 2));
    }

    @Test
    public void testIsConnected() {
        EdgeListGraphRepresentation<String> graph = new EdgeListGraphRepresentation<>();
        graph.addToGraph("A", "B", 1);
        graph.addToGraph("B", "C", 2);
        graph.addToGraph("C", "D", 3);
        graph.addToGraph("D", "A", 4);
        
        assertTrue(graph.isConnected());
    }

    @Test
    public void testIsNotConnected() {
        EdgeListGraphRepresentation<String> graph = new EdgeListGraphRepresentation<>();
        graph.addToGraph("A", "B", 1);
        graph.addToGraph("C", "D", 2);
        
        assertFalse(graph.isConnected());
    }

    @Test
    public void testReachable() {
        EdgeListGraphRepresentation<String> graph = new EdgeListGraphRepresentation<>();
        graph.addToGraph("A", "B", 1);
        graph.addToGraph("B", "C", 2);
        graph.addToGraph("C", "D", 3);
        graph.addToGraph("D", "A", 4);

        List<String> reachableFromA = graph.reachable("A");
        assertTrue(reachableFromA.contains("B"));
        assertTrue(reachableFromA.contains("C"));
        assertTrue(reachableFromA.contains("D"));
    }

    @Test
    public void testShortestPath() {
        EdgeListGraphRepresentation<String> graph = new EdgeListGraphRepresentation<>();
        graph.addToGraph("A", "B", 1);
        graph.addToGraph("B", "C", 2);
        graph.addToGraph("C", "D", 3);
        graph.addToGraph("A", "D", 5);

        int shortestPath = graph.shortestPath("A", "D");
        assertEquals(4, shortestPath);
    }
}