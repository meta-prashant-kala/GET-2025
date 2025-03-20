import java.util.ArrayList;
import java.util.List;

import employees.Designer;
import employees.Developer;
import employees.Employee;
import employees.HR;
import employees.HRManager;
import util.Util;

public class Organization {

    public List<Department> departmentList = new ArrayList<Department>();
    public String[] rolesArray = { "Designer", "Developer", "HR", "HRManager" };
    public String organisationName;

    /**
     * Constructor to initialise Oraganisation object
     * 
     * @param orgName should be of String type
     */
    public Organization(String orgName) {
        this.organisationName = orgName;
    }

    /**
     * Method to print all the roles available in the organisation
     */
    public void displayRoles() {
        for (String role : this.rolesArray) {
            System.out.println("-> " + role);
        }
    }

    /**
     * Method to check if a role is available in the the roles array of organisation
     * 
     * @param selectedRole input role by the user of string type
     * @return true if role is available, false if role is not available
     */
    public boolean isRoleAvailable(String selectedRole) {
        for (String role : rolesArray) {
            if (Util.isStringEqual(selectedRole, role)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to add a Department to the department list
     * 
     * @param department should be of type Department
     * @return true if the department added succesfully, false if not added
     */
    boolean addDepartment(Department department) {
        try {
            departmentList.add(department);
            return true;
        } catch (Exception e) {
            System.out.println("Cannot add this department");
            return false;
        }
    }

    /**
     * Method to display all the departments in an organisation
     */
    public void displayAllDepartments() {
        System.out.println(" --------------------Available Departments-------------------- ");
        for (Department department : departmentList) {
            System.out.println(department.departmentName);
        }
    }

    /**
     * Method to get the list of all the employees in an organisation regardless
     * there department
     * 
     * @return the list of all the employees
     */
    List<Employee> getAllEmployees() {
        List<Employee> allEmployeesList = new ArrayList<Employee>();
        for (Department department : departmentList) {
            for (Employee employee : department.employeeList) {
                allEmployeesList.add(employee);
            }
        }
        return allEmployeesList;
    }

    public void displayAllEmployees() {

    }

    /**
     * Method to get the employee if he/she exsist in the all employee list
     * 
     * @param empName should be of String type
     * @return employee object if the empName exist in the employee list otherwise
     *         null
     */
    Employee getEmployee(String empName) {
        List<Employee> allEmployeesList = this.getAllEmployees();
        for (Employee employee : allEmployeesList) {
            if (Util.isStringEqual(empName, employee.employeeName)) {
                return employee;
            }

        }
        return null;
    }

    /**
     * Method to get the department if it exsist in the department list
     * 
     * @param depName should be of String type
     * @return Department object if the depName exist in the department list
     *         otherwise
     *         null
     */
    Department getDepartment(String depName) {
        for (Department department : this.departmentList) {
            if (Util.isStringEqual(depName, department.departmentName)) {
                return department;
            }
        }
        return null;
    }

    /**
     * Method to create an object of Employee type with the available role
     * 
     * @param name is the employee name
     * @param role is the role of the employee
     * @return employee object if the role is available, null if the role is not
     *         available
     */
    public Employee createEmployee(String name, String role) {
        Employee employee = null;
        if (Util.isStringEqual("Developer", role)) {
            employee = new Developer(name, role);
        } else if (Util.isStringEqual("Designer", role)) {
            employee = new Designer(name, role);
        } else if (Util.isStringEqual("HR", role)) {
            employee = new HR(name, role);
        } else if (Util.isStringEqual("HR-Manager", role)) {
            employee = new HRManager(name, role);
        }
        return employee;
    }

    @Override
    public boolean equals(Object obj) {
        Organization orgObj = (Organization) obj;
        List<Employee> empList1 = this.getAllEmployees();
        List<Employee> empList2 = orgObj.getAllEmployees();
        if (empList1.size() != empList2.size()) {
            return false;
        }
        for (int i = 0; i < empList1.size(); i++) {
            if (empList1.get(i).employeeName != empList2.get(i).employeeName) {
                return false;
            }
            if (empList1.get(i).employeeRole != empList2.get(i).employeeRole) {
                return false;
            }
        }
        return true;
    }

}
