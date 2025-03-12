import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);
        CustomMath customMathObj = new CustomMath();

        int num1 = 0;
        int num2 = 0;

        // Taking the numerbs as input from the user
        try {
            System.out.println("Enter the first number");
            num1 = Integer.parseInt(scanInput.nextLine());
            System.out.println("Enter the second number");
            num2 = Integer.parseInt(scanInput.nextLine());
        } catch (Exception e) {
            System.out.println("Please enter valid integer");
        }

        int selectedOption = 1;

        while (selectedOption != 0) {

            // Providing menu to the user
            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To get the HCF(" + num1 + "," + num2 + ")");
            System.out.println("2. To get the LCM(" + num1 + "," + num2 + ")");
            System.out.println("0. To exit from the app");

            // Taking selected option as input from the user
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }

            switch (selectedOption) {

                // Handling the HCF option
                case 1:
                    System.err.println();
                    int hcf = customMathObj.getHCF(num1, num2);
                    System.err.println("HCF(" + num1 + "," + num2 + ") = " + hcf);
                    break;

                // Handling the LCM option
                case 2:
                    System.err.println();
                    int lcm = customMathObj.getLCM(num1, num2);
                    System.err.println("LCM(" + num1 + "," + num2 + ") = " + lcm);
                    break;

                // Handling exit from the app
                case 0:
                    System.exit(0);

                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }

        scanInput.close();

    }
}