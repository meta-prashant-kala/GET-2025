
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) {
        int selectedOption = 1;
        List<Pair<Integer, String>> sortedKeyValueList;

        String json = Util.getInitialJson();

        BinarySearchTree<Integer, String> binarySearchTreeObj = new BinarySearchTree<Integer, String>(json);

        while (true) {

            System.out.println();
            System.out.println("1. To display the initial tree");
            System.out.println("2. To add a value to the tree");
            System.out.println("3. To delete a value from the tree");
            System.out.println("4. To get a value from a key");
            System.out.println("5. To get the sorted list of the tree");
            System.out.println("6. To get the sorted list of the tree having keys ranging from K1-K2");
            System.out.println("0. To get exit from the app");
            System.out.println();

            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }

            switch (selectedOption) {
                case 1:
                    System.out.println("Inorder traversal of the tree");
                    binarySearchTreeObj.displayTree(binarySearchTreeObj.rootNode);
                    System.out.println();
                    break;
                case 2:
                    boolean isAdded;
                    while (true) {
                        try {
                            System.out.println("Enter the key");
                            int key = Integer.parseInt(scanInput.nextLine());
                            System.out.println("Enter the value");
                            String value = scanInput.nextLine();
                            Pair<Integer, String> pairObj = new Pair<Integer, String>(key, value);
                            isAdded = binarySearchTreeObj.addValue(pairObj);
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter a valid integer");
                            continue;
                        }
                    }
                    if (isAdded) {
                        System.out.println("Key and value added succesfully to the dictionary");
                        binarySearchTreeObj.displayTree(binarySearchTreeObj.rootNode);
                        System.out.println();
                    } else {
                        System.out.println("Key cannot be duplicate");
                    }
                    break;
                case 3:
                    boolean isDeleted;
                    while (true) {
                        try {
                            System.out.println("Enter the key");
                            int key = Integer.parseInt(scanInput.nextLine());
                            isDeleted = binarySearchTreeObj.deleteValue(key);
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter a valid integer");
                            continue;
                        }
                    }
                    if (isDeleted) {
                        System.out.println("Value to the corrosponding key deleted succesfully");
                    } else {
                        System.out.println("Invalid key");
                    }
                    break;
                case 4:
                    int key;
                    String value;
                    while (true) {
                        try {
                            System.out.println("Enter the key");
                            key = Integer.parseInt(scanInput.nextLine());
                            value = binarySearchTreeObj.getValue(key);
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter a valid integer");
                            continue;
                        }
                    }
                    if (value != null) {
                        System.out.println(key + " : " + value);
                    } else {
                        System.out.println("Please enter a valid key");
                    }
                    break;

                case 5:
                    System.out.println("Sorted key value list");
                    sortedKeyValueList = binarySearchTreeObj.getSortedList();
                    Util.displayList(sortedKeyValueList);
                    break;

                case 6:
                    int startKey;
                    int endKey;
                    while (true) {
                        try {
                            System.out.println("Enter the key");
                            startKey = Integer.parseInt(scanInput.nextLine());
                            System.out.println("Enter the key");
                            endKey = Integer.parseInt(scanInput.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter a valid integer");
                            continue;
                        }
                    }
                    System.out.println("Sorted key value list");
                    sortedKeyValueList = binarySearchTreeObj.getSortedListBetweenInRange(startKey, endKey);
                    Util.displayList(sortedKeyValueList);
                    break;
                default:
                    break;
            }
        }

    }
}
