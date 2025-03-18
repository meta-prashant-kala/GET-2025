import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SearchTest {

    @Test
    public void linearSearch() {
        Search testObj = new Search();

        int[] input1 = { 1, 2, 3, 4, 5 };
        int[] input2 = { 6, 2, 8, 4, 5 };
        int[] input3 = { 1, 2, 3, 4, 5 };

        assertEquals(0, testObj.linearSearch(input1, 0, 1));
        assertEquals(4, testObj.linearSearch(input2, 0, 5));
        assertEquals(2, testObj.linearSearch(input3, 0, 3));
    }

    @Test
    public void binarySearch() {
        Search testObj = new Search();

        int[] input1 = { 1, 2, 3, 4, 5 };
        int[] input2 = { 6, 7, 8, 9, 10 };
        int[] input3 = { 1, 2, 3, 4, 5 };

        assertEquals(0, testObj.binarySearch(input1, 0, 4, 1));
        assertEquals(4, testObj.binarySearch(input2, 0, 4, 10));
        assertEquals(2, testObj.binarySearch(input3, 0, 4, 3));
    }
}
