
public interface Shape {

    enum ShapeType {
        CIRCLE,
        SQUARE,
        RECTANGLE,
        TRIANGLE,
        POLYGON
    }
    public double getArea();
    public double getPerimeter();
    public Point getOrigin();
    // public int isPointEnclosed(); 

    
} 