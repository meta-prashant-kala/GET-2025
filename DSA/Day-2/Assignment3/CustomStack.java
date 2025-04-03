public class CustomStack<T> implements Stack<T> {

    int top = -1;
    Object[] customStack;

    /**
     * Constructor to initialise the stack
     * 
     * @param size should be of int type to declare the size of the stack
     */
    public CustomStack(int size) {
        customStack = new Object[size];
    }

    /**
     * Method to check if a stack is empty or not
     * 
     * @return true if the stack is empty otherwise false
     */
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if a stack is full or not
     * 
     * @return true if the stack is full otherwise false
     */
    public boolean isFull() {
        if (top + 1 >= this.customStack.length) {
            return true;
        }
        return false;
    }

    /**
     * Method to push a value in the stack
     * 
     * @return true if the value is inserted succesfully otherwise false
     */
    public boolean push(T val) {
        if (this.isFull()) {
            throw new IllegalStateException("Stack is full.");
        }
        top++;
        customStack[top] = val;
        return true;
    }

    /**
     * Method to pop a value from the stack
     * 
     * @return the value on the top and pops it from the stack
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        @SuppressWarnings("unchecked")
        T val = (T) customStack[top];
        top--;
        return val;
    }

    /**
     * Method to get the top value of the stack
     * 
     * @return the value at the top of the stack
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) customStack[top];
    }
}
