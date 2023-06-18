package day11_Sorting;

import java.util.Arrays;

public class SortingMain {

    public static void main(String[] args) {

        int[] nums = {7, 2, 4, 6, 1, 9, -1};

        System.out.println(Arrays.toString(nums));

        System.out.println("Selection Sort:");
        System.out.println(Arrays.toString(SelectionSort.selectionSort(nums)));
        System.out.println("Bubble Sort:");
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(nums)));
        System.out.println("Insertion Sort:");
        System.out.println(Arrays.toString(InsertionSort.insertionSort(nums)));
        System.out.println("Merge Sort:");
        MergeSort.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Quick Sort:");
        QuickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }
}
