package day11_Sorting;

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int toBeInserted = arr[i];  // temp variable to be inserted
                                        // (1st element of UNSORTED part)
            int j = i - 1;  // Start comparisons from the predecessor (i - 1)

            while (j >= 0 && toBeInserted < arr[j]) {
            // while index >= 0 AND toBeInserted element is smaller than current value
                arr[j + 1] = arr[j];    // shift sorted element(s) left
                j--;    // move left on SORTED part for next comparison
            }
            arr[j + 1] = toBeInserted;
        }
        return arr;
    }

}
