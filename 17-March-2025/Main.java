
import java.util.Scanner;
import employees.Designer;
import employees.Developer;
import employees.Employee;
import employees.HR;
import employees.HRManager;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);

        List<Employee> allEmployeeList;
        String empName;
        String selectedDepartmentName;
        Department foundDepartmentObj;
        boolean isAdded = false;

        // Initialising organisation
        Organization organizationObj = new Organization("Metacube");

        // Initialising Departments
        Department departmentObj1 = new Department("IT-Department");
        Department departmentObj2 = new Department("HR-Department");

        // Adding Departments to the department list of organisation
        organizationObj.addDepartment(departmentObj1);
        organizationObj.addDepartment(departmentObj2);

        // Initialising employee of each type
        Employee developerObj1 = new Developer("Prashant", "Developer");
        Employee developerObj2 = new Developer("Ankit", "Developer");

        Employee designerObj1 = new Designer("Gaurav", "Designer");
        Employee designerObj2 = new Designer("Digember", "Designer");

        Employee hrManagerObj1 = new HRManager("Piyush", "HRManager");
        Employee hrManagerObj2 = new HRManager("Shreyansh", "HRManager");

        Employee hrObj1 = new HR("Rahul", "HR");
        Employee hrObj2 = new HR("Palash", "HR");

        // Adding Employee objects to the emloyee list of each department
        departmentObj1.join(developerObj1);
        departmentObj1.join(developerObj2);
        departmentObj1.join(designerObj1);
        departmentObj1.join(designerObj2);

        departmentObj2.join(hrManagerObj1);
        departmentObj2.join(hrManagerObj2);
        departmentObj2.join(hrObj1);
        departmentObj2.join(hrObj2);

        // Providing menu to the user
        int selectedOption = 1;
        while (selectedOption != 0) {
            System.out.println("1. To see all the employees of a departments");
            System.out.println("2. To see all the emeployees of an organisation");
            System.out.println("3. To add a department in the organisation");
            System.out.println("4. To add an employee to a department");
            System.out.println("5. To get the pay slip of an employee");
            System.out.println("0. To exit from the app");

            // Taking selected option as input from the user
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }

            switch (selectedOption) {

                // Handling see all the employees of a departments
                case 1:
                    organizationObj.displayAllDepartments();
                    System.out.println();
                    System.out.println("Enter the name of the department");
                    selectedDepartmentName = scanInput.nextLine();
                    foundDepartmentObj = organizationObj.getDepartment(selectedDepartmentName);
                    System.out.println();
                    if (foundDepartmentObj != null) {
                        foundDepartmentObj.displayEmployeeList();
                    } else {
                        System.out.println(
                                selectedDepartmentName + " does not exist in " + organizationObj.organisationName);
                    }
                    System.out.println();
                    break;

                // Handling see all the emeployees in an organisation
                case 2:
                    System.out.println();
                    System.out.println("List of all employees");
                    allEmployeeList = organizationObj.getAllEmployees();
                    System.out.println();
                    for (Employee employee : allEmployeeList) {
                        System.out.print(employee.employeeName);
                        System.out.print("  -> ");
                        System.out.print(employee.employeeRole);
                        System.out.println();
                    }
                    System.out.println();
                    break;

                // Handling add a department in the organisation
                case 3:
                    System.out.println();
                    System.out.println("Enter the name of the department");
                    String deptName = scanInput.nextLine();
                    Department departmentObj = new Department(deptName);
                    System.out.println();
                    isAdded = organizationObj.addDepartment(departmentObj);
                    if (isAdded) {
                        System.out.println(deptName + " added succesfully");
                    } else {
                        System.out.println("Cannot add this department");
                    }
                    System.out.println();
                    break;

                // Handling add an employee to a department
                case 4:
                    System.out.println();
                    System.out.println("Enter the name of the employee");
                    empName = scanInput.nextLine();
                    System.out.println();
                    System.out.println("------------Select the role of the employee------------");
                    System.out.println();
                    System.out.println("------Available roles------");
                    System.out.println();
                    organizationObj.displayRoles();
                    String selectedRole;
                    while (true) {
                        selectedRole = scanInput.nextLine();
                        boolean isFound = organizationObj.isRoleAvailable(selectedRole);
                        if (isFound) {
                            break;
                        }
                        System.out.println();
                        System.out.println("Please enter a valid role");
                        System.out.println();
                    }
                    Employee employeeObj = organizationObj.createEmployee(empName, selectedRole);
                    organizationObj.displayAllDepartments();
                    System.out.println();
                    System.out.println("------------Enter the name of the department------------");
                    selectedDepartmentName = scanInput.nextLine();
                    System.out.println();
                    foundDepartmentObj = organizationObj.getDepartment(selectedDepartmentName);
                    isAdded = foundDepartmentObj.join(employeeObj);
                    if (isAdded) {
                        System.out.println("Employee added successfully");
                    } else {
                        System.err.println("There's an error occured");
                    }
                    System.out.println();
                    break;

                // Handling get the payslip of an employee
                case 5:
                    System.out.println();
                    System.out.println("Enter the name of the employee");
                    empName = scanInput.nextLine();
                    Employee employeeFound = organizationObj.getEmployee(empName);
                    System.out.println();
                    if (employeeFound != null) {
                        Payroll payrollObj = new Payroll();
                        payrollObj.printSalary(employeeFound);
                    } else {
                        System.out.println("Employee does not belongs to " + organizationObj.organisationName);
                    }
                    System.out.println();

                    break;

                // Handling exit from the app
                case 0:
                    System.exit(0);
                    break;

                // Handling unnecessory option
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }

        scanInput.close();
    }
}
