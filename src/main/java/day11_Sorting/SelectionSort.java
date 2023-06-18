package day11_Sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;   // to represent the beginning of UNSORTED portion
                            // as elements are moved to SORTED, minIndex grows ++

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                // if any element in UNSORTED part is smaller than minIndex element,
                    // store new minIndex
                }
            }
            swap(arr, minIndex, i); // swap actual elements using new minIndex
        }
        return arr;
    }

    public static void swap(int[] arr, int index1, int index2) {

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
