public class Square implements Shape {

    public double side;
    public Point originPoint;
    public long timeStamp;


    /**
     * Constructor to create a Square shape object
     * @param side  should be of double type
     * @param originPoint   should be of Point Type, holding origin coordinates of the shape
     */
    public Square(double side, Point originPoint){
        this.side=side;
        this.originPoint=originPoint;
        this.timeStamp=System.currentTimeMillis();
    }


        /**
     * Method to get the area of square
     * @return area of the square
     */
    public double getArea(){
        return (this.side*this.side);
    }

      /**
     * Method to get the perimeter of square
     * @return perimeter of the square
     */
    public double getPerimeter(){
        return (2*this.side);
    }

        /**
     * Method to get the Point object of a shape which holds the x and y coordinates of a shape
     * @return Point object holding the x and y coordinates of a shape
     */
    public Point getOrigin(){
        return this.originPoint;
    };
    // public int isPointEnclosed(); 
    
}
