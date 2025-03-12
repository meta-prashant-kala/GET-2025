import java.util.ArrayList;

public class Search {

    /**
     * Method to find the KeyElement in the array using the concept of Linear Search
     * 
     * @param searchArrayList Should be Arraylist<Integer> type
     * @param index           is the starting index of the array
     * @param keyElement      element to search in the array
     * @return the index of the KeyElement in the array if present otherwise will
     *         return -1
     */
    public int linearSearch(ArrayList<Integer> searchArrayList, int index, int keyElement) {
        if (index == searchArrayList.size()) {
            return -1;
        }
        if (searchArrayList.get(index) == keyElement) {
            return index;
        } else {
            return linearSearch(searchArrayList, index + 1, keyElement);
        }
    }

    /**
     * Method to find the KeyElement in the array using the concept of Binary Search
     * 
     * @param searchArrayList Should be Arraylist<Integer> type and the elements
     *                        should be in sorted order
     * @param index           is the starting index of the array
     * @param keyElement      is the element to search in the array
     * @return the index of the KeyElement in the array if present otherwise will
     *         return -1
     */
    public int binarySearch(ArrayList<Integer> searchArrayList, int left, int right, int keyElement) {
        int mid = (((right - left) / 2) + left);
        if (searchArrayList.get(mid) == keyElement) {
            return mid;
        } else if (searchArrayList.get(mid) > keyElement) {
            return binarySearch(searchArrayList, left, mid - 1, keyElement);
        } else {
            return binarySearch(searchArrayList, mid + 1, right, keyElement);
        }
    }
}
