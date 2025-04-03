package Assignment3;

public class CircularQueue<T> implements Queue<T> {
    Object[] queue;

    int front;
    int rear;


    /**
     * Constructor to initialise a Circular queue
     * @param size
     */
    public CircularQueue(int size) {
        queue = new Object[size];
        front = -1;
        rear = 0;
    }

    /**
     * Method to check if a queue is full or not
     * @return true if queue is full, otherwise false
     */
    public boolean isFull() {
        if (rear == front) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if a queue is empty or not
     * @return true if queue is empty, otherwise false
     */
    public boolean isEmpty() {
        if (front == -1 && rear == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to push a value to the queue if the queue is not full
     * @return if the value is pushed succesfully, otherwise false
     */
    public boolean push(T val) {
        if (!this.isFull()) {
            queue[rear] = val;
            rear = ((rear + 1) % queue.length);
            if (front == -1) {
                front++;
            }
            return true;
        } 
        return false;
    }

    /**
     * Method to pop out the front value of a queue if the queue is not empty;
     * @return true if the element at the front is poped, otherwise false
     */
    public boolean pop() {
        if (front == -1) {
            return false;
        } else {
            front = ((front + 1) % queue.length);
            if (front == rear) {
                front = -1;
                rear = 0;
            }
            return true;
        }
    };

    /**
     * Method to get the front element of the queue
     * @return front element of the queue
     */
    public T peek() {
        @SuppressWarnings("unchecked")
        T peek = (T) queue[front];
        return peek;
    }
}
