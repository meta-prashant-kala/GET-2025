
import java.util.Scanner;

import departments.Department;
import employees.Designer;
import employees.Developer;
import employees.Employee;
import employees.HR;
import employees.HRManager;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanInput=new Scanner(System.in);

        Organization metacube = new Organization();

        Department iTDepartment = new Department("IT-Department");
        Department humanResourceDepartment = new Department("HR-Department");

        metacube.addDepartment(iTDepartment);
        metacube.addDepartment(humanResourceDepartment);

        Employee prashantObj = new Developer("Prashant", "Developer");
        Employee ankitObj = new Developer("Ankit", "Developer");

        Employee gauravObj = new Designer("Gaurav", "Designer");
        Employee digemberObj = new Designer("Digember","Designer");

        Employee piyushObj = new HRManager("Piyush", "HRManager");
        Employee shreyanshObj = new HRManager("Shreyansh", "HRManager");

        Employee rahulObj = new HR("Rahul", "HR");
        Employee palashObj = new HR("Palash","HR");

        iTDepartment.join(prashantObj);
        iTDepartment.join(ankitObj);
        iTDepartment.join(gauravObj);
        iTDepartment.join(digemberObj);

        humanResourceDepartment.join(piyushObj);
        humanResourceDepartment.join(shreyanshObj);
        humanResourceDepartment.join(rahulObj);
        humanResourceDepartment.join(palashObj);

        int selectedOption = 1;
        while (selectedOption != 0) {
            System.out.println("1. To see all the employees of a departments");
            System.out.println("2. To see all the emeployees of all departments");

            // Taking selected option as input from the user
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }


            switch (selectedOption) {
                case 1:
                    metacube.displayAllDepartments();
                    System.out.println("Enter the name of the department");
                    String selectedDepartment=scanInput.nextLine();
                    if(metacube.isDepartment(selectedDepartment)){
                        List<Employee> employeeList=metacube.getAllEmployees();
                        for(Employee employee:employeeList){
                            System.out.print(employee.employeeName);
                            System.out.println("    ");
                            System.out.print(employee.employeeRole);
                            System.out.println();
                        }
                    }
                    break;
            
                default:
                    break;
            }
        }


        scanInput.close();
    }
}
