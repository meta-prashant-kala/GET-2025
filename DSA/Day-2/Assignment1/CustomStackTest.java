package Assignment1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CustomStackTest {

    private CustomStack<Integer> stack;

    @Before
    public void initialise() {
        stack = new CustomStack<>(5); 
    }

    @Test
    public void isEmpty() {
        assertTrue( stack.isEmpty());
    }

    @Test
    public void push() {
        assertTrue( stack.push(1));
        assertFalse( stack.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void pushException() {
        for (int i = 0; i < 5; i++) {
            stack.push(i); 
        }
        stack.push(6);
    }

    @Test
    public void pop() {
        stack.push(10);
        int value = stack.pop();
        assertEquals( 10, value);
        assertTrue(stack.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void popException() {
        stack.pop();
    }

    @Test
    public void peek() {
        stack.push(20);
        int value = stack.peek();
        assertEquals(20, value);
        assertFalse( stack.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void peekException() {
        stack.peek();
    }

    @Test
    public void isFull() {
        for (int i = 0; i < 5; i++) {
            stack.push(i); 
        }
        assertTrue(stack.isFull());
    }
}