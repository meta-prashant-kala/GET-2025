import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Query {

    /**
     * Method to fetch all orders (Id, Order Date, Order Total) of that user which
     * are in shipped state using the userID
     * 
     * @param connection should be of Connection type
     * @param userID     should be of int type
     * @return Resultset table holding the order Details
     */
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

    /**
     * Mehtod to Insert five or more images of a product using batch insert
     * technique
     * 
     * @param connection should be of Connection type
     * @param userID     should be of int type
     * @return true if the images inserted succesfully
     */
    public boolean insertImages(Connection connection, List<Image> imageList) {

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO image VALUES (?, ?, ?, ?)");
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

    /**
     * Mehtod to Delete all those products which were not ordered by any Shopper in
     * last 1 year.
     * 
     * @param connection should be of Connection type
     * @return the number of products deleted.
     */
    public int deleteProducts(Connection connection) {
        int resultSet = 0;
        try {
            String query = "DELETE FROM product p WHERE p.ProductID NOT IN (SELECT oi.ProductID " +
                    "FROM orderItem oi JOIN orders o " +
                    "ON oi.OrderID=o.OrderID " +
                    "WHERE o.OrderDate > NOW()-INTERVAL 1 YEAR);";
            PreparedStatement stmt = connection.prepareStatement(query);
            resultSet = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     * Method to Select and display the category title of all top parent categories
     * sorted alphabetically and the count of their child categories
     * 
     * @param connection should be of Connection type
     * @return count of child categories of top parent category.
     */
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

}
