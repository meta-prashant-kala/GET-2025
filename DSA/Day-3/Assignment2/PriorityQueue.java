package Assignment2;

public interface PriorityQueue <T extends Comparable<T>> {
    public boolean isEmpty();
    public boolean isFull();
    public T pop();
    public boolean push(T val);
    public T peek();
    public void displayQueue();
} 