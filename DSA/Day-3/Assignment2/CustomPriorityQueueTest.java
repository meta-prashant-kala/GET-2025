package Assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomPriorityQueueTest {
    PriorityQueue<Integer> priorityQueue;

    @BeforeEach
    void setUp() {
        priorityQueue = new CustomPriorityQueue<>(5);
    }

    @Test
    void isEmpty() {
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    void peek() {
        priorityQueue.push(10);
        priorityQueue.push(30);
        priorityQueue.push(20);
        assertEquals(30, priorityQueue.peek());
    }

    @Test
    void isFull() {
        priorityQueue.push(10);
        priorityQueue.push(20);
        priorityQueue.push(30);
        priorityQueue.push(40);
        priorityQueue.push(50);
        assertTrue(priorityQueue.isFull());
    }

    @Test
    void pop() {
        priorityQueue.push(15);
        priorityQueue.push(25);
        priorityQueue.push(5);
        assertEquals(25, priorityQueue.pop());
        assertEquals(15, priorityQueue.pop());
    }

    @Test
    void isFullCheck() {
        priorityQueue.push(10);
        priorityQueue.push(20);
        priorityQueue.push(30);
        priorityQueue.push(40);
        priorityQueue.push(50);
        assertFalse(priorityQueue.push(60));
    }

    @Test
    void emptyQueuePop() {
        Exception exception = assertThrows(IllegalArgumentException.class, priorityQueue::pop);
        assertEquals("Queue is empty", exception.getMessage());
    }
}