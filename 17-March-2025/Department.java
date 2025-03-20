
import employees.Employee;

import java.util.List;
import java.util.ArrayList;

public class Department {

    public String departmentName;
    public List<Employee> employeeList = new ArrayList<Employee>();

    // Method to initialise an object of department
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Method To add an employee object to the employee list of department
     * 
     * @param employee should be of Employee type
     * @return true if the employee is added successfully otherwise false
     */
    public boolean join(Employee employee) {
        try {
            employeeList.add(employee);
            return true;
        } catch (Exception e) {
            System.out.println("Employee cannot be added to this department");
            return false;
        }
    }

    /**
     * Method To Remove an employee object from the employee list of department
     * 
     * @param employee should be of Employee type
     * @return true if the employee is removed successfully otherwise false
     */
    boolean relieve(Employee employee) {
        try {
            employeeList.remove(employee);
            return true;
        } catch (Exception e) {
            System.out.println("Employee cannot be removed form this department");
            return false;
        }
    }

    /**
     * Method to return the employee list of a department
     * 
     * @return List of employee
     */
    List<Employee> getEmployees() {
        return employeeList;
    }

    /**
     * Method to print all the employees of a department
     */
    public void displayEmployeeList() {
        for (Employee employee : this.employeeList) {
            System.out.print(employee.employeeName);
            System.out.print("  ->  ");
            System.out.print(employee.employeeRole);
            System.out.println();
        }
    }

}
