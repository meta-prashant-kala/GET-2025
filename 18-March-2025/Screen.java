import java.util.ArrayList;
import java.util.List;

public class Screen {
    double xMax;
    double yMax;

    List<Shape> shapesOnScreenList = new ArrayList<Shape>();

    public void addShape(Shape shapeObj) {
        shapesOnScreenList.add(shapeObj);
    }

    public boolean deleteShape(ShapeType shapename, Point originPointObj) {
        for (int i = 0; i < shapesOnScreenList.size(); i++) {
            if (shapesOnScreenList.get(i).getShapeName().equals(shapename)
                    && shapesOnScreenList.get(i).getOrigin().xCordinate == originPointObj.xCordinate
                    && shapesOnScreenList.get(i).getOrigin().yCordinate == originPointObj.yCordinate) {
                shapesOnScreenList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean deleteShapeType(ShapeType shapename, Point originPointObj) {
        for (int i = 0; i < shapesOnScreenList.size(); i++) {
            if (shapesOnScreenList.get(i).getShapeName().equals(shapename)) {
                shapesOnScreenList.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Shape> sortShapesBasedOnArea() {
        List<Shape> sortedShapesList = new ArrayList<>(shapesOnScreenList);
        for (int i = 0; i < sortedShapesList.size() - 1; i++) {
            for (int j = i + 1; i < sortedShapesList.size(); j++) {
                if (sortedShapesList.get(i).getArea() > sortedShapesList.get(j).getArea()) {
                    Shape tempShapeObj = sortedShapesList.get(i);
                    sortedShapesList.set(i, sortedShapesList.get(j));
                    sortedShapesList.set(j, tempShapeObj);
                }
            }
        }
        return sortedShapesList;
    }

    public List<Shape> sortShapesBasedOnPerimeter() {
        List<Shape> sortedShapesList = new ArrayList<>(shapesOnScreenList);
        for (int i = 0; i < sortedShapesList.size() - 1; i++) {
            for (int j = i + 1; i < sortedShapesList.size(); j++) {
                if (sortedShapesList.get(i).getPerimeter() > sortedShapesList.get(j).getPerimeter()) {
                    Shape tempShapeObj = sortedShapesList.get(i);
                    sortedShapesList.set(i, sortedShapesList.get(j));
                    sortedShapesList.set(j, tempShapeObj);
                }
            }
        }
        return sortedShapesList;
    }

    public List<Shape> sortShapesBasedOnTimeStamp() {
        List<Shape> sortedShapesList = new ArrayList<>(shapesOnScreenList);
        for (int i = 0; i < sortedShapesList.size() - 1; i++) {
            for (int j = i + 1; i < sortedShapesList.size(); j++) {
                if (sortedShapesList.get(i).getTimeStamp() > sortedShapesList.get(j).getTimeStamp()) {
                    Shape tempShapeObj = sortedShapesList.get(i);
                    sortedShapesList.set(i, sortedShapesList.get(j));
                    sortedShapesList.set(j, tempShapeObj);
                }
            }
        }
        return sortedShapesList;
    }

    public List<Shape> sortShapesBasedOnOriginDistance(){
        List<Shape> sortedShapesList=new ArrayList<>(shapesOnScreenList);
        for(int i=0;i<sortedShapesList.size()-1;i++){
            for(int j=i+1;i<sortedShapesList.size();j++){
                Point originPoint1=sortedShapesList.get(i).getOrigin();
                Point originPoint2=sortedShapesList.get(j).getOrigin();
                double distance1=Math.sqrt((originPoint1.xCordinate-0)+(originPoint1.yCordinate-0)*(originPoint1.xCordinate-0)+(originPoint1.yCordinate-0));
                double distance2=Math.sqrt((originPoint2.xCordinate-0)+(originPoint2.yCordinate-0)*(originPoint2.xCordinate-0)+(originPoint2.yCordinate-0));
                if( distance1>distance2 ){
                    Shape tempShapeObj=sortedShapesList.get(i);
                    sortedShapesList.set(i, sortedShapesList.get(j));
                    sortedShapesList.set(j, tempShapeObj);
                }
            }
        }
        return sortedShapesList;
    }

    public void displayShapes(){
        System.out.println();
        System.out.println("---------Shapes on the screen---------");
        System.out.println();
        for(Shape shapeObj:shapesOnScreenList){
            System.out.println("-> "+shapeObj.getShapeName());
        }
        System.out.println();
    }


    public void displayShapes(List <Shape> shapesOnScreenList){
        System.out.println();
        System.out.println("---------Shapes on the screen---------");
        System.out.println();
        for(Shape shapeObj:shapesOnScreenList){
            System.out.println("-> "+shapeObj.getShapeName());
        }
        System.out.println();
    }

}
