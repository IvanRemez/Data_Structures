package day11_Sorting;

public class MergeSort {

    public static void mergeSort(int[] arr) {

        if (arr.length < 2) {
            return;
        }   // base termination - arr with 1 element -> STOP
        int mid = arr.length / 2;
        
    // create left and right arrays:    
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
    // assign elements to each side:
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }// ^^ since we start from mid and right arr needs to start from 0,
        // we use (i - mid) to avoid OutOfBoundsException

    // call mergeSort recursively on each side
        mergeSort(left);
        mergeSort(right);
    // merge both sides together for the result -> arr
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] result) {
// need 3 pointers: 1 for left, 1 for right, 1 for result
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
    // while left AND right indices are within array bounds

            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }// put smaller element into result, increase indices
        }
    // check if indices within bounds for each side separately:
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    // ^^ used to put left over elements from each side into result arr
    }
}
