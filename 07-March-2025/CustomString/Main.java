import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        CustomString str = new CustomString();

        int selectedOption = 1;

        // Providing menu to the user
        while (selectedOption != 0) {

            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To check if two strings are equal");
            System.out.println("2. To reverse a string");
            System.out.println("3. To Switch the case of a string");
            System.out.println("4. To get the largest word of a string");
            System.out.println("0. To exit from the app");

            try {
                selectedOption = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Please select a valid option");
                continue;
            }

            // Hanlding option selected by the user
            switch (selectedOption) {

                // Handling if two strings are equal check
                case 1:
                    System.out.println("Enter the first string");
                    String cmpString1 = scan.nextLine();
                    System.out.println("Enter the second string");
                    String cmpString2 = scan.nextLine();
                    if (str.cmpStrings(cmpString1, cmpString2)) {
                        System.out.println(cmpString1 + " and " + cmpString2 + " are equal");
                    } else {
                        System.out.println(cmpString1 + " and " + cmpString2 + " are not equal");
                    }
                    break;

                // Handling To reverse a string check
                case 2:
                    System.out.println("Enter the string");
                    String revString = scan.nextLine();
                    String reversedString = str.rverseString(revString);
                    System.out.println(reversedString);
                    break;

                // Handling Switch the case of a string check
                case 3:
                    System.out.println("Enter the string to switch cases");
                    String toSwitchCaseStr = scan.nextLine();
                    String switchedCaseStr = str.stringCaseSwitch(toSwitchCaseStr);
                    System.out.println(switchedCaseStr);
                    break;

                // Handling Switch the case of a string check
                case 4:
                    System.out.println("Enter the string to get the largest word");
                    String largestStrWord = scan.nextLine();
                    String largestWordInStr = str.largestWord(largestStrWord);
                    System.out.println(largestWordInStr);
                    break;

                // Handling exit from program
                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please select from the provided options");
                    break;
            }
        }

        scan.close();
    }
}
