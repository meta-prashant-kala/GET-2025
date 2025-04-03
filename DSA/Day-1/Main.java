public class Main {
    public static void main(String [] args){

        LinkedList linkedListObj=new LinkedList();
        linkedListObj.insertNode(2);
        linkedListObj.insertNode(3);
        linkedListObj.insertNode(4);
        linkedListObj.insertNode(5);
        linkedListObj.insertNode(6);
        linkedListObj.insertNode(7);

        
        // linkedListObj.tail.next=linkedListObj.head;
        // System.out.println(linkedListObj.isLoop());
        // linkedListObj.displayLinkedList();
        System.out.println();
        linkedListObj.rotateSublist(1, 5, 2);

        linkedListObj.displayLinkedList();

    }
}
