package day11_Sorting;

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int toBeInserted = arr[i];  // temp variable to be inserted
            int j = i - 1;  // the predecessor

            while (j >= 0 && toBeInserted < arr[j]) {
            // while index >= 0 AND toBeInserted element is smaller than
                // current value
                arr[j + 1] = arr[j];    // shift element right
                j--;    // move left on SORTED part for next comparison
            }
            arr[j + 1] = toBeInserted;
        }
        return arr;
    }

}
