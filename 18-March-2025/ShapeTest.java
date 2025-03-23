import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ShapeTest {
    @Test
    public void isPointEnclosed() {

        List<Integer> shapeDataList1 = new ArrayList<Integer>();
        Point originPointObj1 = new Point(2, 2);
        shapeDataList1.add(4);
        shapeDataList1.add(8);
        Shape createdShapeObj1 = ShapeFactory.createShape(ShapeType.RECTANGLE, originPointObj1, shapeDataList1);

        List<Integer> shapeDataList2 = new ArrayList<Integer>();
        Point originPointObj2 = new Point(6, 2);
        shapeDataList2.add(10);
        Shape createdShapeObj2 = ShapeFactory.createShape(ShapeType.TRIANGLE, originPointObj2, shapeDataList2);

        assertTrue(createdShapeObj1.isPointEnclosed(new Point(3, 3)));
        assertTrue(createdShapeObj2.isPointEnclosed(new Point(7, 3)));
        assertFalse(createdShapeObj1.isPointEnclosed(new Point(1, 1)));
        assertFalse(createdShapeObj2.isPointEnclosed(new Point(17, 13)));

    }
}
