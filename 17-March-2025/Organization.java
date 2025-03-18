import java.util.ArrayList;
import java.util.List;

import employees.Employee;
import departments.Department;
public class Organization {
    public List<Department> departmentList = new ArrayList<Department>();

    boolean isDepartment(String depName){
        for(Department department:departmentList){
            if(department.departmentName==depName){
                return true;
            }
        }
        return false;
    }

    boolean addDepartment(Department department) {
        try {
            departmentList.add(department);
            return true;
        } catch (Exception e) {
            System.out.println("Cannot add this department");
            return false;
        }
    }

    public void displayAllDepartments(){
        System.out.println(" --------------------Available Departments-------------------- ");
        for(Department department:departmentList){
            System.out.println(department.departmentName);
        }
    }

    List<Employee> getAllEmployees() {
        List<Employee> allEmployeesList=new ArrayList<Employee>();
        for(Department department:departmentList){
            for(Employee employee:department.employeeList){ 
                allEmployeesList.add(employee);
            }
        }
        return allEmployeesList;
    }

}
