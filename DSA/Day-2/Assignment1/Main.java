package Assignment1;

public class Main {
    public static void main(String args[]) {
        Queue<Integer> queueObj = new CircularQueue<>(5);

        queueObj.push(1);
        queueObj.push(2);
        queueObj.push(3);
        queueObj.push(4);
        queueObj.push(5);
        queueObj.pop();
        queueObj.pop();
        queueObj.pop();
        queueObj.pop();
        queueObj.pop();
        if (!queueObj.pop()) {
            System.out.println("Empty-1");
        }

        if (queueObj.isEmpty()) {
            System.out.println("Empty");
        }
        while (!queueObj.isEmpty()) {
            System.out.println(queueObj.peek());
            queueObj.pop();
        }
    }
}
