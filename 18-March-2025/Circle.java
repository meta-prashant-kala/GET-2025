public class Circle implements Shape {
    public double radius;
    public Point originPoint;
    public long timeStamp;


        /**
     * Constructor to create a Circle shape object
     * @param side  should be of double type
     * @param originPoint   should be of Point Type, holding origin coordinates of the shape
     */
    public Circle(double radius, Point originPoint){
        this.radius=radius;
        this.originPoint=originPoint;
        this.timeStamp=System.currentTimeMillis();
    }


        /**
     * Method to get the area of circle
     * @return area of the circle
     */
    public double getArea(){
        return (this.radius*this.radius);
    }

      /**
     * Method to get the perimeter of circle
     * @return perimeter of the circle
     */
    public double getPerimeter(){
        return (2*this.radius);
    }

        /**
     * Method to get the Point object of a shape which holds the x and y coordinates of a shape
     * @return Point object holding the x and y coordinates of a shape
     */
    public Point getOrigin(){
        return this.originPoint;
    };
}
