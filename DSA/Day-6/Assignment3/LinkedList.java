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

    public Node getPivotNode(Node startNode) {
        if (startNode == null || startNode.next == null) {
            return startNode;
        }
        Node pivotNode = startNode;
        Node prevNode = startNode;
        Node currNode = startNode.next;
        while (currNode != null) {
            if (currNode.employeeData.salary < pivotNode.employeeData.salary
                    || (currNode.employeeData.salary > pivotNode.employeeData.salary && currNode.employeeData.age > pivotNode.employeeData.age)) {
                prevNode = prevNode.next;
                Employee tempEmployeeObj = currNode.employeeData;
                currNode.employeeData = prevNode.employeeData;
                prevNode.employeeData = tempEmployeeObj;
            }
            currNode = currNode.next;
        }
        Employee tempEmployeeObj = pivotNode.employeeData;
        startNode.employeeData = prevNode.employeeData;
        prevNode.employeeData = tempEmployeeObj;
        return prevNode;
    }

    /**
     * Method to sort the Linked list of employees based on there salary and if
     * salary is equal then sort on the bases of age
     * 
     * @return true after sorting the linked list
     */
    public void quickSort(Node startNode) {
        if (startNode == null || startNode.next == null) {
            return;
        }
        Node pivotNode = getPivotNode(startNode);
        Node prePivot = null;
        Node current = head;
        while (current != null && current != pivotNode) {
            prePivot = current;
            current = current.next;
        }
        if (prePivot != null) {
            prePivot.next = null;
            quickSort(startNode);
            prePivot.next = pivotNode;
        }
        if (pivotNode.next != null) {
            quickSort(pivotNode.next);
        }
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
