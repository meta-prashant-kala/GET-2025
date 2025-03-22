import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final double xMax = 1000;
    private final double yMax = 1000;

    List<Shape> shapesOnScreenList = new ArrayList<Shape>();

    /**
     * Method to add a shape on the screen
     * 
     * @param shapeObj is the shape object of Shape user want to add
     */
    public boolean addShape(Shape shapeObj) {
        List<Point> generateAllPointsList = shapeObj.getAllPointsList();
        if (shapeObj.getShapeName() != ShapeType.CIRCLE) {
            for (Point point : generateAllPointsList) {
                if (point.xCordinate >= xMax) {
                    return false;
                }
                if (point.yCordinate >= yMax) {
                    return false;
                }
            }
        }
        shapesOnScreenList.add(shapeObj);
        return true;
    }

    /**
     * Method to display all the coordinates of all shapes on the screen
     */
    public void showAllCoordinates() {
        for (Shape shapeObj : this.shapesOnScreenList) {
            List<Point> generateAllPointsList1 = shapeObj.getAllPointsList();
            System.out.println();
            System.out.println("------------------- " + shapeObj.getShapeName() + " -------------------");
            if (shapeObj.getShapeName() == ShapeType.CIRCLE) {
                Circle circleObj = (Circle) shapeObj;
                System.out.print("Origin Coordinates: ");
                System.out.print(circleObj.getOrigin().xCordinate);
                System.out.print(" , ");
                System.out.print(circleObj.getOrigin().yCordinate);
                System.out.println();
                System.out.print("Center Coordinates: ");
                System.out.print(circleObj.getCenterPoint().xCordinate);
                System.out.print(" , ");
                System.out.print(circleObj.getCenterPoint().yCordinate);
                System.out.println();
            } else {
                for (Point point : generateAllPointsList1) {
                    System.out.print(point.xCordinate);
                    System.out.print(" , ");
                    System.out.print(point.yCordinate);
                    System.out.println();
                }
            }
        }
    }

    /**
     * Method to delete a single shape from the screen
     * 
     * @param shapename      is the user input shape name that user wants to delete
     * @param originPointObj should be of Point type holding the x and y coordinates
     *                       user wants to delete
     * @return true if shape deleted succesfull, false deletion failed
     */
    public boolean deleteShape(ShapeType shapename, Point originPointObj) {
        for (int i = 0; i < shapesOnScreenList.size(); i++) {
            if (shapesOnScreenList.get(i).getShapeName().equals(shapename)
                    && shapesOnScreenList.get(i).getOrigin().xCordinate == originPointObj.xCordinate
                    && shapesOnScreenList.get(i).getOrigin().yCordinate == originPointObj.yCordinate) {
                shapesOnScreenList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to delete all the shapes from the screen of a single type
     * 
     * @param shapename is the user input shape name that user wants to delete
     * @return true if shape deleted succesfull, false deletion failed
     */
    public boolean deleteShapeType(ShapeType shapename) {
        for (int i = 0; i < shapesOnScreenList.size(); i++) {
            if (shapesOnScreenList.get(i).getShapeName().equals(shapename)) {
                shapesOnScreenList.remove(i);
            }
        }
        return true;
    }

    /**
     * Method to sort shapes on the screen on the bases of area in ascending order
     * 
     * @return sorted list of shapes on the screen object
     */
    public List<Shape> sortShapesBasedOnArea() {
        List<Shape> sortedShapesList = new ArrayList<Shape>(shapesOnScreenList);
        for (int i = 0; i < sortedShapesList.size() - 1; i++) {
            for (int j = i + 1; j < sortedShapesList.size(); j++) {
                if (sortedShapesList.get(i).getArea() > sortedShapesList.get(j).getArea()) {
                    Shape tempShapeObj = sortedShapesList.get(i);
                    sortedShapesList.set(i, sortedShapesList.get(j));
                    sortedShapesList.set(j, tempShapeObj);
                }
            }
        }
        return sortedShapesList;
    }

    /**
     * Method to sort shapes on the screen on the bases of perimeter in ascending
     * order
     * 
     * @return sorted list of shapes on the screen object
     */
    public List<Shape> sortShapesBasedOnPerimeter() {
        List<Shape> sortedShapesList = new ArrayList<Shape>(shapesOnScreenList);
        for (int i = 0; i < sortedShapesList.size() - 1; i++) {
            for (int j = i + 1; j < sortedShapesList.size(); j++) {
                if (sortedShapesList.get(i).getPerimeter() > sortedShapesList.get(j).getPerimeter()) {
                    Shape tempShapeObj = sortedShapesList.get(i);
                    sortedShapesList.set(i, sortedShapesList.get(j));
                    sortedShapesList.set(j, tempShapeObj);
                }
            }
        }
        return sortedShapesList;
    }

    /**
     * Method to sort shapes on the screen on the bases of Time stamp in ascending
     * order
     * 
     * @return sorted list of shapes on the screen object
     */
    public List<Shape> sortShapesBasedOnTimeStamp() {
        List<Shape> sortedShapesList = new ArrayList<Shape>(shapesOnScreenList);
        for (int i = 0; i < sortedShapesList.size() - 1; i++) {
            for (int j = i + 1; j < sortedShapesList.size(); j++) {
                if (sortedShapesList.get(i).getTimeStamp() > sortedShapesList.get(j).getTimeStamp()) {
                    Shape tempShapeObj = sortedShapesList.get(i);
                    sortedShapesList.set(i, sortedShapesList.get(j));
                    sortedShapesList.set(j, tempShapeObj);
                }
            }
        }
        return sortedShapesList;
    }

    /**
     * Method to sort shapes on the screen on the bases of distance from the origin
     * in ascending order
     * 
     * @return sorted list of shapes on the screen object
     */
    public List<Shape> sortShapesBasedOnOriginDistance() {
        List<Shape> sortedShapesList = new ArrayList<Shape>(shapesOnScreenList);
        for (int i = 0; i < sortedShapesList.size() - 1; i++) {
            for (int j = i + 1; j < sortedShapesList.size(); j++) {
                Point originPoint1 = sortedShapesList.get(i).getOrigin();
                Point originPoint2 = sortedShapesList.get(j).getOrigin();
                double distance1 = Math.sqrt(
                        (originPoint1.xCordinate - 0) + (originPoint1.yCordinate - 0) * (originPoint1.xCordinate - 0)
                                + (originPoint1.yCordinate - 0));
                double distance2 = Math.sqrt(
                        (originPoint2.xCordinate - 0) + (originPoint2.yCordinate - 0) * (originPoint2.xCordinate - 0)
                                + (originPoint2.yCordinate - 0));
                if (distance1 > distance2) {
                    Shape tempShapeObj = sortedShapesList.get(i);
                    sortedShapesList.set(i, sortedShapesList.get(j));
                    sortedShapesList.set(j, tempShapeObj);
                }
            }
        }
        return sortedShapesList;
    }

    /**
     * Method to display the shaps present on the scree
     */
    public void displayShapes() {
        System.out.println();
        System.out.println("---------Shapes on the screen---------");
        System.out.println();
        for (Shape shapeObj : shapesOnScreenList) {
            System.out.println("-> " + shapeObj.getShapeName());
        }
        System.out.println();
    }

    /**
     * Method to display the shapes user provided in the form of arraylist
     * 
     * @param shapesOnScreenList the shapes list user wants to see
     */
    public void displayShapes(List<Shape> shapesOnScreenList) {
        System.out.println();
        System.out.println("---------Shapes on the screen---------");
        System.out.println();
        for (Shape shapeObj : shapesOnScreenList) {
            System.out.println("-> " + shapeObj.getShapeName());
        }
        System.out.println();
    }

    /**
     * Method to get a specific shape from the screen object
     * 
     * @param shapename      shape user want to get from the screen
     * @param originPointObj of the shape user want to get
     * @return Shape object if the shape exist ont the screen other wise null
     */
    public Shape getShape(ShapeType shapename, Point originPointObj) {
        Shape shapeObj = null;
        for (int i = 0; i < shapesOnScreenList.size(); i++) {
            if (shapesOnScreenList.get(i).getShapeName().equals(shapename)
                    && shapesOnScreenList.get(i).getOrigin().xCordinate == originPointObj.xCordinate
                    && shapesOnScreenList.get(i).getOrigin().yCordinate == originPointObj.yCordinate) {
                shapeObj = shapesOnScreenList.get(i);
                break;

            }
        }
        return shapeObj;
    }
}
