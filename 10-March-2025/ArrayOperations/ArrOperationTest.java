import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArrOperationTest {

    @Test
    public void mirrorSection() {
        ArrOperation arrOperation = new ArrOperation();

        ArrayList<Integer> input1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 8, 9, 3, 2, 1));
        ArrayList<Integer> input2 = new ArrayList<Integer>(Arrays.asList(7, 1, 4, 9, 7, 4, 1));
        ArrayList<Integer> input3 = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 4));
        ArrayList<Integer> input4 = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 3, 5, 4, 1));

        assertEquals(3, arrOperation.mirrorSection(input1));
        assertEquals(2, arrOperation.mirrorSection(input2));
        assertEquals(3, arrOperation.mirrorSection(input3));
        assertEquals(7, arrOperation.mirrorSection(input4));
    }

    @Test
    public void clumpsInArray() {
        ArrOperation arrOperation = new ArrOperation();

        ArrayList<Integer> input1 = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 4, 4));
        ArrayList<Integer> input2 = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 1, 1));
        ArrayList<Integer> input3 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1));

        assertEquals(2, arrOperation.clumpsInArray(input1));
        assertEquals(2, arrOperation.clumpsInArray(input2));
        assertEquals(1, arrOperation.clumpsInArray(input3));
    }

    @Test
    public void findXY() {
        ArrOperation arrOperation = new ArrOperation();

        // Normal inputs
        ArrayList<Integer> input1 = new ArrayList<Integer>(Arrays.asList(5, 4, 9, 4, 9, 5));
        ArrayList<Integer> input2 = new ArrayList<Integer>(Arrays.asList(1, 4, 1, 5));
        ArrayList<Integer> input3 = new ArrayList<Integer>(Arrays.asList(1, 4, 1, 5, 5, 4, 1));

        // Input to check exception handling
        ArrayList<Integer> input4 = new ArrayList<Integer>(Arrays.asList(1, 4, 4, 5, 5, 2, 1));
        ArrayList<Integer> input5 = new ArrayList<Integer>(Arrays.asList(1, 4, 1, 5, 5, 1, 4));
        ArrayList<Integer> input6 = new ArrayList<Integer>(Arrays.asList(1, 4, 1, 5, 5, 5, 9));
        ArrayList<Integer> input7 = new ArrayList<Integer>(Arrays.asList());

        ArrayList<Integer> expectedOutput1 = new ArrayList<Integer>(Arrays.asList(9, 4, 5, 4, 5, 9));
        ArrayList<Integer> expectedOutput2 = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 1));
        ArrayList<Integer> expectedOutput3 = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 1, 1, 4, 5));

        assertEquals(expectedOutput1, arrOperation.fixXY(input1, 4, 5));
        assertEquals(expectedOutput2, arrOperation.fixXY(input2, 4, 5));
        assertEquals(expectedOutput3, arrOperation.fixXY(input3, 4, 5));

        assertThrows(IllegalArgumentException.class, () -> {
            arrOperation.fixXY(input4, 4, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            arrOperation.fixXY(input5, 4, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            arrOperation.fixXY(input6, 4, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            arrOperation.fixXY(input7, 4, 5);
        });

    }

    @Test
    public void splitArray() {
        ArrOperation arrOperation = new ArrOperation();

        ArrayList<Integer> input1 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 1));
        ArrayList<Integer> input2 = new ArrayList<Integer>(Arrays.asList(2, 1, 1, 2, 1));
        ArrayList<Integer> input3 = new ArrayList<Integer>(Arrays.asList(10, 10));

        assertEquals(3, arrOperation.splitArray(input1));
        assertEquals(-1, arrOperation.splitArray(input2));
        assertEquals(1, arrOperation.splitArray(input3));
    }

}
