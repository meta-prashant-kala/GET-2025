public class CustomPriorityQueue implements PriorityQueue {
    int[] queue;

    int front;
    int rear;

    /**
     * Constructor to initialise a Circular queue
     * 
     * @param size
     */
    public CustomPriorityQueue(int size) {
        queue = new int[size+1];
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
    public boolean push(int val) {
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
     * @return true if the element at the front is poped, otherwise false
     */
    public int pop() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        } else {
            int val = queue[front];
            queue[front] = queue[rear];
            rear--;
            if (rear == front ) {
                front = 0;
                rear = 0;
            }
            sortFromRoot(front);
            return val;
        }
    };

    /**
     * Method to get the front element of the queue
     * 
     * @return front element of the queue
     */
    public int peek() {
        int peek = queue[front];
        return peek;
    }

    void sortFromLeaf(int childIndex) {
        int parentIndex = childIndex / 2;
        if (childIndex <= front || queue[parentIndex] >= queue[childIndex]) {
            return;
        }
        int temp = queue[childIndex];
        queue[childIndex] = queue[parentIndex];
        queue[parentIndex] = temp;
        sortFromLeaf(parentIndex);
    }

    void sortFromRoot(int parentIndex){
        if(parentIndex >= rear){
            return;
        }
        int leftChildIndex=2*parentIndex;
        int rightChildIndex=2*parentIndex+1;
        if(leftChildIndex<=rear && queue[leftChildIndex]>queue[rightChildIndex]){
            int temp=queue[leftChildIndex];
            queue[leftChildIndex]=queue[parentIndex];
            queue[parentIndex]=temp;
            sortFromRoot(leftChildIndex);
        }
        else if(rightChildIndex<=rear){
            int temp=queue[rightChildIndex];
            queue[rightChildIndex]=queue[parentIndex];
            queue[parentIndex]=temp;
            sortFromRoot(rightChildIndex);
        }
    }

    public void displayQueue() {
        int left = front;
        while (left <= rear) {
            System.out.print(left+"->> ");
            System.out.println(queue[left]);
            left++;
        }
    }

}