public class LinkedList {
    Node head;
    Node tail;

    public Node getHead() {
        return head;
    }

    /**
     * Method to add a node to the linked list
     * 
     * @param employee should be of Employee type
     * @return true if added successfully, otherwise false
     */
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

    /**
     * Method to sort the Linked list of employees based on there salary and if
     * salary is equal then sort on the bases of age
     * 
     * @return true after sorting the linked list
     */
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

    /**
     * Method to display the Linked list
     */
    public void displayLinkedList() {
        Node linekedListIterator = head;
        while (linekedListIterator != null) {
            System.out.print(linekedListIterator.employeeData.salary + " -> ");
            linekedListIterator = linekedListIterator.next;
        }
    }
}
