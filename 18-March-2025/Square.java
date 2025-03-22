import java.util.ArrayList;
import java.util.List;

public class Square implements Shape {

    public double sideLength;
    public Point originPoint;
    public long timeStamp;
    List<Point> allPointsList;

    /**
     * Constructor to create a Square shape object
     * 
     * @param side        should be of double type
     * @param originPoint should be of Point Type, holding origin coordinates of the
     *                    shape
     */
    public Square(double sideLength, Point originPoint) {
        this.sideLength = sideLength;
        this.originPoint = originPoint;
        this.timeStamp = System.currentTimeMillis();
        this.allPointsList = generateAllPointsList();
    }

    /**
     * Method to get the time at which the shape is created
     * 
     * @return the time stamp at which the shape is created
     */
    public long getTimeStamp() {
        return this.timeStamp;
    }

    /**
     * Method to get the name of shape
     * 
     * @return the shape name of the shape object
     */
    public ShapeType getShapeName() {
        return ShapeType.valueOf("SQUARE");
    }

    /**
     * Method to get the list of point object, where each point is holding the
     * coordinates of a shape, and the list holding all the coordinates of the shape
     * 
     * @return the list of point object holding all the coordinates of the shape
     */
    public List<Point> getAllPointsList() {
        return this.allPointsList;
    }

    /**
     * Method to get the area of square
     * 
     * @return area of the square
     */
    public double getArea() {
        return (this.sideLength * this.sideLength);
    }

    /**
     * Method to get the perimeter of square
     * 
     * @return perimeter of the square
     */
    public double getPerimeter() {
        return (2 * this.sideLength);
    }

    /**
     * Method to get the Point object of a shape which holds the x and y coordinates
     * of a shape
     * 
     * @return Point object holding the x and y coordinates of a shape
     */
    public Point getOrigin() {
        return this.originPoint;
    };

    /**
     * Method to calculate all the points of the square Order: Origin Coordinate,
     * Top Coordinate, Right Cordinate, Diagonal Cordinate
     * 
     * @return list of all points
     */
    List<Point> generateAllPointsList() {
        List<Point> allPointsList = new ArrayList<Point>();
        double topXCordinate = this.originPoint.xCordinate;
        double topYCordinate = this.originPoint.yCordinate + sideLength;
        Point topPointObj = new Point(topXCordinate, topYCordinate);
        double rightXCordinate = this.originPoint.xCordinate + sideLength;
        double rightYCordinate = this.originPoint.yCordinate;
        Point rightPointObj = new Point(rightXCordinate, rightYCordinate);
        double digonalXCordinate = this.originPoint.xCordinate + sideLength;
        double digonalYCordinate = this.originPoint.yCordinate + sideLength;
        Point digonalPointObj = new Point(digonalXCordinate, digonalYCordinate);
        allPointsList.add(this.originPoint);
        allPointsList.add(topPointObj);
        allPointsList.add(rightPointObj);
        allPointsList.add(digonalPointObj);
        return allPointsList;
    }

}
