import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int selectedOption = 1;
        int studentCount = 0;
        Scanner sc = new Scanner(System.in);
        Marksheet marksheet = new Marksheet();

        // Taking number of students input
        System.out.println("Enter the number of students");
        try {
            studentCount = Integer.parseInt(sc.nextLine());
            if (studentCount <= 0) {
                System.out.println("Number of students should be greater than 0");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Please enter valid number");
            System.exit(0);
        }

        // Taking makrs input
        System.out.println("Enter the marks of students");
        ArrayList<Float> studentsMarks = new ArrayList<Float>();
        while (studentCount > 0) {
            try {
                studentsMarks.add(Float.parseFloat(sc.nextLine()));
                studentCount--;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }
        }

        // Proving the menu of operations
        while (selectedOption != 0) {

            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To get the average of all the marks");
            System.out.println("2. To get the maximum of all grades");
            System.out.println("3. To get the minimum of all grades");
            System.out.println("4. To get the percentage of all passed students");
            System.out.println("0. To exit from the app");

            // Handling marks input and exception
            try {
                selectedOption = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please select a valid option");
            }

            // Handling inputs
            try {
                switch (selectedOption) {

                    // to handle the average marks case
                    case 1:
                        System.out.println();
                        float avgMarks = marksheet.getAvgMarks(studentsMarks);
                        System.out.println("Average marks of all students: " + avgMarks);
                        System.out.println();
                        break;

                    // to handle the maximum marks case
                    case 2:
                        System.out.println();
                        float maxMarks = marksheet.getMaxMarks(studentsMarks);
                        System.out.println("Maximum marks: " + maxMarks);
                        System.out.println();
                        break;

                    // to handle the minimum marks case
                    case 3:
                        System.out.println();
                        float minMarks = marksheet.getMinMarks(studentsMarks);
                        System.out.println("Minimum marks: " + minMarks);
                        System.out.println();
                        break;

                    // Method to handle the percentage marks case
                    case 4:
                        System.out.println();
                        float perOfPassedStud = marksheet.getPercentage(studentsMarks);
                        System.out.println("Percentage of passed students: " + perOfPassedStud);
                        System.out.println();
                        break;

                    // To handle exit from the app
                    case 0:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Please select a valid option");
                        break;
                }

            } catch (ArithmeticException e) {
                System.out.println("Arithmatic exception occured");
            }
        }

        sc.close();
    }
}
