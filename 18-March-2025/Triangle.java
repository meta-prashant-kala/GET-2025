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
     * @return the shape name of the shape object
     */
    public ShapeType getShapeName() {
        return ShapeType.valueOf("TRIANGLE");
    }



    /**
     * Method to get the list of point object, where each point is holding the
     * coordinates of a shape, and the list holding all the coordinates of the shape
     * @return the list of point object holding all the coordinates of the shape
     */
    public List<Point> getAllPointsList() {
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
        double topXCordinate = this.originPoint.xCordinate + (sideLength / 2);
        double topYCordinate = this.originPoint.yCordinate + sideLength;
        Point topPointObj = new Point(topXCordinate, topYCordinate);
        double rightXCordinate = this.originPoint.xCordinate + sideLength;
        double rightYCordinate = this.originPoint.yCordinate;
        Point rightPointObj = new Point(rightXCordinate, rightYCordinate);
        allPointsList.add(this.originPoint);
        allPointsList.add(topPointObj);
        allPointsList.add(rightPointObj);
        return allPointsList;
    }
}
