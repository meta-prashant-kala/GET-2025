
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrOperation arrOperation = new ArrOperation();
        int[] array;
        Scanner sc = new Scanner(System.in);

        int arraySize = 0;
        int arrayIterator = 0;

        // Taking the size of the array as input
        System.out.println("Enter the size of the array");
        try {
            arraySize = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Please enter a valid integer");
            System.exit(0);
        }

        array = new int[arraySize];
        arrayIterator = 0;

        // Taking the array elements as input
        System.out.println("Enter the array elements");
        while (arraySize > 0) {
            try {
                array[arrayIterator] = Integer.parseInt(sc.nextLine());
                arraySize--;
                arrayIterator++;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }
        }

        int selectedOption = 1;

        // Providing menu to the user
        while (selectedOption != 0) {

            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To get the size of the largest mirror section found in the input array");
            System.out.println("2. To get the number of clumps in the input array");
            System.out.println("3. To fix the index of X and Y");
            System.out.println("4. To get the index if there is a place to split the input array");
            System.out.println("0. To exit from the app");

            try {
                selectedOption = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please select a valid option");
                continue;
            }

            try {
                switch (selectedOption) {

                    // Handling the count of largest mirror section option
                    case 1:
                        System.out.println();
                        int largestMirrorSection = arrOperation.mirrorSection(array);
                        System.out.println("The size of the largest mirror section is " + largestMirrorSection);
                        System.out.println();
                        break;

                    // Handling the count of cumps present in the array
                    case 2:
                        System.out.println();
                        int clumpSize = arrOperation.clumpsInArray(array);
                        System.out.println("The number of clumps present in the array is " + clumpSize);
                        System.out.println();
                        break;

                    // Handling the fixXY in the array
                    case 3:
                        System.out.println();
                        System.out.println("Enter the value of X: ");
                        int valueOfX = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter the value of Y: ");
                        int valueOfY = Integer.parseInt(sc.nextLine());
                        int[] xYFixedArray = arrOperation.fixXY(array, valueOfX, valueOfY);
                        System.out.println(valueOfX + " and " + valueOfY + " fixed array " + xYFixedArray);
                        System.out.println();
                        break;

                    // Handling the split index in the array
                    case 4:
                        System.out.println();
                        int splitIndex = arrOperation.splitArray(array);
                        System.out.println("The split index of the array is " + splitIndex);
                        System.out.println();
                        break;

                    // Handling the exit from the app
                    case 0:
                        System.exit(0);

                    default:
                        System.out.println("Please select a valid option");
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}