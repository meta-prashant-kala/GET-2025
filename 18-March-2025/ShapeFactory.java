
import java.util.Scanner;
import java.util.List;

public class ShapeFactory {
    public static Shape createShape (ShapeType shape, Point originPointObj, List<Integer> shapeDataList ) {

        Scanner scanInput = new Scanner(System.in);
        Shape shapeObj=null;
        switch (shape) {
            case CIRCLE:
                shapeObj = new Circle(shapeDataList.get(0), originPointObj);
                break;
            case RECTANGLE:
                shapeObj = new Reactangle(shapeDataList.get(0), shapeDataList.get(1), originPointObj);
                break;
            case SQUARE:
                shapeObj = new Square(shapeDataList.get(0), originPointObj);
                break;

            case TRIANGLE:  
                shapeObj = new Triangle(shapeDataList.get(0), originPointObj);
                break;
            case POLYGON:
                shapeObj = new Polygon(shapeDataList.get(0), shapeDataList.get(1), originPointObj);

                break;

            default:
                break;
        }
        
        scanInput.close();
        return shapeObj;
    }
}
