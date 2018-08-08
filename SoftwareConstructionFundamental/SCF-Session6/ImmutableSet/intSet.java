import java.util.Arrays;

/**
 * This immutable class will perform various Set Operations
 * 
 * @author Shubham Jain
 *
 */
final public class intSet {
    private int universalArray[] = new int[] { 1, 2, 3, 4, 15, 5, 6, 7, 8, 9, 10 };
    final private int set[];

    /**
     * It will sort the array
     * 
     * @param set
     */
    private void sort(int set[]) {
        Arrays.sort(set);
    }

    /**
     * It will remove the duplicates, sort the array and then initialize the
     * object with the sorted array
     * 
     * @param set
     */
    intSet(int set[]) {
        int count = removeDuplicateElements(set);
        this.set = new int[count];
        for(int i=0;i<count;i++){
            if(set[i]<1 || set[i]>100){
                throw new AssertionError("Input should be in between 0 and 100");
            }     
        } 
        for (int i = 0; i < count; i++) {
            this.set[i] = set[i];
        }
    }

    /**
     * It will calculate the size of the array
     * 
     * @return int size of array
     */
    int size() {
        return set.length;
    }

    /**
     * It will remove duplicates from the array
     * 
     * @param array
     * @return number of Unique Elements
     */
    int removeDuplicateElements(int array[]) {
        int length = array.length;
        int noOfUniqueElements = 0;

        sort(array);
        if (length == 0 || length == 1) {
            return length;
        }
        int j = 0;
        for (int i = 0; i < length - 1; i++) {
            if (array[i] != array[i + 1]) {
                noOfUniqueElements++;
                if (j == i) {
                    j++;
                } else {
                    array[j++] = array[i];
                }
            }
        }
        array[j] = array[length - 1];
        noOfUniqueElements++;
        return noOfUniqueElements;
    }

    /**
     * It will find whether the element is present in the array
     * 
     * @param value 
     * @return true if element is present otherwise false
     */
    boolean isMember(int value) {
        int length = size();
        for (int i = 0; i < length; i++) {
            if (value == set[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * It will find whether the set is subset of the other set
     * 
     * @param subSet
     * @return true if it is a subset otherwise false
     */
    boolean isSubSet(intSet subSet) {
        int subSetLenght = subSet.size();
        int subSetIndex = 0;
        int setIndex = 0;
        int noOfSubSetElememts = 0;
        sort(set);
        subSet.sort(subSet.set);
        for (setIndex = 0; setIndex < set.length && subSetIndex < subSetLenght; setIndex++) {
            if (subSet.set[subSetIndex] == set[setIndex]) {
                noOfSubSetElememts++;
                subSetIndex++;
            }
        }
        if (!(noOfSubSetElememts == subSetLenght)) {
            return false;
        }
        return true;
    }

    /**
     * It will calculate the complement of the given array from universal array
     * 
     * @return
     */
    public int[] getComplement() {
        sort(set);
        sort(universalArray);
        int complementedArray[] = new int[universalArray.length - set.length];
        int setIndex = 0;
        int universalSetIndex = 0;
        int complementedSetIndex = 0;

        while (setIndex < set.length
                && universalSetIndex < universalArray.length) {
            if (set[setIndex] < universalArray[universalSetIndex]) {
                complementedArray[complementedSetIndex++] = set[setIndex];
                setIndex++;
            } else if (set[setIndex] > universalArray[universalSetIndex]) {
                complementedArray[complementedSetIndex++] = universalArray[universalSetIndex];
                universalSetIndex++;
            } else {
                setIndex++;
                universalSetIndex++;
            }
        }
        while (universalSetIndex < universalArray.length) {
            complementedArray[complementedSetIndex++] = universalArray[universalSetIndex];
            universalSetIndex++;
        }
        return complementedArray;
    }

    /**
     * It will compute union of two sets
     * 
     * @param set1 first set
     * @param set2 second set
     * @return union of sets
     */
    public int[] union(intSet set1, intSet set2) {
        int set1Index = 0;
        int set2Index = 0;
        int unionSetIndex = 0;
        int unionArray[] = new int[set1.set.length + set2.set.length];
        int counter = 0;

        while (set1Index < set1.set.length && set2Index < set2.set.length) {
            if (set1.set[set1Index] < set2.set[set2Index]) {
                unionArray[unionSetIndex++] = set1.set[set1Index];
                set1Index++;
            } else if (set1.set[set1Index] > set2.set[set2Index]) {
                unionArray[unionSetIndex++] = set2.set[set2Index];
                set2Index++;
            } else {
                unionArray[unionSetIndex++] = set1.set[set1Index];
                set1Index++;
                set2Index++;
            }
            counter++;
        }
        while (set1Index < set1.set.length) {
            unionArray[unionSetIndex++] = set1.set[set1Index++];
            counter++;
        }
        while (set2Index < set2.set.length) {
            unionArray[unionSetIndex++] = set2.set[set2Index++];
            counter++;
        }
        int union[] = new int[counter];
        for (int i = 0; i < counter; i++) {
            union[i] = unionArray[i];
        }
        return union;
    }
}