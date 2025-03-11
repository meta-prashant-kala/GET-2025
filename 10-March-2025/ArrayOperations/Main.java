import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrOperation arrOperation = new ArrOperation();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        
        int arrSize = 0;

        // Taking the size of the array as input
        System.out.println("Enter the size of the array");
        try {
            arrSize = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Please enter a valid integer");
            System.exit(0);
        }

        // Taking the array elements as input
        System.out.println("Enter the array elements");
        while (arrSize > 0) {
            try {
                arr.add(Integer.parseInt(sc.nextLine()));
                arrSize--;
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
            System.out.println("3. To Switch the case of a string");
            System.out.println("4. To get the index if there is a place to split the input array");
            System.out.println("0. To exit from the app");

            try {
                selectedOption = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please select a valid option");
                continue;
            }

            switch (selectedOption) {

                // Handling the count of largest mirror section option
                case 1:
                    System.out.println();
                    int largestMirrorSection = arrOperation.mirrorSection(arr);
                    System.out.println("The size of the largest mirror section is " + largestMirrorSection);
                    System.out.println();
                    break;

                // Handling the count of cumps present in the array
                case 2:
                    System.out.println();
                    int clumpSize = arrOperation.clumpsInArray(arr);
                    System.out.println("The number of clumps present in the array is " + clumpSize);
                    System.out.println();
                    break;

                // Handling the fixXY in the array
                case 3:
                    System.out.println();
                    ArrayList<Integer> xYFixedArray = arrOperation.fixXY(arr);
                    System.out.println("The number of clumps present in the array is " + xYFixedArray);
                    System.out.println();
                    break;

                // Handling the split index in the array
                case 4:
                    System.out.println();
                    int splitIndex = arrOperation.splitArray(arr);
                    System.out.println("The split index of the array is " + splitIndex);
                    System.out.println();
                    break;

                // Handling the exit from the app
                case 0:
                    System.exit(0);

                default:
                    break;
            }

        }

        sc.close();
    }
}