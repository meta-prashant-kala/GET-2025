package IntSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IntSetTest {

    @Test
    public void isMember() {
        int[] inputArr = { 1, 2, 3, 4, 5 };
        IntSet testIntSetObj = new IntSet(inputArr);
        assertEquals(true, testIntSetObj.isMember(3));
        assertEquals(true, testIntSetObj.isMember(5));
        assertEquals(false, testIntSetObj.isMember(7));
        assertEquals(false, testIntSetObj.isMember(10));
    }

    @Test
    public void size() {
        int[] inputArr1 = { 1, 2, 3, 4, 5 };
        int[] inputArr2 = { 1, 2, 5 };
        int[] inputArr3 = { 1, 2, 5, 4, 2, 6 };
        IntSet testIntSetObj1 = new IntSet(inputArr1);
        IntSet testIntSetObj2 = new IntSet(inputArr2);
        IntSet testIntSetObj3 = new IntSet(inputArr3);
        assertEquals(5, testIntSetObj1.size());
        assertEquals(3, testIntSetObj2.size());
        assertEquals(5, testIntSetObj3.size());
    }

    @Test
    public void isSubSet() {
        int[] inputArr = { 1, 2, 3, 4, 5 };
        int[] inputSubArr1 = { 1, 2 };
        int[] inputSubArr2 = { 1, 2, 4 };
        int[] inputSubArr3 = { 1, 2, 6 };

        IntSet testIntSetObj1 = new IntSet(inputArr);

        IntSet testSubSetIntSetObj1 = new IntSet(inputSubArr1);
        IntSet testSubSetIntSetObj2 = new IntSet(inputSubArr2);
        IntSet testSubSetIntSetObj3 = new IntSet(inputSubArr3);

        assertEquals(true, testIntSetObj1.isSubSet(testSubSetIntSetObj1));
        assertEquals(true, testIntSetObj1.isSubSet(testSubSetIntSetObj2));
        assertEquals(false, testIntSetObj1.isSubSet(testSubSetIntSetObj3));
    }

    @Test
    public void getComplementTest() {
        int[] inputArr1 = { 1, 2, 3, 4, 5 };
        IntSet testIntSetObj1 = new IntSet(inputArr1);
        int[] expectedOutputArr1 = new int[995];
        int j = 0;
        // j=6,7,
        for (int i = 1; i <= 1000; i++) {
            if (!testIntSetObj1.isMember(i)) {
                expectedOutputArr1[j] = i;
                j++;
            }
        }

        int[] inputArr2 = { 1, 2, 3, 4, 5, 12, 325, 435, 312, 1, 2, 3, 423 };
        IntSet testIntSetObj2 = new IntSet(inputArr2);
        int[] expectedOutputArr2 = new int[990];
        j = 0;
        for (int i = 1; i <= 1000; i++) {
            if (!testIntSetObj2.isMember(i)) {
                expectedOutputArr2[j] = i;
                j++;
            }
        }

        IntSet expectedIntSetObj1 = new IntSet(expectedOutputArr1);
        IntSet expectedIntSetObj2 = new IntSet(expectedOutputArr1);
        assertEquals(expectedIntSetObj1, testIntSetObj1.getComplement());
        assertEquals(expectedIntSetObj2, testIntSetObj1.getComplement());
    }

    @Test
    public void getUnionSet() {

        int[] inputArr1 = { 2, 4, 6, 8, 10 };
        IntSet testIntSetObj1 = new IntSet(inputArr1);

        int[] inputArgArr1 = { 1, 2, 3, 4, 5 };
        IntSet testIntSetArgObj1 = new IntSet(inputArgArr1);

        int[] expectedOutputArr1 = { 1, 2, 3, 4, 5, 6, 8, 10 };
        IntSet expectedIntSetObj1 = new IntSet(expectedOutputArr1);

        assertEquals(expectedIntSetObj1, testIntSetObj1.getUnionSet(testIntSetArgObj1));

    }

    @Test
    public void getIntersectionSet() {

        int[] inputArr1 = { 2, 4, 6, 8, 10 };
        IntSet testIntSetObj1 = new IntSet(inputArr1);

        int[] inputArgArr1 = { 1, 2, 3, 4, 5 };
        IntSet testIntSetArgObj1 = new IntSet(inputArgArr1);

        int[] expectedOutputArr1 = { 2, 4 };
        IntSet expectedIntSetObj1 = new IntSet(expectedOutputArr1);

        assertEquals(expectedIntSetObj1, testIntSetObj1.getIntersectionSet(testIntSetArgObj1));

    }

    @Test
    public void getDifference() {

        int[] inputArr1 = { 2, 4, 6, 8, 10 };
        IntSet testIntSetObj1 = new IntSet(inputArr1);

        int[] inputArgArr1 = { 1, 2, 3, 4, 5 };
        IntSet testIntSetArgObj1 = new IntSet(inputArgArr1);

        int[] expectedOutputArr1 = { 6, 8, 10 };
        IntSet expectedIntSetObj1 = new IntSet(expectedOutputArr1);

        assertEquals(expectedIntSetObj1, testIntSetObj1.getDifference(testIntSetArgObj1));

    }

    @Test
    public void getComplementIntSet() {

        int[] inputArr1 = { 2, 4, 6, 8, 10 };
        IntSet testIntSetObj1 = new IntSet(inputArr1);

        int[] inputArgArr1 = { 1, 2, 3, 4, 5 };
        IntSet testIntSetArgObj1 = new IntSet(inputArgArr1);

        int[] expectedOutputArr1 = { 1, 3, 5 };
        IntSet expectedIntSetObj1 = new IntSet(expectedOutputArr1);

        assertEquals(expectedIntSetObj1, testIntSetObj1.getComplementIntSet(testIntSetArgObj1));

    }

}
