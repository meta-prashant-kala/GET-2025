import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanInput = new Scanner(System.in);

    // Method to create Circle on the screen initially
    public static Shape createInitialShapeCircle() {
        List<Integer> shapeDataList = new ArrayList<Integer>();
        Point originPointObj = new Point(10, 10);
        shapeDataList.add(5);
        Shape createdShapeObj = ShapeFactory.createShape(ShapeType.CIRCLE, originPointObj, shapeDataList);
        return createdShapeObj;
    }

    // Method to create Rectangle on the screen initially
    public static Shape createInitialShapeRectangle() {
        List<Integer> shapeDataList = new ArrayList<Integer>();
        Point originPointObj = new Point(2, 2);
        shapeDataList.add(4);
        shapeDataList.add(8);
        Shape createdShapeObj = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj, shapeDataList);
        return createdShapeObj;
    }

    // Method to create Square on the screen initially
    public static Shape createInitialShapeSquare() {
        List<Integer> shapeDataList = new ArrayList<Integer>();
        Point originPointObj = new Point(2, 4);
        shapeDataList.add(3);
        Shape createdShapeObj = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj, shapeDataList);
        return createdShapeObj;
    }

    // Method to create Triangle on the screen initially
    public static Shape createInitialShapeTriangle() {
        List<Integer> shapeDataList = new ArrayList<Integer>();
        Point originPointObj = new Point(6, 2);
        shapeDataList.add(10);
        Shape createdShapeObj = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj, shapeDataList);
        return createdShapeObj;
    }

    // Method to create a shape on user selected option on the screen
    public static Shape createShape() {

        List<Integer> shapeDataList = new ArrayList<Integer>();
        int length;
        int breadth;
        double xCordinate;
        double yCordinate;
        Point originPointObj;
        int sideLength;
        ShapeType shapeName;

        Shape createdShapeObj = null;

        System.out.println("Enter the shape you want to add on the screen in capital letter");

        while (true) {
            try {
                String shapeType = scanInput.nextLine();
                shapeName = ShapeType.valueOf(shapeType);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid shape");
                continue;
            }

        }

        while (true) {
            try {
                System.out.println("Enter the x cordinate");
                xCordinate = Double.parseDouble(scanInput.nextLine());
                System.out.println("Enter the y cordinate");
                yCordinate = Double.parseDouble(scanInput.nextLine());
                originPointObj = new Point(xCordinate, yCordinate);
                break;
            } catch (Exception e) {
                System.out.println("Enter valid coordinates");
                continue;
            }
        }

        while (true) {
            switch (shapeName) {
                case CIRCLE:
                    int radius;
                    try {
                        System.out.println("Enter the radius of the circle");
                        radius = Integer.parseInt(scanInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please enter valid details");
                        continue;
                    }
                    shapeDataList.add(radius);
                    createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                    break;
                case RECTANGLE:
                    try {
                        System.out.println("Enter the length of the rectangle");
                        length = Integer.parseInt(scanInput.nextLine());
                        System.out.println("Enter the breadth of the rectangle");
                        breadth = Integer.parseInt(scanInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please enter valid details");
                        continue;
                    }
                    shapeDataList.add(length);
                    shapeDataList.add(breadth);
                    createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                    break;
                case SQUARE:
                    try {
                        System.out.println("Enter the length of a side");
                        sideLength = Integer.parseInt(scanInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please enter valid details");
                        continue;
                    }
                    shapeDataList.add(sideLength);
                    createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                    break;

                case TRIANGLE:
                    try {
                        System.out.println("Enter the length of a side");
                        sideLength = Integer.parseInt(scanInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please enter valid details");
                        continue;
                    }
                    shapeDataList.add(sideLength);
                    createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                    break;
                case POLYGON:
                    int numbOfSides;
                    try {
                        System.out.println("Enter the length of a side");
                        sideLength = Integer.parseInt(scanInput.nextLine());
                        System.out.println("Enter the number of sides");
                        numbOfSides = Integer.parseInt(scanInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("Please enter valid details");
                        continue;
                    }
                    shapeDataList.add(sideLength);
                    shapeDataList.add(numbOfSides);
                    createdShapeObj = ShapeFactory.createShape(shapeName, originPointObj, shapeDataList);
                    break;
                default:
                    break;
            }
            break;
        }
        return createdShapeObj;
    }

    // Method to delete a shape on user selected option from the screen
    public static boolean deleteShape(Screen screenObj) {

        double xCordinate;
        double yCordinate;
        Point originPointObj;
        ShapeType shapeName;

        System.out.println("Enter the shape you want to remove on the screen in capital letter");
        while (true) {
            try {
                String shapeType = scanInput.nextLine();
                shapeName = ShapeType.valueOf(shapeType);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid shape");
                continue;
            }

        }

        while (true) {
            try {
                System.out.println("Enter the x cordinate of the shape");
                xCordinate = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the y cordinate of the shape");
                yCordinate = Integer.parseInt(scanInput.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter valid coordinates");
                continue;
            }
        }
        originPointObj = new Point(xCordinate, yCordinate);

        return screenObj.deleteShape(shapeName, originPointObj);

    }

    // Mehthod to delete all shapes of same time from the screen
    public static boolean deleteAllShapeOfType(Screen screenObj) {
        ShapeType shapeName;
        System.out.println("Enter the shape you want to remove on the screen in capital letter");
        while (true) {
            try {
                String shapeType = scanInput.nextLine();
                shapeName = ShapeType.valueOf(shapeType);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid shape");
                continue;
            }

        }

        return screenObj.deleteShapeType(shapeName);
    }

    // Method to get the sorted shapes list as per user preferenece
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

    // Method to get to know the number of shapes enclosing a point
    public static List<Shape> getEnclosingShapes(Screen screenObj) {
        List<Shape> enclosedShapesList = new ArrayList<Shape>();

        double xCordinate;
        double yCordinate;

        System.out.println("Enter the coordinates to check");
        System.out.println();

        while (true) {
            try {
                System.out.println("Enter the x cordinate");
                xCordinate = Double.parseDouble(scanInput.nextLine());
                System.out.println("Enter the y cordinate");
                yCordinate = Double.parseDouble(scanInput.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter valid coordinates");
                continue;
            }
        }
        Point originPointObj = new Point(xCordinate, yCordinate);

        for (Shape shapeObj : screenObj.shapesOnScreenList) {
            if (shapeObj.isPointEnclosed(originPointObj)) {
                enclosedShapesList.add(shapeObj);
            }
        }
        return enclosedShapesList;

    }

    // Method to get to a specific shape from the screen object
    public static Shape getShape(Screen screenObj) {

        double xCordinate;
        double yCordinate;
        Point originPointObj;
        ShapeType shapeName;

        while (true) {
            try {
                String shapeType = scanInput.nextLine();
                shapeName = ShapeType.valueOf(shapeType);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid shape");
                continue;
            }

        }
        while (true) {
            try {
                System.out.println("Enter the x cordinate of the shape");
                xCordinate = Integer.parseInt(scanInput.nextLine());
                System.out.println("Enter the y cordinate of the shape");
                yCordinate = Integer.parseInt(scanInput.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter valid coordinates");
                continue;
            }
        }
        originPointObj = new Point(xCordinate, yCordinate);

        Shape shapeObj = screenObj.getShape(shapeName, originPointObj);
        return shapeObj;
    }

    // Main Method
    public static void main(String[] args) {

        Screen screenObj = new Screen();
        SortType sortName;

        // Initailising few shapes on the screen object
        Shape circleShape = createInitialShapeCircle();
        Shape rectangleShape = createInitialShapeRectangle();
        Shape squareShape = createInitialShapeSquare();
        Shape triangleShape = createInitialShapeTriangle();
        screenObj.addShape(rectangleShape);
        screenObj.addShape(circleShape);
        screenObj.addShape(squareShape);
        screenObj.addShape(triangleShape);

        // Showing the initiall shapes on the screen to the user
        screenObj.displayShapes();

        // Showing coordinates of all the shapes on the screen
        System.out.println("Coordinates of all shape");
        screenObj.showAllCoordinates();
        System.out.println();

        int selectedOption = 1;

        while (selectedOption != 0) {
            System.out.println();
            System.out.println("1. To add a shape on the screen");
            System.out.println("2. To delete a shape from the screen");
            System.out.println("3. To delete all shapes of same type from the screen");
            System.out.println("4. To get the shapes in specific order");
            System.out.println("5. To get the list of shape objects enclosing a specified point");
            System.out.println("6. To check if a point is enclosed by a specific shape");
            System.out.println("7. To get the list of shapes on the screen");
            System.out.println("8. To get the list of coordinates of all shapes on the screen");
            System.out.println("0. To exit from the app");
            System.out.println();

            // Taking selected option as input from the user
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }

            System.out.println();
            switch (selectedOption) {

                // Handling add a shape on the screen
                case 1:
                    Shape createdShapeObj = createShape();
                    boolean isShapeAdded = screenObj.addShape(createdShapeObj);
                    System.out.println();
                    if (isShapeAdded) {
                        System.out.println(createdShapeObj.getShapeName() + " added successfully on the screen");
                    } else {
                        System.out.println(
                                createdShapeObj.getShapeName() + " shape coordinates exceeds the screen limit");
                    }
                    System.out.println();
                    break;

                // Handling delete a shape from the screen
                case 2:
                    boolean isShapeRemoved = deleteShape(screenObj);
                    if (isShapeRemoved) {
                        System.out.println("Shape removed succesfully");
                    } else {
                        System.out.println("Shape does not exist on the screen");
                    }
                    break;
                // Handling delete all shapes of same type from the screen
                case 3:
                    boolean isShapeTypeRemoved = deleteAllShapeOfType(screenObj);
                    if (isShapeTypeRemoved) {
                        System.out.println("Shape removed succesfully");
                    } else {
                        System.out.println("Shape does not exist on the screen");
                    }
                    break;

                // Handling get the shapes in specific order
                case 4:
                    System.out.println("Enter the sort type in capital letters");
                    System.out.println("->AREA");
                    System.out.println("->PERIMETER");
                    System.out.println("->TIMESTAMP");
                    System.out.println("->ORIGINDISTANCE");
                    System.out.println();
                    ;
                    while (true) {
                        try {
                            String sortType = scanInput.nextLine();
                            sortName = SortType.valueOf(sortType);
                            break;
                        } catch (Exception e) {
                            System.out.println("Please enter a valid parameter to sort");
                            continue;
                        }
                    }
                    List<Shape> sortedList = sortShapes(screenObj, sortName);
                    screenObj.displayShapes(sortedList);
                    break;

                // Handling get the list of shape objects enclosing a specified point
                case 5:
                    List<Shape> enclosedShapeList = getEnclosingShapes(screenObj);
                    screenObj.displayShapes(enclosedShapeList);
                    break;

                // Handling check if a point is enclosed by a specific shape
                case 6:
                    Shape shapeObj = getShape(screenObj);
                    if (shapeObj != null) {
                        boolean isExist = shapeObj.isPointEnclosed(shapeObj.getOrigin());
                        if (isExist) {
                            System.out.println("This point is enclosed by " + shapeObj.getShapeName());
                        } else {
                            System.out.println("This point is not enclosed by " + shapeObj.getShapeName());
                        }
                    } else {
                        System.out.println("Shape does not exist on the screen");
                    }
                    break;

                // Handling get the list of shapes on the screen
                case 7:
                    screenObj.displayShapes();
                    break;

                // Handling get the list of coordinates of all shapes on the screen
                case 8:
                    screenObj.showAllCoordinates();
                    break;

                // Handling exit from the app
                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }

    }
}
