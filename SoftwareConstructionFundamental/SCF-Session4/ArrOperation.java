/**
 * It performs Various Array Operations Each method will receive an array of
 * positive integers
 * 
 * @author Shubham Jain
 */
public class ArrOperation {

    /**
     * It will calculate size of the largest mirror section found in the input
     * array Mirror section in an array is a group of contiguous elements such
     * that somewhere in the array, the same group appears in reverse order
     * 
     * @param inputArray
     * @return int size of the largest mirror section found in the input array.
     */
    int maxMirror(int inputArray[]) {
        int start = 0;
        int last = 0;
        int countSizeMirror = 0;
        int maxSizeMirror = 0;

        if (inputArray.length == 0) {
            throw new AssertionError("Input Array is Empty");
        }
        for (int i = 0; i < inputArray.length; i++) {
            start = i;
            countSizeMirror = 0;
            last = inputArray.length - 1;

            while ((last >= 0) && (start < inputArray.length)) {
                if (inputArray[start] == inputArray[last]) {
                    countSizeMirror += 1;
                    start++;
                    last--;
                } else {
                    last--;
                    if (maxSizeMirror < countSizeMirror) {
                        maxSizeMirror = countSizeMirror;
                    }
                    countSizeMirror = 0;
                }
            }
            if (maxSizeMirror < countSizeMirror) {
                maxSizeMirror = countSizeMirror;
            }
            if (maxSizeMirror == inputArray.length) {
                return maxSizeMirror;
            }
        }
        return maxSizeMirror;
    }

    /**
     * It will compute number of Clumps in an array Clump in an array is a
     * series of 2 or more adjacent elements of the same value
     * 
     * @param inputArray
     * @return int number of clumps in the input array
     */
    int countClumps(int inputArray[]) {
        int noOfClumps = 0;
        int startClump = 0;

        if (inputArray.length == 1) {
            return 0;
        }
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] == inputArray[i + 1]) {
                if (startClump == i) {
                    noOfClumps++;
                }
            } else {
                startClump = i + 1;
            }
        }
        return noOfClumps;
    }

    /**
     * It will compute an array that contains exactly the same numbers as the
     * input array, but rearranged so that every value1 is immediately followed
     * by a value2
     * 
     * @param value1
     * @param value2
     * @param inputArray
     * @return int[]
     */
    int[] fixXY(int value1, int value2, int inputArray[]) {
        int locationOfValue1[];
        int locationOfValue2[];
        int countValue1 = 0;
        int countValue2 = 0;
        int indexValue1 = 0;
        int indexValue2 = 0;

        if (inputArray.length == 0) {
            throw new AssertionError("Input Array is Empty");
        } else if (inputArray[inputArray.length - 1] == value1) {
            throw new AssertionError("Input 1 is at last index position");
        } else if ((inputArray.length == 1) && !(inputArray[0] == value2)) {
            return inputArray;
        } else if ((inputArray.length == 1) && (inputArray[0] == value2)) {
            throw new AssertionError("Value 1 and Value 2 are not in same number");
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == value1) {
                countValue1++;
            } else if (inputArray[i] == value2) {
                countValue2++;
            }
        }
        if (countValue1 != countValue2) {
            throw new AssertionError("Value 1 and Value 2 are not in same number");
        }

        locationOfValue1 = new int[countValue1];
        locationOfValue2 = new int[countValue2];

        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] == inputArray[i + 1] && inputArray[i] == value1) {
                throw new AssertionError("Value1 occurs Simultaneoulsy");
            }
            if (inputArray[i] == value1) {
                locationOfValue1[indexValue1] = i;
                indexValue1++;
            } else if (inputArray[i] == value2) {
                locationOfValue2[indexValue2] = i;
                indexValue2++;
            }
        }
        if (inputArray[inputArray.length - 1] == value2) {
            locationOfValue2[indexValue2] = inputArray.length - 1;
        }
        for (int i = 0; i < countValue1; i++) {
            if (!((locationOfValue1[i] + 1) == locationOfValue2[i])) {
                swap(inputArray, locationOfValue1[i] + 1, locationOfValue2[i]);
            }
        }
        return inputArray;
    }

    /**
     * It will swap the value1 and value2
     * 
     * @param inputArray
     * @param value1 int
     * @param value2 int
     */
    private void swap(int inputArray[], int value1, int value2) {
        int temporary;
        temporary = inputArray[value1];
        inputArray[value1] = inputArray[value2];
        inputArray[value2] = temporary;
    }

    /**
     * It will compute the index if there is a place to split the input array so
     * that the sum of the numbers on one side is equal to the sum of the
     * numbers on the other side
     * 
     * @param inputArray
     * @return index of split array if it is present otherwise -1
     */
    int splitArray(int inputArray[]) {
        int sum = 0;
        int startSum;
        int splitIndex = 0;

        if (inputArray.length == 0) {
            throw new AssertionError("Input Array is Empty");
        }
        if (inputArray.length == 1) {
            return -1;
        }
        for (int i = 1; i < inputArray.length; i++) {
            sum += inputArray[i];
        }
        startSum = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (startSum == sum) {
                return splitIndex += 1;
            } else {
                startSum += inputArray[i];
                sum -= inputArray[i];
                splitIndex = i;
            }
        }
        return -1;
    }
}
