import java.util.ArrayList;
import java.util.List;

public class Organization {
    public List<Department> departmentList = new ArrayList<Department>();

    boolean addDepartment(Department department) {
        try {
            departmentList.add(department);
            return true;
        } catch (Exception e) {
            System.out.println("Cannot add this department");
            return false;
        }
    }

    List<Employee> getAllEmployees() {
        
    }

}
