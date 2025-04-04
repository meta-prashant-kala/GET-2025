package Assignment3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircularQueueTest {

    @Test
    public void isEmpty() {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isFull() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertTrue(queue.isFull());
    }

    @Test
    public void push() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        assertTrue(queue.push(1));
        assertTrue(queue.push(2));
        assertTrue(queue.push(3));
        assertFalse(queue.push(4));
    }

    @Test
    public void pop() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertTrue(queue.pop());
        assertTrue(queue.pop());
        assertTrue(queue.pop());
        assertFalse(queue.pop());
    }

    @Test
    public void peek() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.push(1);
        queue.push(2);

        assertEquals(1, queue.peek());
        queue.pop();
        assertEquals(2, queue.peek());
    }

    @Test
    public void circularBehavior() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop(); 
        queue.push(4); 

        assertEquals(2, queue.peek());
        queue.pop();
        assertEquals(3, queue.peek());
    }
}