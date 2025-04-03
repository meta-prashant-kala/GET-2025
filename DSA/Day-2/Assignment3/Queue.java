package Assignment3;

public interface Queue<T> {
    public boolean isFull();

    public boolean isEmpty();

    public boolean push(T val);

    public boolean pop();

    public T peek();
}