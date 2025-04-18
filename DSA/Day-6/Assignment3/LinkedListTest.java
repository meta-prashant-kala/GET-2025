import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void addNode() {
        LinkedList linkedList = new LinkedList();

        Employee emp1 = new Employee("Alice", 50000, 25);
        Employee emp2 = new Employee("Bob", 60000, 30);

        linkedList.addNode(emp1);
        linkedList.addNode(emp2);

        assertEquals(emp1, linkedList.getHead().employeeData);
        assertEquals(emp2, linkedList.getHead().next.employeeData);
    }

    @Test
    public void sort() {
        LinkedList linkedList = new LinkedList();

        Employee emp1 = new Employee("Alice", 50000, 25);
        Employee emp2 = new Employee("Bob", 60000, 30);
        Employee emp3 = new Employee("Charlie", 45000, 28);
        Employee emp4 = new Employee("Diana", 60000, 24);

        linkedList.addNode(emp1);
        linkedList.addNode(emp2);
        linkedList.addNode(emp3);
        linkedList.addNode(emp4);

        linkedList.quickSort();

        assertEquals(linkedList.head.employeeData.name, "Diana");
        assertEquals(linkedList.head.next.employeeData.name, "Bob");
        assertEquals(linkedList.head.next.next.employeeData.name, "Alice");
        assertEquals(linkedList.head.next.next.next.employeeData.name, "Charlie");
    }

}