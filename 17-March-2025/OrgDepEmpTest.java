
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import employees.Designer;
import employees.Developer;
import employees.Employee;
import employees.HR;
import employees.HRManager;

public class OrgDepEmpTest {
    @Test
    public void getBasicSalary() {
        Employee emp1 = new Developer("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee emp3 = new HR("Piyush", "HR");
        Employee emp4 = new HRManager("Pawan", "HRManager");

        assertEquals(10000, emp1.getBasicSalary());
        assertEquals(8000, emp2.getBasicSalary());
        assertEquals(4000, emp3.getBasicSalary());
        assertEquals(6000, emp4.getBasicSalary());
    }

    @Test
    public void getBonus() {
        Employee emp1 = new Developer("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee emp3 = new HR("Piyush", "HR");
        Employee emp4 = new HRManager("Pawan", "HRManager");

        assertEquals(500, emp1.getBonus());
        assertEquals(400, emp2.getBonus());
        assertEquals(200, emp3.getBonus());
        assertEquals(300, emp4.getBonus());
    }

    @Test
    public void getCompensation() {
        Employee emp1 = new Developer("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee emp3 = new HR("Piyush", "HR");
        Employee emp4 = new HRManager("Pawan", "HRManager");

        assertEquals(400, emp1.getCompensation());
        assertEquals(200, emp2.getCompensation());
        assertEquals(100, emp3.getCompensation());
        assertEquals(200, emp4.getCompensation());
    }

    @Test
    public void getRole() {
        Employee emp1 = new Developer("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee emp3 = new HR("Piyush", "HR");
        Employee emp4 = new HRManager("Pawan", "HRManager");

        assertEquals("Developer", emp1.getRole());
        assertEquals("Designer", emp2.getRole());
        assertEquals("HR", emp3.getRole());
        assertEquals("HRManager", emp4.getRole());
    }

    @Test
    public void joinEmployee() {
        Department dep1 = new Department("IT-Deparment");
        Department dep2 = new Department("HR-Deparment");

        Employee emp1 = new Developer("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee emp3 = new HR("Piyush", "HR");
        Employee emp4 = new HRManager("Pawan", "HRManager");
        
        assertEquals(true, dep1.join(emp1));
        assertEquals(true, dep1.join(emp2));
        assertEquals(true, dep2.join(emp3));
        assertEquals(true, dep2.join(emp4));
    }

    @Test
    public void relieveEmployeeTest1() {
        Department dep1 = new Department("IT-Deparment");
        Department dep2 = new Department("HR-Deparment");
        Employee emp1 = new Developer("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee emp3 = new HR("Piyush", "HR");
        Employee emp4 = new HRManager("Pawan", "HRManager");
        dep1.join(emp1);
        dep1.join(emp2);
        dep2.join(emp3);
        dep2.join(emp4);
        assertEquals(true, dep1.relieve(emp1));
        assertEquals(true, dep1.relieve(emp2));
        assertEquals(true, dep2.relieve(emp3));
        assertEquals(true, dep2.relieve(emp4));
    }

    @Test
    public void addDepartment() {
        Organization orgObj = new Organization("metacube");
        Department dep1 = new Department("IT-Deparment");
        Department dep2 = new Department("HR-Deparment");

        assertEquals(true, orgObj.addDepartment(dep1));
        assertEquals(true, orgObj.addDepartment(dep2));
    }

    @Test
    public void isRoleAvailable() {
        Organization orgObj = new Organization("metacube");
        assertEquals(true, orgObj.isRoleAvailable("Developer"));
        assertEquals(true, orgObj.isRoleAvailable("Designer"));
        assertEquals(false, orgObj.isRoleAvailable("Admin"));
        assertEquals(false, orgObj.isRoleAvailable("Sweeper"));
    }

    @Test
    public void getAllEmployees() {
        Employee emp1 = new Developer("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee emp3 = new HR("Piyush", "HR");
        Employee emp4 = new HRManager("Pawan", "HRManager");

        Department dep1 = new Department("IT-Deparment");
        Department dep2 = new Department("HR-Deparment");

        dep1.join(emp1);
        dep1.join(emp2);
        dep2.join(emp3);
        dep2.join(emp4);

        Organization orgObj = new Organization("metacube");
        orgObj.addDepartment(dep1);
        orgObj.addDepartment(dep2);
        Employee[] employeesList = { emp1, emp2, emp3, emp4 };
        List<Employee> allEmployeeList = Arrays.asList(employeesList);

        assertEquals(allEmployeeList, orgObj.getAllEmployees());

    }

    @Test
    public void getEmployees() {
        Employee emp1 = new Developer("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee emp3 = new HR("Piyush", "HR");
        Employee emp4 = new HRManager("Pawan", "HRManager");

        Department dep1 = new Department("IT-Deparment");
        Department dep2 = new Department("HR-Deparment");

        dep1.join(emp1);
        dep1.join(emp2);
        dep2.join(emp3);
        dep2.join(emp4);

        Employee[] employeesArray1 = { emp1, emp2 };
        Employee[] employeesArray2 = { emp3, emp4 };
        List<Employee> expectedEmployeeList1 = Arrays.asList(employeesArray1);
        List<Employee> expectedEmployeeList2 = Arrays.asList(employeesArray2);

        assertEquals(expectedEmployeeList1, dep1.getEmployees());
        assertEquals(expectedEmployeeList2, dep2.getEmployees());
    }

    @Test
    public void createEmployee() {
        Organization orgObj = new Organization("metacube");
        Employee emp1 = new Developer("Prashant", "Developer");
        Employee expectedEmp1 = orgObj.createEmployee("Prashant", "Developer");
        Employee emp2 = new Designer("Palash", "Designer");
        Employee expectedEmp2 = orgObj.createEmployee("Palash", "Designer");
        Employee emp3 = null;
        Employee expectedEmp3 = orgObj.createEmployee("Piyush", "Admin");

        assertEquals(emp1, expectedEmp1);
        assertEquals(emp2, expectedEmp2);
        assertEquals(emp3, expectedEmp3);
    }

}
