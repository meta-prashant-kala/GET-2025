package Assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

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

        Set<String> reachableFromA = graph.reachable("A");
        assertTrue(reachableFromA.contains("B"));
        assertTrue(reachableFromA.contains("C"));
        assertTrue(reachableFromA.contains("D"));
    }

    @Test
    public void testShortestPath() {
        EdgeListGraphRepresentation<String> graph = new EdgeListGraphRepresentation<>();
        graph.addToGraph("A", "B", 5);
        graph.addToGraph("B", "C", 3);
        graph.addToGraph("A", "C", 10);

        List<String> path = graph.shortestPath("A", "C");
        assertEquals(List.of("A", "B", "C"), path);
    }

    @Test
    public void testMst() {
        EdgeListGraphRepresentation<String> graph = new EdgeListGraphRepresentation<>();
        graph.addToGraph("A", "B", 5);
        graph.addToGraph("B", "C", 3);
        graph.addToGraph("A", "C", 10);

        List<Edge<String>> mstList = graph.mst();
        assertEquals(2, mstList.size());
        Edge<String> e1 = mstList.get(0);
        Edge<String> e2 = mstList.get(1);
        assertEquals(e1.source, "B");
        assertEquals(e1.destination, "C");
        assertEquals(e2.source, "A");
        assertEquals(e2.destination, "B");
    }

}