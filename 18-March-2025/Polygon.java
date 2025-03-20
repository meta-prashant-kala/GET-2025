public class Polygon implements Shape{
    public double side;
    public Point originPoint;
    public long timeStamp;



        /**
     * Constructor to create a Square Polygon object
     * @param side  should be of double type
     * @param originPoint   should be of Point Type, holding origin coordinates of the shape
     */
    public Polygon(double side, Point originPoint){
        this.side=side;
        this.originPoint=originPoint;
        this.timeStamp=System.currentTimeMillis();
    }


        /**
     * Method to get the area of polygon
     * @return area of the polygon
     */
    public double getArea(){
        // return (this.lenght*this.breadth);
        return 1;
    }

        /**
     * Method to get the perimeter of polygon
     * @return perimeter of the polygon
     */
    public double getPerimeter(){
        // return (2*(this.lenght+this.breadth));
        return 1;
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
