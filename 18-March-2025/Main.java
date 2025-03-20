import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        List<Integer> shapeDataList = new ArrayList<Integer>();
        int length;
        int breadth;
        double xCordinate;
        double yCordinate;
        Point originPointObj;
        int sideLength;
        Shape createdShapeObj = null;

        System.out.println("Enter the shape you want to draw in capital letter");
        String shapeType = scanInput.nextLine();
        ShapeType shapeName = ShapeType.valueOf(shapeType);

        switch (shapeName) {
            case CIRCLE:
                System.out.println("Enter the radius of the circle");
                int radius = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the x cordinate");
                xCordinate = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the y cordinate");
                yCordinate = Integer.parseInt(scanInput.nextLine());
                originPointObj = new Point(xCordinate, yCordinate);
                shapeDataList.add(radius);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;
            case RECTANGLE:
                System.out.println("Enter the length of the circle");
                length = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the Breadth of the circle");
                breadth = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the x cordinate");
                xCordinate = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the y cordinate");
                yCordinate = Integer.parseInt(scanInput.nextLine());
                originPointObj = new Point(xCordinate, yCordinate);
                shapeDataList.add(length);
                shapeDataList.add(breadth);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;
            case SQUARE:
                System.out.println("Enter the radius of the circle");
                sideLength = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the x cordinate");
                xCordinate = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the y cordinate");
                yCordinate = Integer.parseInt(scanInput.nextLine());
                originPointObj = new Point(xCordinate, yCordinate);
                shapeDataList.add(sideLength);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;

            case Triangle:
                System.out.println("Enter the radius of the circle");
                sideLength = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the x cordinate");
                xCordinate = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the y cordinate");
                yCordinate = Integer.parseInt(scanInput.nextLine());
                originPointObj = new Point(xCordinate, yCordinate);
                shapeDataList.add(sideLength);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;
            case POLYGON:
                System.out.println("Enter the radius of the circle");
                sideLength = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the number of sides");
                int numbOfSides = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the x cordinate");
                xCordinate = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the y cordinate");
                yCordinate = Integer.parseInt(scanInput.nextLine());
                originPointObj = new Point(xCordinate, yCordinate);
                shapeDataList.add(sideLength);
                shapeDataList.add(numbOfSides);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;
            default:
                break;
        }

        scanInput.close();
        // return shapeObj;
    }
}
