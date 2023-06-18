package day11_Sorting;

public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {     // 1 element - base cond.
            return;
        }
        int boundary = partition(arr, start, end);

        quickSort(arr, start, boundary - 1); // recursive on left
        quickSort(arr, boundary + 1, end);  // recursive on right
    }

    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int boundary = start;

        for (int i = start; i <= end; i++) {

            if (arr[i] <= pivot) {   // if element smaller than pivot, swap indices w/ boundary
                swap(arr, i, boundary);
                boundary++; // move boundary (index) right to the next element
            }
        }
        return boundary - 1; // - 1 b/c ^^ we add 1 each time (avoid OutOfBounds)
    }

    public static void swap(int[] arr, int index1, int index2) {

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
