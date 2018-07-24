/**
 * @author Shubham Jain
 */
public class Search {

    /**
     * It will find the index of the value present in the array through Linear Search
     * 
     * @param inputArray
     * @param startIndex
     * @param value
     * @return int
     */
    int linearSearch(int inputArray[], int startIndex, int value) {
        if (startIndex == inputArray.length) {
            return -1;
        } else if (inputArray[startIndex] == value) {
            return startIndex;
        }
        return linearSearch(inputArray, startIndex + 1, value);
    }

    /**
     * It will find the index of the value present in the array through Binary Search
     * Assume array to be sorted for Binary search
     * 
     * @param inputArray
     * @param startIndex
     * @param lastIndex
     * @param value
     * @return int
     */
    int binarySearch(int inputArray[], int startIndex, int lastIndex, int value) {
        if (lastIndex >= startIndex) {
            int midIndex = startIndex + (lastIndex - startIndex) / 2;
            if (inputArray[midIndex] == value) {
                return midIndex;
            } else if (inputArray[midIndex] > value) {
                return binarySearch(inputArray, startIndex, midIndex - 1, value);
            } else {
                return binarySearch(inputArray, midIndex + 1, lastIndex, value);
            }
        }
        return -1;
    }
}
