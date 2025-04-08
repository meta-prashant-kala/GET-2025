import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String args[]) {

        EmployeeFunction employeeFunctionObj = Util.getInitialEmployeeFunctionObj();

        int selectedOption = 0;

        while (true) {

            System.out.println();
            System.out.println("Please select an option");
            System.out.println();
            System.out.println("1. To display the employee details");
            System.out.println("2. To sort the employee list by ID");
            System.out.println("3. To sort the employee list by Name");
            System.out.println("4. To add an employee the list");
            System.out.println("0. To exit from the app");
            System.out.println();

            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid integer");
                continue;
            }

            switch (selectedOption) {

                case 1:
                    employeeFunctionObj.displayList();
                    break;

                case 2:
                    employeeFunctionObj.sortByID();
                    System.out.println("Employees list after sorting by their id");
                    System.out.println();
                    employeeFunctionObj.displayList();
                    break;

                case 3:
                    employeeFunctionObj.sortByName();
                    System.out.println("Employees list after sorting by their name");
                    System.out.println();
                    employeeFunctionObj.displayList();
                    break;

                case 4:
                    int empID;
                    while (true) {
                        try {
                            System.out.println();
                            System.out.println("Enter the employee ID");
                            empID = Integer.parseInt(scanInput.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println();
                            System.out.println("Please enter a valid integer");
                            continue;
                        }
                    }

                    System.out.println();
                    System.out.println("Enter the employee name");
                    String empName = scanInput.nextLine();
                    System.out.println();
                    System.out.println("Enter the employee address");
                    String empAddress = scanInput.nextLine();
                    Employee empObj = new Employee(empID, empName, empAddress);
                    boolean isAdded = employeeFunctionObj.addEmployee(empObj);
                    System.out.println();
                    
                    if (isAdded) {
                        System.out.println("Employee added succesfully");
                    } else {
                        System.out.println("Employee already exist");
                    }
                    System.out.println();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }

    }
}
