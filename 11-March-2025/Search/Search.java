
public class Search {

    /**
     * Method to find the KeyElement in the array using the concept of Linear Search
     * 
     * @param searchArray Should be Array of int type
     * @param index       is the starting index of the array
     * @param keyElement  element to search in the array
     * @return the index of the KeyElement in the array if present otherwise will
     *         return -1
     */
    public int linearSearch(int[] searchArray, int index, int keyElement) {
        if (index == searchArray.length) {
            return -1;
        }
        if (searchArray[index] == keyElement) {
            return index;
        } else {
            return linearSearch(searchArray, index + 1, keyElement);
        }
    }

    /**
     * Method to find the KeyElement in the array using the concept of Binary Search
     * 
     * @param searchArray Should be Array<Integer> type and the elements
     *                    should be in sorted order
     * @param index       is the starting index of the array
     * @param keyElement  is the element to search in the array
     * @return the index of the KeyElement in the array if present otherwise will
     *         return -1
     */
    public int binarySearch(int[] searchArray, int left, int right, int keyElement) {
        int mid = (((right - left) / 2) + left);
        if (searchArray[mid] == keyElement) {
            return mid;
        } else if (searchArray[mid] > keyElement) {
            return binarySearch(searchArray, left, mid - 1, keyElement);
        } else {
            return binarySearch(searchArray, mid + 1, right, keyElement);
        }
    }
}
