import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BinarySearchTreeTest {

    @Test
    public void testAddValue() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        assertTrue(tree.addValue(new Pair<>(10, "Value10")));
        assertTrue(tree.addValue(new Pair<>(5, "Value5")));
        assertTrue(tree.addValue(new Pair<>(15, "Value15")));
        assertFalse(tree.addValue(new Pair<>(10, "DuplicateValue")));
    }

    @Test
    public void testGetValue() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.addValue(new Pair<>(10, "Value10"));
        tree.addValue(new Pair<>(5, "Value5"));
        tree.addValue(new Pair<>(15, "Value15"));

        assertEquals("Value10", tree.getValue(10));
        assertEquals("Value5", tree.getValue(5));
        assertEquals("Value15", tree.getValue(15));
        assertNull(tree.getValue(20));
    }

    @Test
    public void testDeleteValue() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.addValue(new Pair<>(10, "Value10"));
        tree.addValue(new Pair<>(5, "Value5"));
        tree.addValue(new Pair<>(15, "Value15"));

        assertTrue(tree.deleteValue(10));
        assertFalse(tree.deleteValue(20));
    }

    @Test
    public void testGetSortedList() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree();
        tree.addValue(new Pair<>(10, "Value10"));
        tree.addValue(new Pair<>(5, "Value5"));
        tree.addValue(new Pair<>(15, "Value15"));

        List<Pair<Integer, String>> sortedList = tree.getSortedList();
        assertEquals(3, sortedList.size());
        assertEquals(5, sortedList.get(0).getKey());
        assertEquals(10, sortedList.get(1).getKey());
        assertEquals(15, sortedList.get(2).getKey());
    }

    @Test
    public void testGetSortedListBetweenInRange() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.addValue(new Pair<>(10, "Value10"));
        tree.addValue(new Pair<>(5, "Value5"));
        tree.addValue(new Pair<>(15, "Value15"));
        tree.addValue(new Pair<>(3, "Value3"));
        tree.addValue(new Pair<>(7, "Value7"));

        List<Pair<Integer, String>> rangeList = tree.getSortedListBetweenInRange(5, 15);
        assertEquals(4, rangeList.size());
        assertEquals(5, rangeList.get(0).getKey());
        assertEquals(7, rangeList.get(1).getKey());
        assertEquals(10, rangeList.get(2).getKey());
        assertEquals(15, rangeList.get(3).getKey());
    }
}