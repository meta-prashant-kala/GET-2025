import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class EmployeeFunction {
    List<Employee> employeeList;
    Set<Integer> employeeIdSet;

    /**
     * Constructor to initialise the list of the class
     */
    public EmployeeFunction(){
        employeeList=new ArrayList<Employee>();
        employeeIdSet=new HashSet<Integer>();
    }

    /**
     * Method to add the employee to the list if previously not exists
     * @param empObj should be of Employee type
     * @return true if the employee added succesfully, otherwise false
     */
    public boolean addEmployee(Employee empObj) {
        if(!employeeIdSet.contains(empObj.employeeID)){
            employeeIdSet.add(empObj.employeeID);
            employeeList.add(empObj);
            return true;
        }
        return false;
    }


    /**
     * Method to display the employee details
     */
    public void displayList() {
        System.out.println(" ------------------ Employee details ------------------ ");
        for (Employee empObj : employeeList) {
            System.out.println("EmployeeID: "+empObj.employeeID);
            System.out.println("EmployeeName: " + empObj.employeeName);
            System.out.println("EmployeeName: " + empObj.employeeAddress);
            System.out.println();
        }
    }


    /**
     * Method to sort the employee list on the basis of employee id
     */
    public void sortByID() {
        Collections.sort(employeeList);
    }


    // Overriding the comparator method
    class EmployeeComparatorByName implements Comparator<Employee> {
        @Override
        public int compare(Employee empObj1, Employee empObj2){
            return empObj1.employeeName.compareTo(empObj2.employeeName);

        }
    }

    /**
     * Method to sort the employee list on the basis of employee name
     */
    public void sortByName() {
        Collections.sort(employeeList, new EmployeeComparatorByName());
    }
}
