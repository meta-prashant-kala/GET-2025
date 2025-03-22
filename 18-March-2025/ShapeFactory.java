
import java.util.List;

public class ShapeFactory {

    /**
     * Method to create a shape object of a specific type entered by the user
     * 
     * @param shape          is the shape user want to create on the screen
     * @param originPointObj is Point object holding the x and y cordinates of the
     *                       shape
     * @param shapeDataList  is the list which holds the related information about a
     *                       shape
     * @return shape of specific type that user entered
     */
    public static Shape createShape(ShapeType shape, Point originPointObj, List<Integer> shapeDataList) {
        Shape shapeObj = null;
        switch (shape) {

            // Handling if user enters circle as shape
            case CIRCLE:
                shapeObj = new Circle(shapeDataList.get(0), originPointObj);
                break;

            // Handling if user enters rectangle as shape
            case RECTANGLE:
                shapeObj = new Reactangle(shapeDataList.get(0), shapeDataList.get(1), originPointObj);
                break;

            // Handling if user enters square as shape
            case SQUARE:
                shapeObj = new Square(shapeDataList.get(0), originPointObj);
                break;

            // Handling if user enters triangle as shape
            case TRIANGLE:
                shapeObj = new Triangle(shapeDataList.get(0), originPointObj);
                break;

            // Handling if user enters polygon as shape
            case POLYGON:
                shapeObj = new Polygon(shapeDataList.get(0), shapeDataList.get(1), originPointObj);

                break;

            default:
                break;
        }

        return shapeObj;
    }
}
