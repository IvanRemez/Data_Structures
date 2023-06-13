package day10_Search;

public class ExponentialSearch {

    public static void main(String[] args) {

        int[] nums = new int[30];

        for (int i = 0; i < 30; i++) {
            nums[i] = i;
        }

        System.out.println("Exponential Search:");
        System.out.println(exponentialSearch(nums, 24));
        System.out.println(exponentialSearch(nums, 0));
        System.out.println(exponentialSearch(nums, 29));
        System.out.println(exponentialSearch(nums, 31));
        System.out.println(exponentialSearch(nums, -36));

    }

    public static int exponentialSearch(int[] arr, int data) {

        int bound = 1;

        while (bound < arr.length && arr[bound] < data) {
    // ^^ while bound within arr AND it's value < data, expand bound (*2)
            bound *= 2;
        }
        int left = bound / 2;
        int right = Math.min(bound, arr.length - 1);
    // ^^ rightBound = min of bound OR arr.length - 1 to avoid IndexOutOfBounds

    // once the correct bound (partition) is found,
        // perform recursive Binary Search inside that bound:
        return BinarySearch.binarySearch_Recursive(arr, data, left, right);
    }
}
