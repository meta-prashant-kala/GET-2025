
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    private static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        Query queryObj = new Query();
        List<Image> imageDataList = new ArrayList<Image>();
        int selectedOption;

        String host = "jdbc:mysql://localhost:3306/";
        String dbName = "storeFront";
        String mysqlUrl = host + dbName;
        String userId = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(mysqlUrl, userId, password);

        String question1 = "Question-1: Given the id of a user, fetch all orders (Id, Order Date, Order Total)\n" +
                "of that user which are in shipped state.\n" +
                "Orders should be sorted by order date column in chronological order.";
        String question2 = "Insert five or more images of a product using batch insert technique.";
        String question3 = "Delete all those products which were not ordered by any Shopper in last 1 year.\n" +
                "Return the number of products deleted.";
        String question4 = "Select and display the category title of all top parent categories sorted alphabetically\n"
                +
                "and the count of their child categories.";

        while (true) {

            System.out.println();
            System.out.println("Select one option");
            System.out.println();
            System.out.println("1. " + question1);
            System.out.println();
            System.out.println("2. " + question2);
            System.out.println();
            System.out.println("3. " + question3);
            System.out.println();
            System.out.println("4. " + question4);
            System.out.println();
            System.out.println("0. To exit from the program");
            System.out.println();

            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please select a valid option");
                continue;
            }

            switch (selectedOption) {

                case 1:
                    System.out.println("Enter the userID");
                    int userID=Integer.parseInt(scanInput.nextLine());
                    ResultSet resultSet1 = queryObj.getOrderDetails(connection, userID);
                    Order orderDetails = new Order(resultSet1);
                    orderDetails.displayOrderDetails();
                    break;
                    
                case 2:
                    imageDataList = Util.getImageData();
                    boolean isAdded = queryObj.insertImages(connection, imageDataList);
                    if (isAdded) {
                        System.out.println("Images are added to the table successfully");
                    } else {
                        System.out.println("Cannot add the data to the database");
                    }
                    break;

                case 3:
                    int deleteRowsCount = queryObj.deleteProducts(connection);
                    System.out.println("Number of products deleted = " + deleteRowsCount);
                    break;

                case 4:
                    ResultSet resultSet3 = queryObj.getParentCategories(connection);
                    ParentCategory parentCategoryObj = new ParentCategory(resultSet3);
                    parentCategoryObj.displayParentCategoryData();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Please select a valid option");
                    break;
            }
            System.out.println();
        }

    }
}