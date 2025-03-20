public class Triangle implements Shape {
    public double side;
    public Point originPoint;
    public long timeStamp;


        /**
     * Constructor to create a Triangle shape object
     * @param side  should be of double type
     * @param originPoint   should be of Point Type, holding origin coordinates of the shape
     */
    public Triangle(double side, Point originPoint){
        this.side=side;
        this.originPoint=originPoint;
        this.timeStamp=System.currentTimeMillis();
    }


        /**
     * Method to get the area of triangle
     * @return area of the triangle
     */
    public double getArea(){
        return (Math.sqrt(3)/4)*Math.pow(side, 2);
    }

      /**
     * Method to get the perimeter of triangle
     * @return perimeter of the triangle
     */
    public double getPerimeter(){
        return (3*this.side);
    }

        /**
     * Method to get the Point object of a shape which holds the x and y coordinates of a shape
     * @return Point object holding the x and y coordinates of a shape
     */
    public Point getOrigin(){
        return this.originPoint;
    };
}
