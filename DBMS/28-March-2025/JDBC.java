
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class JDBC {

    public ResultSet getOrderDetails(Connection connection, int userID) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT o.OrderID, o.OrderDate, p.PaymentAmount, o.OrderStatus "
                    + "FROM orders o JOIN payment p ON o.OrderID=p.OrderID "
                    + "WHERE O.UserID = ? AND o.OrderStatus='Shipped' ORDER BY o.OrderDate ASC;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, userID);
            resultSet = stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return resultSet;
    }

    public boolean insertImages(Connection connection, List<Image> imageList) {

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO image VALUES (?, ?, ?, ?)");
            System.out.println("This is working");
            for (Image imgObj : imageList) {
                stmt.setInt(1, imgObj.getImageID());
                stmt.setInt(2, imgObj.getProductID());
                stmt.setString(3, imgObj.getImageData());
                stmt.setString(4, imgObj.getImageURL());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }

        return true;
    }

    public int deleteProducts(Connection connection, int Year) {
        int resultSet = 0;
        try {
            String query = "ALTER TABLE orderItem ADD CONSTRAINT ProductID FOREIGN KEY (ProductID) " +
                    "REFERENCES product(ProductID) ON DELETE CASCADE; " +
                    "ALTER TABLE image ADD CONSTRAINT ProductID FOREIGN KEY (ProductID) " +
                    "REFERENCES product(ProductID) ON DELETE CASCADE; " +
                    "DELETE FROM product p WHERE p.ProductID NOT IN (SELECT oi.ProductID " +
                    "FROM orderItem oi JOIN orders o " +
                    "ON oi.OrderID=o.OrderID " +
                    "WHERE o.OrderDate > NOW()-INTERVAL ? YEAR);";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, Year);
            resultSet = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return resultSet;
    }

    public ResultSet getParentCategories(Connection connection) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT  c.CategoryName AS ParentCategory, COUNT(c.CategoryID) ChildCategoryCount " +
                    "FROM category c JOIN category p " +
                    "ON c.ParentCategoryID=p.CategoryID " +
                    "GROUP BY c.CategoryName " +
                    "ORDER BY c.CategoryName; ";

            PreparedStatement stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return resultSet;
    }

    public static void main(String[] args) throws SQLException {

        JDBC jdbcObj = new JDBC();
        List<Image> imageList = new ArrayList<Image>();

        String host = "jdbc:mysql://localhost:3306/";
        String dbName = "storeFront";
        String mysqlUrl = host + dbName;
        String userId = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(mysqlUrl, userId, password);

        // Question-1: Given the id of a user, fetch all orders (Id, Order Date, Order
        // Total) of
        // that user which are in shipped state. Orders should be sorted by order date
        // column in chronological order.

        ResultSet resultSet1 = jdbcObj.getOrderDetails(connection, 601);
        Order orderDetails = new Order();
        orderDetails.setOrderDetails(resultSet1);
        orderDetails.displayOrderDetails(resultSet1);

        // Question-2: Insert five or more images of a product using batch insert
        // technique.

        imageList.add(new Image(251, 101, "This is image1 from JDBC query", "http://jdbc.com/image-1.jpg"));
        imageList.add(new Image(252, 102, "This is image2 from JDBC query", "http://jdbc.com/image-2.jpg"));
        imageList.add(new Image(253, 101, "This is image3 from JDBC query", "http://jdbc.com/image-3.jpg"));
        imageList.add(new Image(254, 102, "This is image4 from JDBC query", "http://jdbc.com/image-4.jpg"));
        imageList.add(new Image(255, 101, "This is image5 from JDBC query", "http://jdbc.com/image-5.jpg"));

        boolean isAdded = jdbcObj.insertImages(connection, imageList);
        if (isAdded) {
            System.out.println("Images are added to the table successfully");
        } else {
            System.out.println("Error occured");
        }

        // Question-3: Delete all those products which were not ordered by any Shopper
        // in last 1 year. Return the number of products deleted.
        int deleteRowsCount = jdbcObj.deleteProducts(connection, 1);
        System.out.println("Number of products deleted" + deleteRowsCount);

        // Question-4: Select and display the category title of all top parent
        // categories sorted alphabetically and the count of their child categories.
        ResultSet resultSet3 = jdbcObj.getParentCategories(connection);
        ParentCategory parentCategoryObj = new ParentCategory();
        parentCategoryObj.setParentCategoryData(resultSet3);
        parentCategoryObj.displayParentCategoryData(resultSet3);

    }
}