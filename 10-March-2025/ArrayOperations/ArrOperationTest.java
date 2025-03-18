import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArrOperationTest {

    @Test
    public void mirrorSection() {
        ArrOperation arrOperation = new ArrOperation();

        int[] input1 = { 1, 2, 3, 8, 9, 3, 2, 1 };
        int[] input2 = { 7, 1, 4, 9, 7, 4, 1 };
        int[] input3 = { 1, 2, 1, 4 };
        int[] input4 = { 1, 4, 5, 3, 5, 4, 1 };

        assertEquals(3, arrOperation.mirrorSection(input1));
        assertEquals(2, arrOperation.mirrorSection(input2));
        assertEquals(3, arrOperation.mirrorSection(input3));
        assertEquals(7, arrOperation.mirrorSection(input4));
    }

    @Test
    public void clumpsInArray() {
        ArrOperation arrOperation = new ArrOperation();

        int[] input1 = { 1, 2, 2, 3, 4, 4 };
        int[] input2 = { 1, 1, 2, 1, 1 };
        int[] input3 = { 1, 1, 1, 1, 1 };

        assertEquals(2, arrOperation.clumpsInArray(input1));
        assertEquals(2, arrOperation.clumpsInArray(input2));
        assertEquals(1, arrOperation.clumpsInArray(input3));
    }

    @Test
    public void findXY() {
        ArrOperation arrOperation = new ArrOperation();

        // Normal inputs
        int[] input1 = { 5, 4, 9, 4, 9, 5 };
        int[] input2 = { 1, 4, 1, 5 };
        int[] input3 = { 1, 4, 1, 5, 5, 4, 1 };

        // Input to check exception handling
        int[] input4 = { 1, 4, 4, 5, 5, 2, 1 };
        int[] input5 = { 1, 4, 1, 5, 5, 1, 4 };
        int[] input6 = { 1, 4, 1, 5, 5, 5, 9 };
        int[] input7 = {};

        int[] expectedOutput1 = { 9, 4, 5, 4, 5, 9 };
        int[] expectedOutput2 = { 1, 4, 5, 1 };
        int[] expectedOutput3 = { 1, 4, 5, 1, 1, 4, 5 };

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

        int[] input1 = { 1, 1, 1, 2, 1 };
        int[] input2 = { 2, 1, 1, 2, 1 };
        int[] input3 = { 10, 10 };

        assertEquals(3, arrOperation.splitArray(input1));
        assertEquals(-1, arrOperation.splitArray(input2));
        assertEquals(1, arrOperation.splitArray(input3));
    }

}
