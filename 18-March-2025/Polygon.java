import java.util.ArrayList;
import java.util.List;

public class Polygon implements Shape {
    public double sideLength;
    public int numberOfSides;
    public Point originPoint;
    public long timeStamp;
    List<Point> allPointsList;

    /**
     * Constructor to create a Square Polygon object
     * 
     * @param side        should be of double type
     * @param originPoint should be of Point Type, holding origin coordinates of the
     *                    shape
     */
    public Polygon(double sideLength, int numberOfSides, Point originPoint) {
        this.sideLength = sideLength;
        this.originPoint = originPoint;
        this.numberOfSides = numberOfSides;
        this.timeStamp = System.currentTimeMillis();
        this.allPointsList = generateAllPointsList();
    }

    /**
     * Method to get the area of polygon
     * 
     * @return area of the polygon
     */
    public double getArea() {
        return ((this.sideLength * this.sideLength * this.numberOfSides) / 4 * Math.tan(Math.PI / this.numberOfSides));
    }

    /**
     * Method to get the perimeter of polygon
     * 
     * @return perimeter of the polygon
     */
    public double getPerimeter() {
        return (2 * this.sideLength * this.numberOfSides);
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
     * Method to get the Point object of a shape which holds the x and y coordinates
     * of a shape
     * 
     * @return Point object holding the x and y coordinates of a shape
     */
    public Point getOrigin() {
        return this.originPoint;
    };

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
        return ShapeType.valueOf("POLYGON");
    }

    /**
     * Method to generate all the coordinates of a Shape
     * 
     * @return List of Point objects where each point object is holding a coordinate
     *         of a shape
     */
    List<Point> generateAllPointsList() {
        List<Point> allPointsList = new ArrayList<Point>();
        double hypotenuse = this.sideLength / (2 * Math.sin(Math.PI / this.numberOfSides));
        double height = (hypotenuse * hypotenuse) - ((this.sideLength / 2) * (this.sideLength / 2));

        double centerXCordinate = this.originPoint.xCordinate / 2;
        double centerYCordinate = this.originPoint.yCordinate + height;

        double centerAngle = 2 * Math.PI / this.numberOfSides;

        double rotatingAngle = Math.atan2(this.originPoint.yCordinate - centerYCordinate,
                this.originPoint.xCordinate - centerXCordinate);

        for (int i = 0; i < this.numberOfSides; i++) {
            double xCoord = centerXCordinate * Math.cos(i * rotatingAngle + centerAngle);
            double yCoord = centerYCordinate * Math.sin(i * rotatingAngle + centerAngle);
            Point pointObj = new Point(xCoord, yCoord);
            allPointsList.add(pointObj);
        }
        return allPointsList;
    }

}
