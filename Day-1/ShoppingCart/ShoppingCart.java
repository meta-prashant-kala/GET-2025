import java.util.HashMap;

public class ShoppingCart {
    HashMap<Item, Integer> cart = new HashMap<Item, Integer>();


    // Display cart method
    public void displayCart(){
        if(cart.isEmpty()){
            System.out.println("Cart is empty");
        }
        for(Item item:cart.keySet()){
            System.out.println(item.Name+" : "+cart.get(item));
        }
    }

    // Add to card method
    public void addToCart(Item item, int quantity) {
        if (cart.containsKey(item)) {
            cart.put(item, cart.get(item) + quantity);
        } else {
            cart.put(item, quantity);
        }
    }

    // Method to display Particular item quantity 
    public void displayQty(Item item) {
        System.out.println(item.Name+" Quantity:"+cart.get(item));
    }

    // Method to update items quantity
    public void updateQty(Item item, int quantity) {
        cart.put(item, quantity);
    }

    // Method to delete item form the cart
    public void deleteItem(Item item) {
        cart.remove(item);
    }
    
    // Method to display the total bill of the cart
    public Double displayBill() {
        Double totalBill = 0.0;
        displayCart();
        for (Item item : cart.keySet()) {
            totalBill += (item.Price)*cart.get(item);
        }
        return totalBill;
    }
}