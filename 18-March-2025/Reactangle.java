public class Reactangle implements Shape {

    public double length;
    public double breadth;
    public Point originPoint;
    public long timeStamp;

        /**
     * Constructor to create a Rectangle shape object
     * @param length  should be of double type
     * @param breadth  should be of double type
     * @param originPoint   should be of Point Type, holding origin coordinates of the shape
     */

    public Reactangle(double length, double breadth, Point originPoint) {
        this.length = length;
        this.breadth = breadth;
        this.originPoint = originPoint;
        this.timeStamp = System.currentTimeMillis();
    }


    /**
     * Method to get the area of rectangle
     * @return area of the rectangle
     */
    public double getArea() {
        return (this.length * this.breadth);
    }


      /**
     * Method to get the perimeter of rectangle
     * @return perimeter of the rectangle
     */
    public double getPerimeter() {
        return (2 * (this.length + this.breadth));
    }

    /**
     * Method to get the Point object of a shape which holds the x and y coordinates of a shape
     * @return Point object holding the x and y coordinates of a shape
     */
    public Point getOrigin() {
        return this.originPoint;
    };
    // public int isPointEnclosed();
}
