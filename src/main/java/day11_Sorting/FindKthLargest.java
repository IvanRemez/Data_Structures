package day11_Sorting;

import java.util.Arrays;

public class FindKthLargest {

    public static void main(String[] args) {

        int[] nums = {7, 2, 4, 6, 1, 9, -1};

        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest_BubbleSort(nums, 7));

    }

    public static int findKthLargest_BubbleSort(int[] arr, int k) {

        for (int i = 0; i < k; i++) {

            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr[arr.length - k];
    }

    public static void swap(int[] arr, int index1, int index2) {

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
