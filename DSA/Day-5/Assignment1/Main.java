
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) {
        int selectedOption = 1;
        String key;
        String value;
        List<Pair<String, String>> sortedKeyValueList;

        String json = Util.getInitialJson();

        BinarySearchTree<String, String> binarySearchTreeObj = new BinarySearchTree<String, String>(json);

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
                    System.out.println("Enter the key");
                    key = scanInput.nextLine();
                    System.out.println("Enter the value");
                    value = scanInput.nextLine();
                    Pair<String, String> pairObj = new Pair<String, String>(key, value);
                    isAdded = binarySearchTreeObj.addValue(pairObj);
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
                    System.out.println("Enter the key");
                    key = scanInput.nextLine();
                    isDeleted = binarySearchTreeObj.deleteValue(key);
                    if (isDeleted) {
                        System.out.println("Value to the corrosponding key deleted succesfully");
                    } else {
                        System.out.println("Invalid key");
                    }
                    break;
                case 4:

                    System.out.println("Enter the key");
                    key = scanInput.nextLine();
                    value = binarySearchTreeObj.getValue(key);
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
                    String startKey;
                    String endKey;
                    System.out.println("Enter the key");
                    startKey = scanInput.nextLine();
                    System.out.println("Enter the key");
                    endKey = scanInput.nextLine();
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
