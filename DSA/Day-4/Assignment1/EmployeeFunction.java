import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class EmployeeFunction {
    List<Employee> employeeList;
    Set<Integer> employeeIdSet;

    public EmployeeFunction(){
        employeeList=new ArrayList<Employee>();
        employeeIdSet=new HashSet<Integer>();
    }

    public boolean addEmployee(Employee empObj) {
        if(!employeeIdSet.contains(empObj.employeeID)){
            employeeIdSet.add(empObj.employeeID);
            employeeList.add(empObj);
            return true;
        }
        return false;
    }

    public void displayList() {
        System.out.println(" ------------------ Employee details ------------------ ");
        for (Employee empObj : employeeList) {
            System.out.println("EmployeeID: "+empObj.employeeID);
            System.out.println("EmployeeName: " + empObj.employeeName);
            System.out.println("EmployeeName: " + empObj.employeeAddress);
            System.out.println();
        }
    }

    public void sortByID() {
        Collections.sort(employeeList);
    }

    class EmployeeComparatorByName implements Comparator<Employee> {
        @Override
        public int compare(Employee empObj1, Employee empObj2){
            return empObj1.employeeName.compareTo(empObj2.employeeName);

        }
    }

    public void sortByName() {
        Collections.sort(employeeList, new EmployeeComparatorByName());
    }
}
