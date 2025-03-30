
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class JDBC {

    public ResultSet getOrderDetails(Connection connection, int userID) {
        ResultSet resultSet=null;
        try {
            String query = "SELECT o.OrderID, o.OrderDate, p.PaymentAmount, o.OrderStatus "
                    + "FROM orders o JOIN payment p ON o.PaymentID=p.PaymentID "
                    + "WHERE O.UserID = ? AND o.OrderStatus='Shipped' ORDER BY o.OrderDate ASC;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, userID);
            resultSet = stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("Error occured");
        }
        return resultSet;
    }

    public boolean insertImages(Connection connection, List<Image> imageList){
        
        try {
            PreparedStatement stmt=connection.prepareStatement("INSERT INTO image VALUES (?, ?, ?, ?)");
            System.out.println("This is working");
            for(Image imgObj:imageList){
                stmt.setInt(1, imgObj.getImageID());
                stmt.setInt(2, imgObj.getProductID());
                stmt.setString(3, imgObj.getImageData());
                stmt.setString(4, imgObj.getImageURL());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (Exception e) {
            System.out.println("Error occured");
            return false;
        }
        
        return true;
    }


    public ResultSet deleteProducts(Connection connection){
        ResultSet resultSet=null;
        try {
            PreparedStatement stmt=connection.prepareStatement(null);
            stmt.setInt(1,1);
            resultSet=stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("Error occured");
        }
        return resultSet;
    }


    public ResultSet getParentCategories(Connection connection){
        ResultSet resultSet=null;
        try {
            String query="SELECT  c.CategoryName AS ParentCategory, COUNT(c.CategoryID) ChildCategoryCount " + 
                                "FROM category c JOIN category p " +
                                "\tON c.ParentCategoryID=p.CategoryID " + 
                                "GROUP BY c.CategoryName " + 
                                "ORDER BY c.CategoryName; ";

            PreparedStatement stmt=connection.prepareStatement(query);
            resultSet=stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("Error occured");
        }
        return resultSet;
    }


    public static void main(String[] args) throws SQLException {

        JDBC jdbcObj=new JDBC();
        List<Image> imageList=new ArrayList<Image>();

        String host = "jdbc:mysql://localhost:3306/";
        String dbName = "storeFront";
        String mysqlUrl = host + dbName;
        String userId = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(mysqlUrl, userId, password);


        // Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state. Orders should be sorted by order date column in chronological order.

        // ResultSet resultSet1 = jdbcObj.getOrderDetails(connection, 601);
        // if(resultSet1==null){
        //     System.out.println("Error occured");
        // }else {
        //     while (resultSet.next()) {
        //         System.out.println(resultSet1.getString("OrderID") + "   |   " + resultSet1.getString("OrderDate") + "    |    "
        //                         + resultSet1.getString("PaymentAmount") + "  |    ");
        //     }
        // }
        

        // Insert five or more images of a product using batch insert technique.

        // imageList.add(new Image(251, 101, "This is image1 from JDBC query","http://jdbc.com/image-1.jpg"));
        // imageList.add(new Image(252, 102, "This is image2 from JDBC query","http://jdbc.com/image-2.jpg"));
        // imageList.add(new Image(253, 101, "This is image3 from JDBC query","http://jdbc.com/image-3.jpg"));
        // imageList.add(new Image(254, 102, "This is image4 from JDBC query","http://jdbc.com/image-4.jpg"));
        // imageList.add(new Image(255, 101, "This is image5 from JDBC query","http://jdbc.com/image-5.jpg"));

        // boolean isAdded=jdbcObj.insertImages(connection, imageList);
        // if(isAdded){
        //     System.out.println("Images are added to the table successfully");
        // }
        // else{
        //     System.out.println("Error occured");
        // }

        // ResultSet resultSet2 =jdbc.deleteProducts(connection);

        ResultSet resultSet3=jdbcObj.getParentCategories(connection);
        if(resultSet3!=null){
            while (resultSet3.next()) {
                System.out.println(resultSet3.getString("ParentCategory")+" |   "+resultSet3.getString("ChildCategoryCount"));
            }
        }


    }
}