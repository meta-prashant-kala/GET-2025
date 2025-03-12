import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        ShoppingCart shoppingCartObj = new ShoppingCart();
        HashMap<Integer, Item> itemIDToItemsMap = new HashMap<Integer, Item>();

        // Setting the items to be provided to the user
        Item item1 = new Item(1, "item1", "This is item 1", 100);
        Item item2 = new Item(2, "item2", "This is item 2", 200);
        Item item3 = new Item(3, "item3", "This is item 3", 300);
        Item item4 = new Item(4, "item4", "This is item 4", 400);

        // Storring all the items in the store
        itemIDToItemsMap.put(1, item1);
        itemIDToItemsMap.put(2, item2);
        itemIDToItemsMap.put(3, item3);
        itemIDToItemsMap.put(4, item4);

        // Providing Menu to the user
        int option = 1;
        while (option != 7) {

            // Showing the available itmes in the store
            System.out.println();
            System.out.println(" ------------------- Available Items ------------------- ");
            System.out.println();
            System.out.println("|   Item Name   |   Item Description    |   Item Price  |   ");
            System.out.println("---------------------------------------------------------");
            for (Item item : itemIDToItemsMap.values()) {
                System.out.println("|   " + item.name + "       |   " + item.description + "      |   "
                        + item.price + "         |   ");
            }
            System.out.println();
            System.out.println("Please Select an option");
            System.out.println("1. To display cart");
            System.out.println("2. To add an item to the cart");
            System.out.println("3. To delete an item from the cart");
            System.out.println("4. To display the quantity of an item");
            System.out.println("5. To update the quantity of an item");
            System.out.println("6. To see the total bill of the cart");
            System.out.println("7. To exit from the app");

            // Taking the option from the user
            option = sc1.nextInt();

            // Handling the user input
            switch (option) {

                // Handling Display cart option
                case 1:
                    System.out.println();
                    shoppingCartObj.displayCart();
                    System.out.println();
                    break;

                // Handling add an item to the cart option
                case 2:
                    System.out.println();

                    System.out.print("Please enter the name of the item: ");
                    String itemToAdd = sc2.nextLine();

                    System.out.print("Please enter the quantity of the item: ");
                    int itemQuantity = sc1.nextInt();

                    boolean isAdded = false;
                    for (Item item : itemIDToItemsMap.values()) {
                        if (item.name.equals(itemToAdd)) {
                            shoppingCartObj.addToCart(item, itemQuantity);
                            isAdded = true;
                        }
                    }
                    if (isAdded) {
                        System.out.println();
                        System.out.println(itemToAdd + " added succesfully");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("Please enter a valid item");
                        System.out.println();
                    }
                    break;

                // Handling delete an item from the cart option
                case 3:
                    System.out.println();
                    System.out.println("Please enter the name of the item to remove");
                    String itemToRemove = sc2.nextLine();
                    boolean removed = false;

                    for (Item item : itemIDToItemsMap.values()) {
                        if (item.name.equals(itemToRemove)) {
                            shoppingCartObj.deleteItem(item);
                            removed = true;
                        }
                    }
                    if (removed) {
                        System.out.println();
                        System.out.println(itemToRemove + " removed succesfully");
                        System.out.println();

                    } else {
                        System.out.println();
                        System.out.println("Please enter a valid item ");
                        System.out.println();
                    }
                    break;

                // Handling display the quantity of an item option
                case 4:
                    System.out.println();
                    System.out.println("Please enter the item name to see the quantity");
                    String itemTofind = sc2.nextLine();
                    boolean displayed = false;

                    for (Item item : itemIDToItemsMap.values()) {
                        if (item.name.equals(itemTofind)) {
                            shoppingCartObj.displayQty(item);
                            displayed = true;
                        }
                    }
                    if (!displayed) {
                        System.out.println();
                        System.out.print("Please enter a valid item");
                        System.out.print(itemTofind + " quantity updated succesfully");
                    }
                    break;

                // Handling update the quantity of an item option
                case 5:
                    System.out.println();
                    System.out.println("Please enter the item name to update the quantity");
                    String itemName = sc2.nextLine();
                    System.out.println("Please enter the quantity");
                    int newItemQuantity = sc1.nextInt();
                    boolean available = false;

                    for (Item item : itemIDToItemsMap.values()) {
                        if (item.name.equals(itemName)) {
                            shoppingCartObj.updateQty(item, newItemQuantity);
                            available = true;
                        }
                    }
                    if (available) {
                        System.out.println();
                        System.out.print(itemName + " quantity updated succesfully");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.print("Please enter a valid item");
                        System.out.println();
                    }
                    break;

                // Hanlding total cart bill option
                case 6:
                    System.out.println();
                    System.out.println("Total Bill: " + shoppingCartObj.displayBill());
                    System.out.println();
                    break;

                // Handling exit option fromt the app
                case 7:
                    System.exit(0);
                    break;
            }
        }
        sc1.close();
        sc2.close();
    }
}
