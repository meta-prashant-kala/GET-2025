public class LinkedList {
    Node head = null;
    Node tail = null;

    public Node getHead(){
        return head;
    }

    public boolean insertNode(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return true;
    }

    public int getSize(){
        Node linkedListIterator=this.head;
        int size=0;
        while (linkedListIterator!=null) {
            size++;
            linkedListIterator=linkedListIterator.next;
        }
        return size;
    }

    public boolean isLoop() {
        Node slow = this.head;
        Node fast = this.tail;
        while (fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            return true;
        }
        return false;
    }

    public void rotateSublist(int left, int right, int n) {
        
        if(left==right){
            return;
        }
        if(right<left){
            throw new IllegalAccessError("left cannot be greater than right");
        }

        n=n%getSize();

        Node leftListStart = null;
        Node midListStart = null;
        Node midListEnd = null;
        Node rightListStart = null;
        Node linkedListIterator = this.head;
        int headNodeCheck=left;

        while (linkedListIterator != null ) {
            if (left == 2) {
                leftListStart = linkedListIterator;
                midListStart = linkedListIterator.next;
            }

            if (right == 1) {
                midListEnd = linkedListIterator;
                rightListStart = linkedListIterator.next;
            }
            left--;
            right--;
            linkedListIterator = linkedListIterator.next;
        }
        if(headNodeCheck==1){
            leftListStart=new Node(-1);
            midListStart=this.head;
        }
        while (n > 0) {

            leftListStart.next = midListStart.next;
            midListStart.next = rightListStart;
            midListEnd.next = midListStart;

            midListEnd = midListStart;
            midListStart = leftListStart.next;

            n--;
        }
        if(headNodeCheck==1){
            this.head=leftListStart.next;
        }

    }

    public void displayLinkedList() {
        Node linkedListIterator = this.head;
        while (linkedListIterator != null) {
            System.out.print(linkedListIterator.data + " -> ");
            linkedListIterator = linkedListIterator.next;
        }

    }

}