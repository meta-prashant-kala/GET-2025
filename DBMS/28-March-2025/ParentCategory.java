import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParentCategory {
    List<String> parentCategory=new ArrayList<String>();
    List<Integer> childCategoryCount=new ArrayList<Integer>();

    public void setParentCategoryData(ResultSet resultSet) {
        if(resultSet!=null){
            if (resultSet == null) {
                System.out.println("No data found");
            } else {
                try {
                    while (resultSet.next()) {
                        parentCategory.add(resultSet.getString("ParentCategory"));
                        childCategoryCount.add(resultSet.getInt("ChildCategoryCount"));
                    }
                } catch (SQLException e) {
                    System.out.println("SQL Error: " + e.getMessage());
                }
            }
    }

    public void displayParentCategoryData(ResultSet resultSet) {
        if (parentCategory.size() <= 0) {
            System.out.println("Nothing to display");
        } else {
            for(int i=0;i<parentCategory.size();i++) {
                System.out.println(parentCategory.get(i) + "   |   " + parentCategory.get(i) + "    |   ");
            }
        }
    }
}
