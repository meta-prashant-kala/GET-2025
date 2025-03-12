import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ArrOperation {

    /**
     * Method that takes input array and find the size of the largest mirror section
     * in the provided array
     * 
     * @param arr should be of type Arraylist<Integer>
     * @return the size of the largest mirror section in the given array
     */
    public int mirrorSection(ArrayList<Integer> arraylist) {
        int arrSize = arraylist.size();
        if (arrSize == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        ArrayList<ArrayList<Integer>> matchingChar2DArraylist = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempArrList = new ArrayList<Integer>();
        for (int i = 0; i <= arraylist.size(); i++) {
            tempArrList.add(0);
        }
        matchingChar2DArraylist.add(tempArrList);
        int maxCount = 0;
        for (int i = 1; i <= arrSize; i++) {
            ArrayList<Integer> tempArr = new ArrayList<Integer>();
            tempArr.add(0);
            for (int j = 1; j <= arrSize; j++) {
                if (arraylist.get(j - 1) == arraylist.get(arrSize - i)) {
                    tempArr.add(((matchingChar2DArraylist.get(i - 1)).get(j - 1)) + 1);
                } else {
                    tempArr.add(0);
                }
                maxCount = Math.max(maxCount, tempArr.get(j));
            }
            matchingChar2DArraylist.add(tempArr);
        }
        return maxCount;
    }

    /**
     * Method that takes arraylist of integer and find the clumps count in the array
     * 
     * @param arr should be the type of Arraylist<Integer>
     * @return
     */
    public int clumpsInArray(ArrayList<Integer> arraylist) {
        if (arraylist.size() == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        int currElement = arraylist.get(0);
        int start = 1;
        int clumCount = 0;
        while (start < arraylist.size()) {
            if (currElement == arraylist.get(start)) {
                clumCount++;
                while (start < arraylist.size() && currElement == arraylist.get(start)) {
                    start++;
                }
            } else {
                currElement = arraylist.get(start);
                start++;
            }
        }
        return clumCount;
    }

    /**
     * This method takes arraylist as an input and fix the places of X and Y such
     * that X is immediately followed by a Y
     * 
     * @param arraylist should be the type of Arraylist<Integer>
     * @param x         should be int
     * @param y         should be int
     * @return Return an array that contains exactly the same numbers as the input
     *         array, but rearranged so that every X is immediately followed by a Y
     */
    public ArrayList<Integer> fixXY(ArrayList<Integer> arraylist, int x, int y) {
        int arrSize = arraylist.size();
        if (arrSize == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        Stack<Integer> arrIndexStackForX = new Stack<Integer>();
        Stack<Integer> arrIndexStackForY = new Stack<Integer>();
        for (int i = 0; i < arrSize; i++) {
            if (arraylist.get(i) == x) {
                if (!arrIndexStackForX.empty() && i == arrIndexStackForX.peek() + 1) {
                    throw new IllegalArgumentException("Two adjacents" + x + "values are there");
                }
                arrIndexStackForX.push(i);
            }
            if (arraylist.get(i) == y) {
                arrIndexStackForY.push(i);
            }
        }
        if (arrIndexStackForX.size() != arrIndexStackForY.size()) {
            throw new IllegalArgumentException("Number of X and Y should be same");
        }
        if (arrIndexStackForX.peek() == arrSize - 1) {
            throw new IllegalArgumentException("Four cannot be present at the end of the arraylist");
        }
        while (!arrIndexStackForX.empty()) {
            int indexOfX = arrIndexStackForX.peek();
            int indexOfY = arrIndexStackForY.peek();
            arrIndexStackForX.pop();
            arrIndexStackForY.pop();
            if (indexOfX + 1 != indexOfY) {
                int nextElementOfIndexX = arraylist.get(indexOfX + 1);
                arraylist.set(indexOfX + 1, y);
                arraylist.set(indexOfY, nextElementOfIndexX);
            } else if (indexOfY + 1 == indexOfX) {
                Collections.swap(arraylist, indexOfX, indexOfY);
            }
        }
        return arraylist;
    }

    /**
     * Method that take input array of type arraylist and returns the index of if
     * there is a place to split the input array so that the sum of the numbers on
     * one side is equal to the sum of the numbers on the other side else return -1
     * 
     * @param arr should be the type of Arraylist<Integer>
     * @return the index from where the input array can be splitted if possible
     *         otherwise returns -1
     */
    public int splitArray(ArrayList<Integer> arraylist) {
        int totalSum = 0;
        Map<Integer, Integer> currsumToArrIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arraylist.size(); i++) {
            totalSum += arraylist.get(i);
        }
        int currSum = 0;
        for (int i = 0; i < arraylist.size(); i++) {
            currSum += arraylist.get(i);
            if (currSum == totalSum - currSum) {
                return i + 1;
            } else {
                currsumToArrIndexMap.put(currSum, i);
            }
        }
        return -1;
    }
}
