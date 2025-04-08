import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class EmployeeFunctionTest {

    @Test
    public void addEmployee() {
        EmployeeFunction employeeFunction = new EmployeeFunction();

        Employee emp1 = new Employee(1, "John Doe", "123 Elm St");
        Employee emp2 = new Employee(2, "Jane Smith", "456 Oak Ave");
        Employee emp3 = new Employee(1, "John Doe Duplicate", "789 Pine Rd");

        assertTrue(employeeFunction.addEmployee(emp1));
        assertTrue(employeeFunction.addEmployee(emp2));
        assertFalse(employeeFunction.addEmployee(emp3)); 

        List<Employee> employeeList = employeeFunction.employeeList;
        assertEquals(2, employeeList.size());
        assertEquals("John Doe", employeeList.get(0).employeeName);
        assertEquals("Jane Smith", employeeList.get(1).employeeName);
    }

    @Test
    public void sortByID() {
        EmployeeFunction employeeFunction = new EmployeeFunction();

        Employee emp1 = new Employee(3, "Alice Brown", "789 Pine Rd");
        Employee emp2 = new Employee(1, "John Doe", "123 Elm St");
        Employee emp3 = new Employee(2, "Jane Smith", "456 Oak Ave");

        employeeFunction.addEmployee(emp1);
        employeeFunction.addEmployee(emp2);
        employeeFunction.addEmployee(emp3);

        employeeFunction.sortByID();

        assertEquals(1, employeeFunction.employeeList.get(0).employeeID);
        assertEquals(2, employeeFunction.employeeList.get(1).employeeID);
        assertEquals(3, employeeFunction.employeeList.get(2).employeeID);
    }

    @Test
    public void sortByName() {
        EmployeeFunction employeeFunction = new EmployeeFunction();

        Employee emp1 = new Employee(3, "Alice Brown", "789 Pine Rd");
        Employee emp2 = new Employee(1, "John Doe", "123 Elm St");
        Employee emp3 = new Employee(2, "Jane Smith", "456 Oak Ave");

        employeeFunction.addEmployee(emp1);
        employeeFunction.addEmployee(emp2);
        employeeFunction.addEmployee(emp3);

        employeeFunction.sortByName();

        assertEquals("Alice Brown", employeeFunction.employeeList.get(0).employeeName);
        assertEquals("Jane Smith", employeeFunction.employeeList.get(1).employeeName);
        assertEquals("John Doe", employeeFunction.employeeList.get(2).employeeName);
    }
}