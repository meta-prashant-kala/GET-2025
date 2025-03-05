import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        Items item1 = new Items(1, "item1", "This is item 1", 100);
        Items item2 = new Items(2, "item2", "This is item 2", 200);
        Items item3 = new Items(3, "item3", "This is item 3", 300);
        Items item4 = new Items(4, "item4", "This is item 4", 400);

        HashMap<Integer, Items> itemList = new HashMap<Integer, Items>();
        itemList.put(1, item1);
        itemList.put(2, item2);
        itemList.put(3, item3);
        itemList.put(4, item4);

        int option = 1;
        ShoppingCart Cart = new ShoppingCart();
        while (option != 7) {
            System.out.println("Available Items");
            for (Items item : itemList.values()) {
                System.out.println("Item Name: " + item.Name + " Item Price: " + item.Price + " Item Description "
                        + item.Description);
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
            option = sc1.nextInt();
            switch (option) {
                case 1:
                    System.out.println();
                    Cart.displayCart();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Please enter the name of the item: ");
                    String itemToAdd = sc2.nextLine();
                    System.out.print("Please enter the quantity of the item: ");
                    int itemQuantity = sc1.nextInt();
                    boolean added = false;
                    for (Items item : itemList.values()) {
                        if (item.Name.equals(itemToAdd)) {
                            Cart.addToCart(item, itemQuantity);
                            added = true;
                        }
                    }
                    if (added) {
                        System.out.println();
                        System.out.println(itemToAdd + " added succesfully");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("Please enter a valid item");
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Please enter the name of the item to remove");
                    String itemToRemove = sc2.nextLine();
                    boolean removed = false;

                    for (Items item : itemList.values()) {
                        if (item.Name.equals(itemToRemove)) {
                            Cart.deleteItem(item);
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
                case 4:
                    System.out.println();
                    System.out.println("Please enter the item name to see the quantity");
                    String itemTofind = sc2.nextLine();
                    boolean displayed = false;

                    for (Items item : itemList.values()) {
                        if (item.Name.equals(itemTofind)) {
                            Cart.displayQty(item);
                            displayed = true;
                        }
                    }
                    if (!displayed) {
                        System.out.println();
                        System.out.print("Please enter a valid item");
                        System.out.print(itemTofind + " quantity updated succesfully");
                    }
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Please enter the item name to update the quantity");
                    String itemName = sc2.nextLine();
                    System.out.println("Please enter the quantity");
                    int newItemQuantity = sc1.nextInt();
                    boolean available = false;

                    for (Items item : itemList.values()) {
                        if (item.Name.equals(itemName)) {
                            Cart.updateQty(item, newItemQuantity);
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
                case 6:
                    System.out.println();
                    System.out.println("Total Bill: "+Cart.displayBill());
                    System.out.println();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
        sc1.close();
        sc2.close();
    }
}