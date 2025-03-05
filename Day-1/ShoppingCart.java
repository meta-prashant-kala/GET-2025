import java.util.HashMap;

public class ShoppingCart {
    HashMap<Items, Integer> hashmap = new HashMap<Items, Integer>();

    public void displayCart(){
        if(hashmap.isEmpty()){
            System.out.println("Cart is empty");
        }
        for(Items item:hashmap.keySet()){
            System.out.println(item.Name+" : "+hashmap.get(item));
        }
    }

    public void addToCart(Items item, int quantity) {
        if (hashmap.containsKey(item)) {
            hashmap.put(item, hashmap.get(item) + quantity);
        } else {
            hashmap.put(item, quantity);
        }
    }

    public void displayQty(Items item) {
        System.out.println(item.Name+" Quantity:"+hashmap.get(item));
    }

    public void updateQty(Items item, int quantity) {
        hashmap.put(item, quantity);
    }

    public void deleteItem(Items item) {
        hashmap.remove(item);
    }

    public Double displayBill() {
        Double totalBill = 0.0;
        for (Items key : hashmap.keySet()) {
            totalBill += (key.Price)*hashmap.get(key);
        }
        return totalBill;
    }
}