
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Search searchObj = new Search();
        Scanner scanInput = new Scanner(System.in);
        int[] inputArray;

        int arraySize = 0;
        int keyElement = -1;
        int indexOfElementFound = -1;
        int selectedOption = 1;

        // Providing menu of features to the user
        while (selectedOption != 0) {

            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To perform Linear search");
            System.out.println("2. To perform binary search");
            System.out.println("0. To exit from the app");

            // Taking option as input from the user
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid optoin");
                continue;
            }

            switch (selectedOption) {

                // Handling Selected option of Linear search
                case 1:
                    System.out.println();
                    System.out.println("Enter the size of the array");

                    // Taking arraysize as input
                    try {
                        arraySize = Integer.parseInt(scanInput.nextLine());

                        // Handling if the arraysize is negetive
                        if (arraySize < 0) {
                            System.out.println("Array size cannot be negetive");
                            continue;
                        }

                        // Handling if the arraysize is 0
                        if (arraySize == 0) {
                            System.out.println("Array size cannot be zero");
                            continue;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid array size");
                        continue;
                    }

                    inputArray = new int[arraySize];
                    int inputArrayIterator = 0;
                    System.out.println("Enter the array elements");

                    // Taking array elements as input
                    try {
                        for (int i = 0; i < arraySize; i++) {
                            inputArray[inputArrayIterator] = (Integer.parseInt(scanInput.nextLine()));
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter valid integers");
                        continue;
                    }

                    System.out.println();
                    System.out.println("Enter the element to search");

                    // Taking Element to search as input
                    try {
                        keyElement = Integer.parseInt(scanInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please enter a valid Integer");
                        continue;
                    }

                    indexOfElementFound = searchObj.linearSearch(inputArray, 0, keyElement);

                    if (indexOfElementFound == -1) {
                        System.out.println("Element do not exist");
                    } else {
                        System.out.println("Element present at index " + indexOfElementFound);
                    }
                    break;

                // Handling Selected option of Binary search
                case 2:
                    System.out.println();
                    System.out.println("Note: Provide array in sorted order");
                    System.out.println("Enter the size of the array");

                    // Taking arraysize as input
                    try {
                        arraySize = Integer.parseInt(scanInput.nextLine());

                        // Handling if the arraysize is negetive
                        if (arraySize < 0) {
                            System.out.println("Array size cannot be negetive");
                            continue;
                        }

                        // Handling if the arraysize is zero
                        if (arraySize == 0) {
                            System.out.println("Array size cannot be zero");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter a valid array size");
                        continue;
                    }

                    System.out.println();
                    System.out.println("Enter the array elements");

                    inputArray = new int[arraySize];
                    inputArrayIterator = 0;
                    // Taking array elements as input
                    try {
                        for (int i = 0; i < arraySize; i++) {
                            inputArray[inputArrayIterator] = (Integer.parseInt(scanInput.nextLine()));
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter a valid Integers");
                        continue;
                    }

                    System.out.println();
                    System.out.println("Enter the element to search");

                    // Taking Element to search as input
                    try {
                        keyElement = Integer.parseInt(scanInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please enter a valid Integer");
                        continue;
                    }

                    indexOfElementFound = searchObj.binarySearch(inputArray, 0, arraySize - 1, keyElement);

                    if (indexOfElementFound == -1) {
                        System.out.println("Element do not exist");
                    } else {
                        System.out.println("Element present at index " + indexOfElementFound);
                    }
                    break;

                // Handle exit from the app
                case 0:
                    System.exit(0);

                default:
                    System.err.println("Please enter a valid option");
                    break;
            }

        }
        scanInput.close();
    }
}