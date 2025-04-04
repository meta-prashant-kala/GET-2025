package Assignment2;

public class CustomPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    Object[] queue;

    int front;
    int rear;

    /**
     * Constructor to initialise a queue
     * 
     * @param size
     */
    public CustomPriorityQueue(int size) {
        queue = new Object[size + 1];
        front = 0;
        rear = 0;
    }

    /**
     * Method to check if a queue is full or not
     * 
     * @return true if queue is full, otherwise false
     */
    public boolean isFull() {
        if (rear + 1 >= queue.length) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if a queue is empty or not
     * 
     * @return true if queue is empty, otherwise false
     */
    public boolean isEmpty() {
        if (front == 0 && rear == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to push a value to the queue if the queue is not full
     * 
     * @return if the value is pushed succesfully, otherwise false
     */
    public boolean push(T val) {
        if (!this.isFull()) {
            rear++;
            queue[rear] = val;
            if (front == 0) {
                front++;
            }
            sortFromLeaf(rear);
            return true;
        }
        return false;

    }

    /**
     * Method to pop out the front value of a queue if the queue is not empty;
     * 
     * @return the element from the front, otherwise throw error
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        } else {
            T val = getValueByIndex(front);
            queue[front] = queue[rear];
            rear--;
            sortFromRoot(front);
            if(rear==0){
                front=0;
            }
            return val;
        }
    };

    /**
     * Method to get the front element of the queue
     * 
     * @return front element of the queue
     */
    public T peek() {
        T peek = getValueByIndex(front);
        return peek;
    }

    /**
     * Method to get the value at the given index from the queue
     * @param index should be of int type
     * @return value present at the index of queue
     */
    @SuppressWarnings("unchecked")
    public T getValueByIndex(int index) {
        return (T) queue[index];
    }


    /**
     * Method to sort the queue from the bottom using the heap sort algorithm 
     * @param childIndex should be of int type
     */
    void sortFromLeaf(int childIndex) {
        int parentIndex = childIndex / 2;
        if (childIndex <= front || getValueByIndex(parentIndex).compareTo(getValueByIndex(childIndex)) >= 0) {
            return;
        }
        T temp = getValueByIndex(childIndex);
        queue[childIndex] = queue[parentIndex];
        queue[parentIndex] = temp;
        sortFromLeaf(parentIndex);
    }


    /**
     * Method to sort the queue from the top node using heap sort algorithm
     * @param parentIndex should be of int type
     */
    void sortFromRoot(int parentIndex) {
        if (parentIndex >= rear) {
            return;
        }
        int leftChildIndex = 2 * parentIndex;
        int rightChildIndex = 2 * parentIndex + 1;
        if (leftChildIndex <= rear && getValueByIndex(leftChildIndex).compareTo(getValueByIndex(rightChildIndex)) > 0) {
            T temp = getValueByIndex(leftChildIndex);
            queue[leftChildIndex] = queue[parentIndex];
            queue[parentIndex] = temp;
            sortFromRoot(leftChildIndex);
        } else if (rightChildIndex <= rear) {
            T temp = getValueByIndex(rightChildIndex);
            queue[rightChildIndex] = queue[parentIndex];
            queue[parentIndex] = temp;
            sortFromRoot(rightChildIndex);
        }
    }


    /**
     * Method to display the queue
     */
    public void displayQueue() {
        int left = front;
        while (left <= rear) {
            System.out.print(left + "->> ");
            System.out.println(queue[left]);
            left++;
        }
    }

}