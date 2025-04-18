import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedList linkedListObj = Util.getInitialData();

        int selectedOption;

        while (true) {
            System.out.println();
            System.out.println("1. To enter data to the link list");
            System.out.println("2. To display the linked list");
            System.out.println("0. To exit from the app");
            System.out.println();
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
                System.out.println();
            } catch (Exception e) {
                System.out.println("Please select a valid option");
                continue;
            }
            switch (selectedOption) {
                case 1:
                    try {
                        System.out.println("Enter the name of the employee");
                        String empName = scanInput.nextLine();
                        System.out.println("Enter the salary of the employee");
                        int salary = Integer.parseInt(scanInput.nextLine());
                        System.out.println("Enter the age of the employee");
                        int age = Integer.parseInt(scanInput.nextLine());
                        Employee employeeObj = new Employee(empName, salary, age);
                        linkedListObj.addNode(employeeObj);
                        System.out.println(empName + " added to the linked list succesfully");
                    } catch (Exception e) {
                        System.out.println("Enter valid integers");
                        continue;
                    }
                    break;
                case 2:
                    if (linkedListObj.getHead() == null) {
                        System.out.println("LinkedList is empty");
                    } else {
                        linkedListObj.displayLinkedList();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
            System.out.println();

        }

    }
}