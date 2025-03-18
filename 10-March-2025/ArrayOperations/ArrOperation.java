import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ArrOperation {

    /**
     * Method that takes input array and find the size of the largest mirror section
     * in the provided array
     * 
     * @param arr should be of type array of int type
     * @return the size of the largest mirror section in the given array
     */
    public int mirrorSection(int[] array) {
        int arrSize = array.length;
        if (arrSize == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        int[][] matchingChar2DArray = new int[array.length + 1][array.length + 1];
        int maxCount = 0;
        for (int i = 1; i <= arrSize; i++) {
            for (int j = 1; j <= arrSize; j++) {
                if (array[j - 1] == array[arrSize - i]) {
                    matchingChar2DArray[i][j] = matchingChar2DArray[i - 1][j - 1] + 1;
                } else {
                    matchingChar2DArray[i][j] = 0;
                }
                maxCount = Util.max(maxCount, matchingChar2DArray[i][j]);
            }
        }
        return maxCount;
    }

    /**
     * Method that takes array of integer and find the clumps count in the array
     * 
     * @param arr should be the type of array of int type
     * @return
     */
    public int clumpsInArray(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        int currElement = array[0];
        int start = 1;
        int clumCount = 0;
        while (start < array.length) {
            if (currElement == array[start]) {
                clumCount++;
                while (start < array.length && currElement == array[start]) {
                    start++;
                }
            } else {
                currElement = array[start];
                start++;
            }
        }
        return clumCount;
    }

    /**
     * This method takes array as an input and fix the places of X and Y such
     * that X is immediately followed by a Y
     * 
     * @param array should be the type of array of int type
     * @param x     should be int
     * @param y     should be int
     * @return Return an array that contains exactly the same numbers as the input
     *         array, but rearranged so that every X is immediately followed by a Y
     */
    public int[] fixXY(int[] array, int x, int y) {
        int arrSize = array.length;
        if (arrSize == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        Stack<Integer> arrIndexStackForX = new Stack<Integer>();
        Stack<Integer> arrIndexStackForY = new Stack<Integer>();
        for (int i = 0; i < arrSize; i++) {
            if (array[i] == x) {
                if (!arrIndexStackForX.empty() && i == arrIndexStackForX.peek() + 1) {
                    throw new IllegalArgumentException("Two adjacents" + x + "values are there");
                }
                arrIndexStackForX.push(i);
            }
            if (array[i] == y) {
                arrIndexStackForY.push(i);
            }
        }
        if (arrIndexStackForX.size() != arrIndexStackForY.size()) {
            throw new IllegalArgumentException("Number of X and Y should be same");
        }
        if (arrIndexStackForX.peek() == arrSize - 1) {
            throw new IllegalArgumentException("Four cannot be present at the end of the array");
        }
        while (!arrIndexStackForX.empty()) {
            int indexOfX = arrIndexStackForX.peek();
            int indexOfY = arrIndexStackForY.peek();
            arrIndexStackForX.pop();
            arrIndexStackForY.pop();
            if (indexOfX + 1 != indexOfY) {
                int nextElementOfIndexX = array.get[indexOfX + 1];
                array[indexOfX + 1] = y;
                array[indexOfY] = nextElementOfIndexX;
            } else if (indexOfY + 1 == indexOfX) {
                int temp = array[indexOfY];
                array[indexOfY] = array[indexOfX];
                array[indexOfX] = temp;
            }
        }
        return array;
    }

    /**
     * Method that take input array of type array and returns the index of if
     * there is a place to split the input array so that the sum of the numbers on
     * one side is equal to the sum of the numbers on the other side else return -1
     * 
     * @param arr should be the type of array of int type
     * @return the index from where the input array can be splitted if possible
     *         otherwise returns -1
     */
    public int splitArray(int[] array) {
        int totalSum = 0;
        Map<Integer, Integer> currsumToArrIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }
        int currSum = 0;
        for (int i = 0; i < array.length; i++) {
            currSum += array[i];
            if (currSum == totalSum - currSum) {
                return i + 1;
            } else {
                currsumToArrIndexMap.put(currSum, i);
            }
        }
        return -1;
    }
}
