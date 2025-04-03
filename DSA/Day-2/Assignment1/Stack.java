package Assignment1;
public interface Stack<T> {
    public boolean push(T val);

    public T pop();

    public T peek();

    public boolean isEmpty();

    public boolean isFull();
}