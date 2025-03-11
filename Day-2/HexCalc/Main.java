import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HexCalc hexCalculator = new HexCalc();

        int selectedOption = 1;
        while (selectedOption != 0) {

            // Providing menu to the user
            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To add two hexa decimal numbers");
            System.out.println("2. To subtract two hexa decimal numbers");
            System.out.println("3. To multiply two hexa decimal numbers");
            System.out.println("4. To Divide two hexa decimal numbers");
            System.out.println("5. To convert a number from hexadecimal to decimal");
            System.out.println("6. To convert a number from decimal to hexadecimal");
            System.out.println("7. To check the two hexadecimal numbers are equal");
            System.out.println("8. To check the first hexadecimal number is greater than the second hexadecimal");
            System.out.println("9. To check the first hexadecimal number is smaller than the second hexadecimal");
            System.out.println("0. To exit from the app");

            try {
                selectedOption = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid input");
                continue;
            }

            // Handling the option from
            try {

                switch (selectedOption) {

                    // Handling add two hexa decimal numbers
                    case 1:
                        System.out.println();
                        System.out.println("Enter the first number");
                        String numToAdd1 = scan.nextLine();
                        System.out.println("Enter the Second number");
                        String numToAdd2 = scan.nextLine();
                        System.out.println(
                                numToAdd1 + " + " + numToAdd2 + " = "
                                        + hexCalculator.hexAddition(numToAdd1, numToAdd2));
                        System.out.println();
                        break;

                    // Handling subtract two hexa decimal numbers
                    case 2:
                        System.out.println();
                        System.out.println("Enter the first number");
                        String numToSub1 = scan.nextLine();
                        System.out.println("Enter the Second number");
                        String numToSub2 = scan.nextLine();
                        System.out.println(
                                numToSub1 + " - " + numToSub2 + " = "
                                        + hexCalculator.hexSubtraction(numToSub1, numToSub2));
                        System.out.println();
                        break;

                    // Handling multiply two hexa decimal numbers
                    case 3:
                        System.out.println();
                        System.out.println("Enter the first number");
                        String numToMul1 = scan.nextLine();
                        System.out.println("Enter the Second number");
                        String numToMul2 = scan.nextLine();
                        System.out.println(
                                numToMul1 + " * " + numToMul2 + " = "
                                        + hexCalculator.hexMultiply(numToMul1, numToMul2));
                        System.out.println();
                        break;

                    // Handling Divide two hexa decimal numbers
                    case 4:
                        System.out.println();
                        System.out.println("Enter the first number");
                        String numToDiv1 = scan.nextLine();
                        System.out.println("Enter the Second number");
                        String numToDiv2 = scan.nextLine();
                        System.out.println(
                                numToDiv1 + " / " + numToDiv2 + " = " + hexCalculator.hexDivide(numToDiv1, numToDiv2));
                        System.out.println();
                        break;

                    // Handling conversion of a hexadecimal number to decimal number
                    case 5:
                        System.out.println();
                        System.out.println("Enter the number");
                        String hexToDecNum = scan.nextLine();
                        System.out.println("Decimal of " + hexToDecNum + " is " + hexCalculator.hexToDec(hexToDecNum));
                        System.out.println();
                        break;

                    // Handling conversion of a decimal number hexadecimal number
                    case 6:
                        System.out.println();
                        System.out.println("Enter the number");
                        int decToHexNum = Integer.parseInt(scan.nextLine());
                        System.out.println(
                                "HexaDecimal of " + decToHexNum + " is " + hexCalculator.decToHex(decToHexNum));
                        System.out.println();
                        break;

                    // Handling check wheather two hexadecimal numbers are equal or not
                    case 7:
                        System.out.println();
                        System.out.println("Enter the first number");
                        String equalCheckNum1 = scan.nextLine();
                        System.out.println("Enter the Second number");
                        String equalCheckNum2 = scan.nextLine();
                        Boolean isEqual = hexCalculator.isEqual(equalCheckNum1, equalCheckNum2);
                        if (isEqual) {
                            System.out.println(equalCheckNum1 + " and " + equalCheckNum2 + " are equal");
                        } else {
                            System.out.println(equalCheckNum1 + " and " + equalCheckNum2 + " are not equal");
                        }
                        System.out.println();
                        break;

                    // Handling check: the first hexadecimal number is greater than the second
                    // hexadecimal
                    case 8:
                        System.out.println();
                        System.out.println("Enter the first number");
                        String greaterCheckNum1 = scan.nextLine();
                        System.out.println("Enter the Second number");
                        String greaterCheckNum2 = scan.nextLine();
                        Boolean isGreater = hexCalculator.isGreater(greaterCheckNum1, greaterCheckNum2);
                        if (isGreater) {
                            System.out.println(greaterCheckNum1 + " is greater than " + greaterCheckNum2);
                        } else {
                            System.out.println(greaterCheckNum1 + " is not greater than " + greaterCheckNum2);
                        }
                        System.out.println();
                        break;

                    // Handling check: the first hexadecimal number is smaller than the second
                    // hexadecimal
                    case 9:
                        System.out.println();
                        System.out.println("Enter the first number");
                        String smallerCheckNum1 = scan.nextLine();
                        System.out.println("Enter the Second number");
                        String smallerCheckNum2 = scan.nextLine();
                        Boolean isSmaller = hexCalculator.isSmaller(smallerCheckNum1, smallerCheckNum2);
                        if (isSmaller) {
                            System.out.println(smallerCheckNum1 + " is smaller than " + smallerCheckNum2);
                        } else {
                            System.out.println(smallerCheckNum1 + " is not smaller than " + smallerCheckNum2);
                        }
                        System.out.println();
                        break;

                    // Handling exit from the app
                    case 0:
                        break;

                    default:
                        System.out.println("Please select a valid entry");
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        scan.close();
    }
}
