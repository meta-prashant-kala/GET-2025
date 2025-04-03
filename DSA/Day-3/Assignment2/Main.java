public class Main {
    public static void main(String [] args){
        PriorityQueue priorityQueue=new CustomPriorityQueue(5);
        priorityQueue.push(3);
        priorityQueue.push(9);
        priorityQueue.push(6);
        priorityQueue.push(27);
        priorityQueue.push(12);
        // priorityQueue.pop();
        // System.out.println(priorityQueue.push(6));
        priorityQueue.displayQueue();
    }
}
