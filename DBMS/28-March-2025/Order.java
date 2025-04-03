
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Integer> orderID = new ArrayList<Integer>();
    List<String> orderDate = new ArrayList<String>();
    List<Integer> orderTotal = new ArrayList<Integer>();

    public Order(ResultSet resultSet){
        try {
            while (resultSet.next()) {
                orderID.add(resultSet.getInt("OrderID"));
                orderDate.add(resultSet.getString("OrderDate"));
                orderTotal.add(resultSet.getInt("PaymentAmount"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    public void displayOrderDetails() {
        if (orderID.size() <= 0) {
            System.out.println("Nothing to display");
        } else {
            for(int i=0;i<orderID.size();i++) {
                System.out.println(orderID.get(i) + "   |   " + orderDate.get(i) + "    |   " + orderTotal.get(i));
            }
        }
    }

}
