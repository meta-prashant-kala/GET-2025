import java.util.HashMap;

public class ShoppingCart {
    HashMap<Item, Integer> itemToQuantityMap = new HashMap<Item, Integer>();

    // Display cart method
    public void displayCart() {
        if (itemToQuantityMap.isEmpty()) {
            System.out.println("Cart is empty");
        }
        System.out.println();
        System.out.println("|   Item Name   |   Item Description    |   Item Price  |   Item Quantity   |");
        System.out.println("-----------------------------------------------------------------------------");
        for (Item item : itemToQuantityMap.keySet()) {
            // System.out.println(item.name + " : " + itemToQuantityMap.get(item));
            System.out.println("|   " + item.name + "       |   " + item.description + "      |   "
                    + item.price + "         |         " + itemToQuantityMap.get(item) + "         |");
        }
    }

    // Add to card method
    public void addToCart(Item item, int quantity) {
        if (itemToQuantityMap.containsKey(item)) {
            itemToQuantityMap.put(item, itemToQuantityMap.get(item) + quantity);
        } else {
            itemToQuantityMap.put(item, quantity);
        }
    }

    // Method to display Particular item quantity
    public void displayQty(Item item) {
        System.out.println(item.name + " Quantity:" + itemToQuantityMap.get(item));
    }

    // Method to update items quantity
    public void updateQty(Item item, int quantity) {
        itemToQuantityMap.put(item, quantity);
    }

    // Method to delete item form the cart
    public void deleteItem(Item item) {
        itemToQuantityMap.remove(item);
    }

    // Method to display the total bill of the cart
    public Double displayBill() {
        Double totalBill = 0.0;
        System.out.println();
        System.out.println(" ----------------------------- Total Cart value ----------------------------- ");
        System.out.println();
        displayCart();
        for (Item item : itemToQuantityMap.keySet()) {
            totalBill += (item.price) * itemToQuantityMap.get(item);
        }
        System.out.println();
        return totalBill;
    }
}