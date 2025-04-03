import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Image> getImageData() {

        List<Image> imageList = new ArrayList<Image>();
        imageList.add(new Image(251, 101, "This is image1 from JDBC query", "http://jdbc.com/image-1.jpg"));
        imageList.add(new Image(252, 102, "This is image2 from JDBC query", "http://jdbc.com/image-2.jpg"));
        imageList.add(new Image(253, 101, "This is image3 from JDBC query", "http://jdbc.com/image-3.jpg"));
        imageList.add(new Image(254, 102, "This is image4 from JDBC query", "http://jdbc.com/image-4.jpg"));
        imageList.add(new Image(255, 101, "This is image5 from JDBC query", "http://jdbc.com/image-5.jpg"));
        return imageList;
        
    }
}
