package IntSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);
        int setSize;
        int secondSetSize;
        int[] secondIntSetArr;
        IntSet secondIntSetObj;

        // Taking size of the set as input
        while (true) {
            try {
                System.out.println("Enter the number of elements to define the set");
                setSize = Integer.parseInt(scanInput.nextLine());
                if (setSize <= 0) {
                    System.out.println("Set size should be a positive integer");
                    continue;
                }
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid Set size ");
                continue;
            }
        }

        // Creating an array of the given set size
        int[] setImplementedArray = new int[setSize];
        int iterator = 0;

        // Taking elements of the set as input
        System.out.println("Enter the elements of the set");
        while (iterator < setSize) {
            try {
                setImplementedArray[iterator] = Integer.parseInt(scanInput.nextLine());
                iterator++;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }
        }

        // Creating an immutable set of the inputed numbers using IntSet object
        IntSet customIntSetObj = new IntSet(setImplementedArray);

        int selectedOption = 1;

        while (selectedOption != 0) {

            // Providing menu to the user
            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To check a number is member of the set");
            System.out.println("2. To get the size of the set");
            System.out.println("3. To check if a set is subset");
            System.out.println("4. To get the complement of existing set elements");
            System.out.println("5. To get the union of a set with existing set");
            System.out.println("6. To get the intersection of a set with existing set");
            System.out.println("7. To get the difference of a set with existing set");
            System.out.println("8. To get the complement of a set with existing set");
            System.out.println("0. To exit from the app");

            // Taking selected option as input from the user
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }

            System.out.println();
            switch (selectedOption) {

                // Handling if a number is member of the set
                case 1:
                    try {
                        System.out.println("Enter the number");
                        int x = Integer.parseInt(scanInput.nextLine());
                        if (x <= 0 || x >= 1001) {
                            System.out.println("Universal Set ranges fromt 0-1000");
                            continue;
                        }
                        if (customIntSetObj.isMember(x)) {
                            System.out.println(x + " belongs to set");
                        } else {
                            System.out.println(x + " do not belongs to set");
                        }
                    } catch (Exception e) {
                        System.out.println("Enter a valid integer");
                        continue;
                    }

                    break;

                // Handling get the size of the set
                case 2:
                    System.out.println("Size of the set: " + customIntSetObj.size());
                    break;

                // Handling if a set is subset
                case 3:
                    try {
                        System.out.println("Enter the size of the subset:");
                        int subSetSize = Integer.parseInt(scanInput.nextLine());
                        System.out.println("Enter the elements of the set");
                        int[] subSetArr = new int[subSetSize];
                        for (int i = 0; i < subSetSize; i++) {
                            subSetArr[i] = Integer.parseInt(scanInput.nextLine());
                        }
                        IntSet subSetIntSetObj = new IntSet(subSetArr);
                        if (customIntSetObj.isSubSet(subSetIntSetObj)) {
                            System.out.println(subSetArr + " is subset of");
                            customIntSetObj.printIntSet();
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter a valid intger");
                    }
                    break;

                // Handling get the complement of existing set elements
                case 4:
                    IntSet complementIntSetObj = customIntSetObj.getComplement();
                    System.out.print("Original set : ");
                    customIntSetObj.printIntSet();
                    System.out.println();
                    System.out.print("Complement set : ");
                    complementIntSetObj.printIntSet();
                    System.out.println();
                    break;

                // Handling get the union of two sets
                case 5:
                    System.out.println("Enter the size of the second set ");
                    secondSetSize = Integer.parseInt(scanInput.nextLine());
                    secondIntSetArr = new int[secondSetSize];
                    System.out.println("Enter the set elements");
                    for (int i = 0; i < secondSetSize; i++) {
                        secondIntSetArr[i] = Integer.parseInt(scanInput.nextLine());
                    }
                    secondIntSetObj = new IntSet(secondIntSetArr);
                    IntSet unionIntSetObj = customIntSetObj.getUnionSet(secondIntSetObj);
                    System.out.println();
                    System.out.println("Union set:");
                    unionIntSetObj.printIntSet();
                    break;

                // Handling get the Intersection of two sets
                case 6:
                    System.out.println("Enter the size of the second set ");
                    secondSetSize = Integer.parseInt(scanInput.nextLine());
                    secondIntSetArr = new int[secondSetSize];
                    System.out.println("Enter the set elements");
                    for (int i = 0; i < secondSetSize; i++) {
                        secondIntSetArr[i] = Integer.parseInt(scanInput.nextLine());
                    }
                    secondIntSetObj = new IntSet(secondIntSetArr);
                    IntSet intersectionIntSetObj = customIntSetObj.getIntersectionSet(secondIntSetObj);
                    System.out.println();
                    System.out.println("Intersection set:");
                    intersectionIntSetObj.printIntSet();
                    break;

                // Handling get the Difference of two sets
                case 7:
                    System.out.println("Enter the size of the second set ");
                    secondSetSize = Integer.parseInt(scanInput.nextLine());
                    secondIntSetArr = new int[secondSetSize];
                    System.out.println("Enter the set elements");
                    for (int i = 0; i < secondSetSize; i++) {
                        secondIntSetArr[i] = Integer.parseInt(scanInput.nextLine());
                    }
                    secondIntSetObj = new IntSet(secondIntSetArr);
                    IntSet differenceIntSetObj = customIntSetObj.getDifference(secondIntSetObj);
                    System.out.println();
                    System.out.println("Difference set:");
                    differenceIntSetObj.printIntSet();
                    break;

                // Handling get the Complement of two sets
                case 8:
                    System.out.println("Enter the size of the second set ");
                    secondSetSize = Integer.parseInt(scanInput.nextLine());
                    secondIntSetArr = new int[secondSetSize];
                    System.out.println("Enter the set elements");
                    for (int i = 0; i < secondSetSize; i++) {
                        secondIntSetArr[i] = Integer.parseInt(scanInput.nextLine());
                    }
                    secondIntSetObj = new IntSet(secondIntSetArr);
                    IntSet complementedIntSetObj = customIntSetObj.getComplementIntSet(secondIntSetObj);
                    System.out.println();
                    System.out.println("Complemented set:");
                    complementedIntSetObj.printIntSet();
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
