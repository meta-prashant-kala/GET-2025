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

    // Helper method to get the pivot index for the quick sort method
    public Node getPivotNode(Node start, Node end) {
        if (start == null || start == end) {
            return start;
        }
        Employee pivotNode = start.employeeData;
        Node left = start;
        Node right = start.next;
        while (right != end.next) {
            if (right!=null && right.employeeData.compareTo(pivotNode) > 0) {
                left = left.next;
                Employee tempEmployeeObj = left.employeeData;
                left.employeeData = right.employeeData;
                right.employeeData = tempEmployeeObj;
            }
            right = right.next;
        }
        Employee tempEmployeeObj = start.employeeData;
        start.employeeData = left.employeeData;
        left.employeeData = tempEmployeeObj;
        return left;
    }

    /**
     * Method to sort the Linked list of employees based on there salary and if
     * salary is equal then sort on the bases of age using quick sort
     * 
     * @return true after sorting the linked list
     */
    public void quickSortHelper(Node startNode, Node endNode) {
        if (startNode == null || endNode == null || startNode==endNode || startNode.next==endNode) {
            return;
        }
        Node pivotNode = getPivotNode(startNode,endNode);
        quickSortHelper(startNode, pivotNode);
        quickSortHelper(pivotNode.next, endNode);
        
    }

    /**
     * Calling quick sort
     */
    public void quickSort(){
        quickSortHelper(head, tail);
    }

    /**
     * Method to display the Linked list
     */
    public void displayLinkedList() {
        Node linekedListIterator = head;
        while (linekedListIterator != null) {
            System.out.print(linekedListIterator.employeeData.name + " -> ");
            System.out.print(linekedListIterator.employeeData.salary + " -> ");
            System.out.print(linekedListIterator.employeeData.age );
            System.out.println();
            linekedListIterator = linekedListIterator.next;
        }
    }
}
