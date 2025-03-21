import java.util.ArrayList;
import java.util.List;

public class Reactangle implements Shape {

    public double length;
    public double breadth;
    public Point originPoint;
    public long timeStamp;
    List<Point> allPointsList;

    /**
     * Constructor to create a Rectangle shape object
     * 
     * @param length      should be of double type
     * @param breadth     should be of double type
     * @param originPoint should be of Point Type, holding origin coordinates of the
     *                    shape
     */

    public Reactangle(double length, double breadth, Point originPoint) {
        this.length = length;
        this.breadth = breadth;
        this.originPoint = originPoint;
        this.timeStamp = System.currentTimeMillis();
        this.allPointsList = generateAllPointsList();
    }


    public long getTimeStamp(){
        return this.timeStamp;
    }

    public ShapeType getShapeName(){
        return ShapeType.valueOf("RECTANGLE");
    }

    /**
     * Method to get the area of rectangle
     * 
     * @return area of the rectangle
     */
    public double getArea() {
        return (this.length * this.breadth);
    }


    public List<Point> getAllPointsList(){
        return this.allPointsList;
    }
    /**
     * Method to calculate all the points of the rectangle Order: Origin Coordinate,
     * Top Coordinate, Right Cordinate, Diagonal Cordinate
     * 
     * @return list of all points
     */
    List<Point> generateAllPointsList() {
        List<Point> allPointsList = new ArrayList<Point>();
        double topXCordinate = this.originPoint.xCordinate + length;
        double topYCordinate = this.originPoint.yCordinate + length;
        Point topPointObj = new Point(topXCordinate, topYCordinate);
        double rightXCordinate = this.originPoint.xCordinate + breadth;
        double rightYCordinate = this.originPoint.yCordinate + breadth;
        Point rightPointObj = new Point(rightXCordinate, rightYCordinate);
        double digonalXCordinate = this.originPoint.xCordinate + breadth;
        double digonalYCordinate = this.originPoint.yCordinate + breadth;
        Point digonalPointObj = new Point(digonalXCordinate, digonalYCordinate);
        allPointsList.add(this.originPoint);
        allPointsList.add(topPointObj);
        allPointsList.add(rightPointObj);
        allPointsList.add(digonalPointObj);
        return allPointsList;
    }

    /**
     * Method to get the perimeter of rectangle
     * 
     * @return perimeter of the rectangle
     */
    public double getPerimeter() {
        return (2 * (this.length + this.breadth));
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

    
}
