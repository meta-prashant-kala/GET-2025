public class LinkedList{
    Node head=null;
    Node tail=null;



    public boolean insertNode(int val){
        Node node=new Node(val);
        if(tail==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
        return true;
    }

    public Node reverseLinkedList(Node startNode){
        Node prevNode=null;
        Node currNode=startNode;
        Node nextNode=startNode;
        while (currNode!=null) {
            currNode=nextNode.next;
            nextNode.next=prevNode;
            prevNode=nextNode;
            nextNode=currNode;
        }
        return nextNode;
    }

    public boolean isLoop(){
        Node slow=this.head;
        Node fast=this.tail;
        while (fast.next !=null && slow!=fast) {
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow==fast){
            return true;
        }
        return false;
    }

    public void rotateSublist(int left, int right, int n){
        Node linkListIterator=this.head;
        Node leftListStart=null;
        Node leftListEnd=null;
        Node midListEnd=null;
        Node rightListStart=null;
        Node headNode=new Node(-1);
        while (linkListIterator!=null) {
            if(left==2 && n!=-1){
                headNode=linkListIterator;
            }
            if(left==1 && n!=-1){
                leftListStart=linkListIterator;
                left=n;
                n=-1;
            }
            if(left==1 && n==-1){
                leftListEnd=linkListIterator;
                left=0;
            }
            if(right==1){
                midListEnd=linkListIterator;
                rightListStart=linkListIterator.next;
                right=0;
            }
            if(left>1){
                left--;
            }
            if(right>1){
                right --;
            }
            if(right==0 && left==0){
                break;
            }
            linkListIterator=linkListIterator.next;
        }

        headNode.next=leftListEnd.next;
        midListEnd.next=leftListStart;
        leftListEnd.next=rightListStart;
    }

    public void displayLinkedList(){
        Node linkedListIterator=this.head;
        while (linkedListIterator!=null) {
            System.out.print(linkedListIterator.data+" -> ");
            linkedListIterator=linkedListIterator.next;
        }
    
    }


}