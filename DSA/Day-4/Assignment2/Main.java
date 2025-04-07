import java.util.Scanner;

class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String args[]) {

        UniqueChar uniqueCharObj = new UniqueChar();
        int selectedOption = 0;

        System.out.println(" ----------------- Count unique characters in string ----------------- ");

        while (true) {
            System.out.println();
            System.out.println("Please select an option");
            System.out.println();
            System.out.println("1. To count unique character in a string");
            System.out.println("2. To exit from the app");

            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid integer");
                continue;
            }

            switch (selectedOption) {
                case 1:
                    System.out.println("Enter the input string");
                    String inputString = scanInput.nextLine();
                    int uniqueCharCount = uniqueCharObj.countUniqueChars(inputString);
                    System.out.println();
                    System.out.println(uniqueCharCount + " unique characters are present in " + inputString);
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