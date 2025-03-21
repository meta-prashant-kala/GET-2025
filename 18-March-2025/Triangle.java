import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape {
    public double sideLength;
    public Point originPoint;
    public long timeStamp;
    List<Point> allPointsList;

    /**
     * Constructor to create a Triangle shape object
     * 
     * @param side        should be of double type
     * @param originPoint should be of Point Type, holding origin coordinates of the
     *                    shape
     */
    public Triangle(double sideLength, Point originPoint) {
        this.sideLength = sideLength;
        this.originPoint = originPoint;
        this.timeStamp = System.currentTimeMillis();
        this.allPointsList = generateAllPointsList();

    }

    public long getTimeStamp(){
        return this.timeStamp;
    }


    public ShapeType getShapeName(){
        return ShapeType.valueOf("TRIANGLE");
    }

    public List<Point> getAllPointsList(){
        return this.allPointsList;
    }
    /**
     * Method to get the area of triangle
     * 
     * @return area of the triangle
     */
    public double getArea() {
        return (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);
    }

    /**
     * Method to get the perimeter of triangle
     * 
     * @return perimeter of the triangle
     */
    public double getPerimeter() {
        return (3 * this.sideLength);
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
     * Method to calculate all the points of the triangle. Order: Origin Coordinate,
     * Top Coordinate, Right Cordinate.
     * 
     * @return list of all points
     */
    List<Point> generateAllPointsList() {
        List<Point> allPointsList = new ArrayList<Point>();
        double topXCordinate = this.originPoint.xCordinate + (sideLength/2);
        double topYCordinate = this.originPoint.yCordinate + (sideLength/2);
        Point topPointObj = new Point(topXCordinate, topYCordinate);
        double rightXCordinate = this.originPoint.xCordinate + sideLength;
        double rightYCordinate = this.originPoint.yCordinate + sideLength;
        Point rightPointObj = new Point(rightXCordinate, rightYCordinate);
        allPointsList.add(this.originPoint);
        allPointsList.add(topPointObj);
        allPointsList.add(rightPointObj);
        return allPointsList;
    }
}
