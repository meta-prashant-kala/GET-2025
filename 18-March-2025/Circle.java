
import java.util.List;

public class Circle implements Shape {
    public double radius;
    public Point originPoint;
    public Point centerPoint;
    public long timeStamp;
    List<Point> allPointsList;

    /**
     * Constructor to create a Circle shape object
     * 
     * @param side        should be of double type
     * @param originPoint should be of Point Type, holding origin coordinates of the
     *                    shape
     */
    public Circle(double radius, Point originPoint) {
        this.radius = radius;
        this.originPoint = originPoint;
        this.timeStamp = System.currentTimeMillis();
        this.centerPoint = this.getCenterPoint();
    }

    /**
     * Method to get the radius of the circle
     * 
     * @return radius of the circle
     */
    public double getRadius() {
        return this.radius;
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
        return ShapeType.valueOf("CIRCLE");
    }

    public List<Point> getAllPointsList() {
        return this.allPointsList;
    }

    /**
     * Method to get the area of circle
     * 
     * @return area of the circle
     */
    public double getArea() {
        return (this.radius * this.radius);
    }

    /**
     * Method to get the perimeter of circle
     * 
     * @return perimeter of the circle
     */
    public double getPerimeter() {
        return (2 * this.radius);
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
     * Method to generate the point of a circle using the given coordinates
     * 
     * @return Point object holding the center coordinates of the circle
     */
    public Point getCenterPoint() {
        double angle = Math.atan(originPoint.yCordinate / originPoint.xCordinate);
        double xCenter = this.radius + (radius * Math.cos(angle));
        double yCenter = this.radius + (radius * Math.sin(angle));
        Point centerPoint = new Point(xCenter, yCenter);
        return centerPoint;
    }

}
