public class AreaCalculator {

    /**
     * Method to calculate area of triangle
     * @param width should be of type double
     * @param height should be of type double
     * @return the area of triangle
     */
    public double areaOfTriangle(double width, double height){
        return (width*height)/2;
    }


    /**
     * Method to calculate area of rectangle
     * @param width should be of type double
     * @param height should be of type double
     * @return the area of rectangle
     */
    public double areaOfRectangle(double width, double height){
        return (width*height);
    }


    /**
     * Method to calculate area of square
     * @param width should be of type double
     * @return the area of square
     */
    public double areaOfSquare(double width){
        return (width*width);
    }


    /**
     * Method to calculate area of circle
     * @param radius should be of type double
     * @return the area of circle
     */
    public double areaOfCircle(double radius){
        return Math.PI*radius*radius;
    }
}
