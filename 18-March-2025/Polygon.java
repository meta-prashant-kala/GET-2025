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
        return ((this.sideLength*this.sideLength*this.numberOfSides)/4*Math.tan(Math.PI/this.numberOfSides));
    }

    /**
     * Method to get the perimeter of polygon
     * 
     * @return perimeter of the polygon
     */
    public double getPerimeter() {
        return (2*this.sideLength*this.numberOfSides);
    }


    public List<Point> getAllPointsList(){
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


    public long getTimeStamp(){
        return this.timeStamp;
    }

    public ShapeType getShapeName(){
        return ShapeType.valueOf("POLYGON");
    }

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

    // public int isPointEnclosed();
}
