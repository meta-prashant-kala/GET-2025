public class LinkedList {
    Node head;
    Node tail;

    public Node getHead() {
        return head;
    }

    public boolean addNode(Employee employee) {
        Node node = new Node(employee);
        if (head == null && tail == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
        return true;
    }

    public boolean sort() {
        Employee tempEmp = new Employee();
        Node headPointer = new Node(tempEmp);
        headPointer.next = head;
        Node linkedListIterator = headPointer;
        Node currNode = head.next;
        Node prevNode = head;

        while (currNode != null) {
            linkedListIterator = headPointer;
            while (linkedListIterator != null && linkedListIterator != prevNode) {

                if ((linkedListIterator.next.employeeData.salary < currNode.employeeData.salary) ||
                        ((linkedListIterator.next.employeeData.salary == currNode.employeeData.salary)
                                && linkedListIterator.next.employeeData.age > currNode.employeeData.age)) {
                    prevNode.next = currNode.next;
                    currNode.next = linkedListIterator.next;
                    linkedListIterator.next = currNode;
                    prevNode = currNode;
                    currNode = currNode.next;
                    break;
                }
                linkedListIterator = linkedListIterator.next;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        head = headPointer.next;
        return true;
    }

    public void displayLinkedList() {
        Node linekedListIterator = head;
        while (linekedListIterator != null) {
            System.out.print(linekedListIterator.employeeData.salary + " -> ");
            linekedListIterator = linekedListIterator.next;
        }
    }
}
