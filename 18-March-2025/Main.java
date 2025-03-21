import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static Scanner scanInput = new Scanner(System.in);

    public static Shape createShape() {

        List<Integer> shapeDataList = new ArrayList<Integer>();
        int length;
        int breadth;
        double xCordinate;
        double yCordinate;
        Point originPointObj;
        int sideLength;

        Shape createdShapeObj = null;

        System.out.println("Enter the shape you want to add on the screen in capital letter");
        String shapeType = scanInput.nextLine();
        ShapeType shapeName = ShapeType.valueOf(shapeType);

        System.out.println("Enter the x cordinate");
        xCordinate = Double.parseDouble(scanInput.nextLine());
        System.out.println("Enter the y cordinate");
        yCordinate = Double.parseDouble(scanInput.nextLine());
        originPointObj = new Point(xCordinate, yCordinate);

        switch (shapeName) {
            case CIRCLE:
                System.out.println("Enter the radius of the circle");
                int radius = Integer.parseInt(scanInput.nextLine());
                shapeDataList.add(radius);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;
            case RECTANGLE:
                System.out.println("Enter the length of the rectangle");
                length = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the breadth of the rectangle");
                breadth = Integer.parseInt(scanInput.nextLine());
                shapeDataList.add(length);
                shapeDataList.add(breadth);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;
            case SQUARE:
                System.out.println("Enter the length of a side");
                sideLength = Integer.parseInt(scanInput.nextLine());
                shapeDataList.add(sideLength);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;

            case TRIANGLE:
                System.out.println("Enter the length of a side");
                sideLength = Integer.parseInt(scanInput.nextLine());
                shapeDataList.add(sideLength);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;
            case POLYGON:
                System.out.println("Enter the length of a side");
                sideLength = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the number of sides");
                int numbOfSides = Integer.parseInt(scanInput.nextLine());
                shapeDataList.add(sideLength);
                shapeDataList.add(numbOfSides);
                createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                break;
            default:
                break;
        }
        return createdShapeObj;
    }

    public static boolean deleteShape(Screen screenObj) {

        double xCordinate;
        double yCordinate;
        Point originPointObj;

        System.out.println("Enter the shape you want to remove on the screen in capital letter");
        String shapeType = scanInput.nextLine();
        ShapeType shapeName = ShapeType.valueOf(shapeType);
        System.out.println("Enter the x cordinate of the shape");
        xCordinate = Integer.parseInt(scanInput.nextLine());
        System.out.println("Enter the y cordinate of the shape");
        yCordinate = Integer.parseInt(scanInput.nextLine());
        originPointObj = new Point(xCordinate, yCordinate);

        return screenObj.deleteShape(shapeName, originPointObj);

    }

    public static boolean deleteAllShapeOfType(Screen screenObj) {
        double xCordinate;
        double yCordinate;
        Point originPointObj;

        System.out.println("Enter the shape you want to remove on the screen in capital letter");
        String shapeType = scanInput.nextLine();
        ShapeType shapeName = ShapeType.valueOf(shapeType);
        System.out.println("Enter the x cordinate of the shape");
        xCordinate = Integer.parseInt(scanInput.nextLine());
        System.out.println("Enter the y cordinate of the shape");
        yCordinate = Integer.parseInt(scanInput.nextLine());
        originPointObj = new Point(xCordinate, yCordinate);

        return screenObj.deleteShapeType(shapeName, originPointObj);
    }

    public static List<Shape> sortShapes(Screen screenObj, SortType sortType) {

        List<Shape> sortedShapeList = null;

        switch (sortType) {
            case AREA:
                sortedShapeList = screenObj.sortShapesBasedOnArea();
                break;
            case PERIMETER:
                sortedShapeList = screenObj.sortShapesBasedOnPerimeter();
                break;
            case TIMESTAMP:
                sortedShapeList = screenObj.sortShapesBasedOnTimeStamp();
                break;
            case ORIGINDISTANCE:
                sortedShapeList = screenObj.sortShapesBasedOnOriginDistance();
                break;

            default:
                break;
        }
        return sortedShapeList;
    }

    public static void main(String[] args) {

        Screen screenObj = new Screen();

        // Providing menu to the user
        int selectedOption = 1;
        while (selectedOption != 0) {
            System.out.println("1. To add a shape on the screen");
            System.out.println("2. To delete a shape from the screen");
            System.out.println("3. To delete all shapes of same type from the screen");
            System.out.println("4. To get the shapes in specific order");
            System.out.println("5. To get the pay slip of an employee");
            System.out.println("0. To exit from the app");

            // Taking selected option as input from the user
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }

            switch (selectedOption) {
                case 1:
                    Shape createdShapeObj = createShape();
                    screenObj.addShape(createdShapeObj);
                    screenObj.displayShapes();
                    break;

                case 2:
                    boolean isShapeRemoved = deleteShape(screenObj);
                    if (isShapeRemoved) {
                        System.out.println("Shape removed succesfully");
                    } else {
                        System.out.println("Shape does not exist on the screen");
                    }
                    screenObj.displayShapes();
                    break;

                case 3:
                    boolean isShapeTypeRemoved = deleteAllShapeOfType(screenObj);
                    if (isShapeTypeRemoved) {
                        System.out.println("Shape removed succesfully");
                    } else {
                        System.out.println("Shape does not exist on the screen");
                    }
                    screenObj.displayShapes();
                    break;
                case 4:
                    System.out.println("Enter the sort type");
                    System.out.println("->AREA");
                    System.out.println("->PERIMETER");
                    System.out.println("->TIMESTAMP");
                    System.out.println("->ORIGINDISTANCE");
                    String sortType = scanInput.nextLine();
                    SortType sortName = SortType.valueOf(sortType);
                    List<Shape> sortedList = sortShapes(screenObj, sortName);
                    screenObj.displayShapes(sortedList);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
            // scanInput.nextLine();
        }

        // return shapeObj;
        // scanInput.close();
    }
}
