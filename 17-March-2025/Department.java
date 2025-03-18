import java.util.ArrayList;
import java.util.List;

public class Department {
    public List<Employee> employeeList=new ArrayList<Employee>();

    public boolean join(Employee employee){
        try {
            employeeList.add(employee);
            return true;
        } catch (Exception e) {
            System.out.println("Employee cannot be added to this department");
            return false;
        }
    }
    boolean relieve(Employee employee){
        try {
            employeeList.remove(employee);
            return true;
        } catch (Exception e) {
            System.out.println("Employee cannot be removed form this department");
            return false;
        }
    }
    List<Employee> getEmployees(){
        return employeeList;
    }

}
