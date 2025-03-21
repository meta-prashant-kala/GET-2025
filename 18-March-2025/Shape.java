import java.util.List;

public interface Shape {

    public double getArea();

    public double getPerimeter();

    public Point getOrigin();

    public ShapeType getShapeName();

    public long getTimeStamp();


    public List<Point> getAllPointsList();


    public default boolean isRayCasting(List<Point> allPointsList, Point pointObj, double xCordinateToCheck,
            double yCordinateToCheck, int index) {

        double xCordinate1 = allPointsList.get(index).xCordinate;
        double yCordinate1 = allPointsList.get(index).yCordinate;
        double xCordinate2 = allPointsList.get((index + 1)%allPointsList.size()).xCordinate;
        double yCordinate2 = allPointsList.get((index + 1)%allPointsList.size()).yCordinate;
        if (yCordinateToCheck <= yCordinate2 && yCordinateToCheck >= yCordinate1) {
            double ratio = ((yCordinateToCheck - yCordinate1) / (yCordinate2 - yCordinate1))*(xCordinate2-xCordinate1);
            if (xCordinateToCheck <= xCordinate1 + ratio) {
                return true;
            }
        }
        return false;
    }

    public default boolean isPointEnclosed(Point pointObj) {
        double xCordinateToCheck = pointObj.xCordinate;
        double yCordinateToCheck = pointObj.yCordinate;
        int count = 0;
        for (int i = 0; i < this.getAllPointsList().size(); i++) {
            boolean isRayCasting = this.isRayCasting(this.getAllPointsList(), pointObj, xCordinateToCheck, yCordinateToCheck, i);
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