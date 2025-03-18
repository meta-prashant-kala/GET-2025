package departments;

import employees.Employee;
import java.util.List;
import java.util.ArrayList;

public class Department {

    public String departmentName;
    public List<Employee> employeeList = new ArrayList<Employee>();

    public Department(String departmentName) {
        this.depdepartmentName = departmentName;
    }

    public boolean join(Employee employee) {
        try {
            employeeList.add(employee);
            return true;
        } catch (Exception e) {
            System.out.println("Employee cannot be added to this department");
            return false;
        }
    }

    boolean relieve(Employee employee) {
        try {
            employeeList.remove(employee);
            return true;
        } catch (Exception e) {
            System.out.println("Employee cannot be removed form this department");
            return false;
        }
    }

    List<Employee> getEmployees() {
        return employeeList;
    }

}
