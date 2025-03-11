import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrOperation {

    /**
     * Method that takes input array and find the size of the largest mirror section
     * in the provided array
     * 
     * @param arr should be of type Arraylist<Integer>
     * @return the size of the largest mirror section in the given array
     */
    public int mirrorSection(ArrayList<Integer> arr) {
        int arrSize = arr.size();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempArrList = new ArrayList<Integer>();
        for (int i = 0; i <= arr.size(); i++) {
            tempArrList.add(0);
        }
        dp.add(tempArrList);
        int maxCount = 0;
        for (int i = 1; i <= arrSize; i++) {
            ArrayList<Integer> tempArr = new ArrayList<Integer>();
            tempArr.add(0);
            for (int j = 1; j <= arrSize; j++) {
                if (arr.get(j - 1) == arr.get(arrSize - i)) {
                    tempArr.add(((dp.get(i - 1)).get(j - 1)) + 1);
                } else {
                    tempArr.add(0);
                }
                maxCount = Math.max(maxCount, tempArr.get(j));
            }
            dp.add(tempArr);
        }
        return maxCount;
    }

    /**
     * Method that takes arraylist of integer and find the clumps count in the array
     * 
     * @param arr should be the type of Arraylist<Integer>
     * @return
     */
    public int clumpsInArray(ArrayList<Integer> arr) {
        int currElement = arr.get(0);
        int start = 1;
        int clumCount = 0;
        while (start < arr.size()) {
            if (currElement == arr.get(start)) {
                clumCount++;
                while (start < arr.size() && currElement == arr.get(start)) {
                    start++;
                }
            } else {
                currElement = arr.get(start);
                start++;
            }
        }
        return clumCount;
    }

    public ArrayList<Integer> fixXY(ArrayList<Integer> arraylist) {
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
    public int splitArray(ArrayList<Integer> arr) {
        int totalSum = 0;
        Map<Integer, Integer> currsumToArrIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.size(); i++) {
            totalSum += arr.get(i);
        }
        int currSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            currSum += arr.get(i);
            if (currSum == totalSum - currSum) {
                return i + 1;
            } else {
                currsumToArrIndexMap.put(currSum, i);
            }
        }
        return -1;
    }
}
