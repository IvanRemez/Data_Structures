package day10_Search;

public class TernarySearch {

    public static void main(String[] args) {

        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }

        System.out.println("ternarySearch_Iterative:");
        System.out.println(ternarySearch_Iterative(nums, 6));
        System.out.println(ternarySearch_Iterative(nums, 0));
        System.out.println(ternarySearch_Iterative(nums, 9));
        System.out.println(ternarySearch_Iterative(nums, 11));
        System.out.println(ternarySearch_Iterative(nums, -1));

        System.out.println("ternarySearch_Recursive:");
        System.out.println(ternarySearch_Recursive(nums, 6, 0, nums.length - 1));
        System.out.println(ternarySearch_Recursive(nums, 0, 0, nums.length - 1));
        System.out.println(ternarySearch_Recursive(nums, 9, 0, nums.length - 1));
        System.out.println(ternarySearch_Recursive(nums, 11, 0, nums.length - 1));
        System.out.println(ternarySearch_Recursive(nums, -1, 0, nums.length - 1));

    }

    public static int ternarySearch_Iterative(int[] arr, int data) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int partitionSize = (right - left) / 3;
            int mid1 = left + partitionSize;
            int mid2 = right - partitionSize;

            if (arr[mid1] == data) {
                return mid1;
            }
            if (arr[mid2] == data) {
                return mid2;
            }

            if (data < arr[mid1]) {
                right = mid1 - 1;
            } else if (data > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }

    public static int ternarySearch_Recursive(int[] arr, int data, int left, int right) {

        if (left > right) {
            return -1;  // element NOT FOUND
        }

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (arr[mid1] == data) {
            return mid1;
        }
        if (arr[mid2] == data) {
            return mid2;
        }
        // LEFT partition:
        if (data < arr[mid1]) {
            // Branch LEFT
            return ternarySearch_Recursive(arr, data, left, mid1 - 1);

        // RIGHT partition:
        } else if (data > arr[mid2]) {
            // Branch RIGHT
            return ternarySearch_Recursive(arr, data, mid2 + 1, right);

        // MIDDLE partition:
        } else {
            return ternarySearch_Recursive(arr, data, mid1 + 1, mid2 - 1);
        }
    }

}
