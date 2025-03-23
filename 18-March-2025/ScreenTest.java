import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ScreenTest {

    @Test
    public void addShape() {
        Screen screenObj = new Screen();

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(4, 4);
        shapeDataList2.add(4);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj2, shapeDataList2);

        List<Integer> shapeDataList3 = new ArrayList<Integer>();
        Point originPointObj3 = new Point(1001, 4);
        shapeDataList3.add(4);
        Shape createdShapeObj3 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj3, shapeDataList3);

        List<Integer> shapeDataList4 = new ArrayList<Integer>();
        Point originPointObj4 = new Point(990, 995);
        shapeDataList4.add(9);
        Shape createdShapeObj4 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj4, shapeDataList4);

        assertTrue(screenObj.addShape(createdShapeObj1));
        assertTrue(screenObj.addShape(createdShapeObj2));
        assertFalse(screenObj.addShape(createdShapeObj3));
        assertFalse(screenObj.addShape(createdShapeObj4));
    }

    @Test
    public void deleteShape() {
        Screen screenObj = new Screen();

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(4, 4);
        shapeDataList2.add(4);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj2, shapeDataList2);

        List<Integer> shapeDataList3 = new ArrayList<Integer>();
        Point originPointObj3 = new Point(100, 4);
        shapeDataList3.add(4);
        Shape createdShapeObj3 = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj3, shapeDataList3);

        List<Integer> shapeDataList4 = new ArrayList<Integer>();
        Point originPointObj4 = new Point(990, 995);
        shapeDataList4.add(9);
        Shape createdShapeObj4 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj4, shapeDataList4);

        screenObj.addShape(createdShapeObj1);
        screenObj.addShape(createdShapeObj2);
        screenObj.addShape(createdShapeObj3);
        screenObj.addShape(createdShapeObj4);

        assertTrue(screenObj.deleteShape(ShapeType.RECTANGLE, new Point(2, 2)));
        assertTrue(screenObj.deleteShape(ShapeType.SQUARE, new Point(4, 4)));
        assertFalse(screenObj.deleteShape(ShapeType.TRIANGLE, new Point(100, 100)));
        assertFalse(screenObj.deleteShape(ShapeType.SQUARE, new Point(990, 995)));
    }

    @Test
    public void deleteShapeType() {
        Screen screenObj = new Screen();

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(4, 4);
        shapeDataList2.add(4);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj2, shapeDataList2);

        List<Integer> shapeDataList3 = new ArrayList<Integer>();
        Point originPointObj3 = new Point(100, 4);
        shapeDataList3.add(4);
        Shape createdShapeObj3 = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj3, shapeDataList3);

        List<Integer> shapeDataList4 = new ArrayList<Integer>();
        Point originPointObj4 = new Point(990, 995);
        shapeDataList4.add(9);
        Shape createdShapeObj4 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj4, shapeDataList4);

        screenObj.addShape(createdShapeObj1);
        screenObj.addShape(createdShapeObj2);
        screenObj.addShape(createdShapeObj3);
        screenObj.addShape(createdShapeObj4);

        assertTrue(screenObj.deleteShapeType(ShapeType.RECTANGLE));
        assertTrue(screenObj.deleteShapeType(ShapeType.SQUARE));
        assertTrue(screenObj.deleteShapeType(ShapeType.TRIANGLE));
        assertTrue(screenObj.deleteShapeType(ShapeType.SQUARE));
    }

    @Test
    public void sortShapesBasedOnArea() {
        Screen screenObj = new Screen();

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(10, 10);
        shapeDataList2.add(5);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.CIRCLE, originPointObj2, shapeDataList2);

        List<Integer> shapeDataList3 = new ArrayList<Integer>();
        Point originPointObj3 = new Point(2, 4);
        shapeDataList3.add(3);
        Shape createdShapeObj3 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj3, shapeDataList3);

        List<Integer> shapeDataList4 = new ArrayList<Integer>();
        Point originPointObj4 = new Point(6, 2);
        shapeDataList4.add(10);
        Shape createdShapeObj4 = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj4, shapeDataList4);

        screenObj.addShape(createdShapeObj1);
        screenObj.addShape(createdShapeObj2);
        screenObj.addShape(createdShapeObj3);
        screenObj.addShape(createdShapeObj4);

        List<Shape> shapeObj = new ArrayList<Shape>(
                Arrays.asList(createdShapeObj3, createdShapeObj2, createdShapeObj1, createdShapeObj4));

        assertEquals(shapeObj, screenObj.sortShapesBasedOnArea());

    }

    @Test
    public void sortShapesBasedOnPerimeter() {
        Screen screenObj = new Screen();

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(10, 10);
        shapeDataList2.add(5);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.CIRCLE, originPointObj2, shapeDataList2);

        List<Integer> shapeDataList3 = new ArrayList<Integer>();
        Point originPointObj3 = new Point(2, 4);
        shapeDataList3.add(3);
        Shape createdShapeObj3 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj3, shapeDataList3);

        List<Integer> shapeDataList4 = new ArrayList<Integer>();
        Point originPointObj4 = new Point(6, 2);
        shapeDataList4.add(10);
        Shape createdShapeObj4 = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj4, shapeDataList4);

        screenObj.addShape(createdShapeObj1);
        screenObj.addShape(createdShapeObj2);
        screenObj.addShape(createdShapeObj3);
        screenObj.addShape(createdShapeObj4);

        List<Shape> shapeObj = new ArrayList<Shape>(
                Arrays.asList(createdShapeObj3, createdShapeObj2, createdShapeObj1, createdShapeObj4));

        assertEquals(shapeObj, screenObj.sortShapesBasedOnPerimeter());

    }

    @Test
    public void sortShapesBasedOnTimeStamp() {
        Screen screenObj = new Screen();

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(10, 10);
        shapeDataList2.add(5);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.CIRCLE, originPointObj2, shapeDataList2);

        List<Integer> shapeDataList3 = new ArrayList<Integer>();
        Point originPointObj3 = new Point(2, 4);
        shapeDataList3.add(3);
        Shape createdShapeObj3 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj3, shapeDataList3);

        List<Integer> shapeDataList4 = new ArrayList<Integer>();
        Point originPointObj4 = new Point(6, 2);
        shapeDataList4.add(10);
        Shape createdShapeObj4 = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj4, shapeDataList4);

        screenObj.addShape(createdShapeObj1);
        screenObj.addShape(createdShapeObj2);
        screenObj.addShape(createdShapeObj3);
        screenObj.addShape(createdShapeObj4);

        List<Shape> shapeObj = new ArrayList<Shape>(
                Arrays.asList(createdShapeObj1, createdShapeObj2, createdShapeObj3, createdShapeObj4));

        assertEquals(shapeObj, screenObj.sortShapesBasedOnTimeStamp());

    }

    @Test
    public void sortShapesBasedOnOriginDistance() {
        Screen screenObj = new Screen();

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(10, 10);
        shapeDataList2.add(5);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.CIRCLE, originPointObj2, shapeDataList2);

        List<Integer> shapeDataList3 = new ArrayList<Integer>();
        Point originPointObj3 = new Point(2, 4);
        shapeDataList3.add(3);
        Shape createdShapeObj3 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj3, shapeDataList3);

        List<Integer> shapeDataList4 = new ArrayList<Integer>();
        Point originPointObj4 = new Point(6, 2);
        shapeDataList4.add(10);
        Shape createdShapeObj4 = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj4, shapeDataList4);

        screenObj.addShape(createdShapeObj1);
        screenObj.addShape(createdShapeObj2);
        screenObj.addShape(createdShapeObj3);
        screenObj.addShape(createdShapeObj4);

        List<Shape> shapeObj = new ArrayList<Shape>(
                Arrays.asList(createdShapeObj1, createdShapeObj3, createdShapeObj4, createdShapeObj2));

        assertEquals(shapeObj, screenObj.sortShapesBasedOnOriginDistance());

    }

    @Test
    public void getShape() {
        Screen screenObj = new Screen();

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(4, 4);
        shapeDataList2.add(4);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj2, shapeDataList2);

        List<Integer> shapeDataList3 = new ArrayList<Integer>();
        Point originPointObj3 = new Point(100, 4);
        shapeDataList3.add(4);
        Shape createdShapeObj3 = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj3, shapeDataList3);

        List<Integer> shapeDataList4 = new ArrayList<Integer>();
        Point originPointObj4 = new Point(990, 995);
        shapeDataList4.add(9);
        Shape createdShapeObj4 = ShapeFactory.createShape(ShapeType.SQUARE, originPointObj4, shapeDataList4);

        screenObj.addShape(createdShapeObj1);
        screenObj.addShape(createdShapeObj2);
        screenObj.addShape(createdShapeObj3);
        screenObj.addShape(createdShapeObj4);

        assertEquals(createdShapeObj1, screenObj.getShape(ShapeType.RECTANGLE, originPointObj1));
        assertEquals(createdShapeObj2, screenObj.getShape(ShapeType.SQUARE, originPointObj2));
        assertEquals(null, screenObj.getShape(ShapeType.SQUARE, originPointObj3));
    }

}
