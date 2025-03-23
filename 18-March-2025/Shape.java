import java.util.List;

public interface Shape {

    public double getArea();

    public double getPerimeter();

    public Point getOrigin();

    public ShapeType getShapeName();

    public long getTimeStamp();

    public List<Point> getAllPointsList();

    /**
     * Method to check if a point will cross a line if the point is casting a line
     * from its position to xMax
     * 
     * @param allPointsList List of points of a shape which completes the shape
     * @param pointObj      is the point for which user want to check
     * @param index         is the index of shape where the shape exist in the
     *                      shpaelist of screen.
     * @return true, if ray casted by a point crosses the Line of a shape, otherwise
     *         false
     */
    public default boolean isRayCasting(List<Point> allPointsList, Point pointToCheckObj, int index) {

        double xCordinate1 = allPointsList.get(index).xCordinate;
        double yCordinate1 = allPointsList.get(index).yCordinate;
        double xCordinate2 = allPointsList.get((index + 1) % allPointsList.size()).xCordinate;
        double yCordinate2 = allPointsList.get((index + 1) % allPointsList.size()).yCordinate;
        if (pointToCheckObj.yCordinate <= yCordinate2 && pointToCheckObj.yCordinate >= yCordinate1) {
            double ratio = ((pointToCheckObj.yCordinate - yCordinate1) / (yCordinate2 - yCordinate1))
                    * (xCordinate2 - xCordinate1);
            if (pointToCheckObj.xCordinate >= xCordinate1 + ratio) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check if a point is enclosed by a shape.
     * 
     * @param pointObj is the Point for which user wants to check if its enclosed by
     *                 a shape
     * @return true if the point is enclosed, false if not enclosed
     */
    public default boolean isPointEnclosed(Point pointObj) {
        double xCordinateToCheck = pointObj.xCordinate;
        double yCordinateToCheck = pointObj.yCordinate;
        Point pointToCheckObj = new Point(xCordinateToCheck, yCordinateToCheck);
        int count = 0;
        for (int i = 0; i < this.getAllPointsList().size(); i++) {
            boolean isRayCasting = this.isRayCasting(this.getAllPointsList(), pointToCheckObj, i);
            if (isRayCasting) {
                count++;
            }
        }
        if (count % 2 == 0) {
            return false;
        }
        return true;
    }

}
