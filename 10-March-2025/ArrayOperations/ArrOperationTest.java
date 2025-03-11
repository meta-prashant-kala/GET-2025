import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;


public class ArrOperationTest {

    @Test
    public void mirrorSection(){
        ArrOperation arrOperation=new ArrOperation();
        ArrayList<Integer> input1= new ArrayList<Integer>(Arrays.asList(1, 2, 3, 8, 9, 3, 2, 1));
        ArrayList<Integer> input2= new ArrayList<Integer>(Arrays.asList(7, 1, 4, 9, 7, 4, 1));
        ArrayList<Integer> input3= new ArrayList<Integer>(Arrays.asList(1, 2, 1, 4));
        ArrayList<Integer> input4= new ArrayList<Integer>(Arrays.asList(1, 4, 5, 3, 5, 4, 1));
        assertEquals(3, arrOperation.mirrorSection(input1));
        assertEquals(2, arrOperation.mirrorSection(input2));
        assertEquals(3, arrOperation.mirrorSection(input3));
        assertEquals(7, arrOperation.mirrorSection(input4));
    }   


    @Test
    public void clumpsInArray() {
        ArrOperation arrOperation=new ArrOperation();
        ArrayList<Integer> input1= new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 4, 4));
        ArrayList<Integer> input2= new ArrayList<Integer>(Arrays.asList(1, 1, 2, 1, 1));
        ArrayList<Integer> input3= new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1));
        assertEquals(2, arrOperation.clumpsInArray(input1));
        assertEquals(2, arrOperation.clumpsInArray(input2));
        assertEquals(1, arrOperation.clumpsInArray(input3));
    }


    @Test
    public void splitArray(){
        ArrOperation arrOperation=new ArrOperation();
        ArrayList<Integer> input1= new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 1));
        ArrayList<Integer> input2= new ArrayList<Integer>(Arrays.asList(2, 1, 1, 2, 1));
        ArrayList<Integer> input3= new ArrayList<Integer>(Arrays.asList(10, 10));
        assertEquals(3, arrOperation.splitArray(input1));
        assertEquals(-1, arrOperation.splitArray(input2));
        assertEquals(1, arrOperation.splitArray(input3));
    }


}
