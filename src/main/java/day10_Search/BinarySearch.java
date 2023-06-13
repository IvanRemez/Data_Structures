package day10_Search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }

        System.out.println("binarySearch_Iterative:");
        System.out.println(binarySearch_Iterative(nums, 6));
        System.out.println(binarySearch_Iterative(nums, 0));
        System.out.println(binarySearch_Iterative(nums, 9));
        System.out.println(binarySearch_Iterative(nums, 11));
        System.out.println(binarySearch_Iterative(nums, -1));

        System.out.println("----------------------------------------");
        System.out.println("binarySearch_Recursive:");
        System.out.println(binarySearch_Recursive(nums, 6));
        System.out.println(binarySearch_Recursive(nums, 0));
        System.out.println(binarySearch_Recursive(nums, 9));
        System.out.println(binarySearch_Iterative(nums, 11));
        System.out.println(binarySearch_Iterative(nums, -1));

    }

    public static int binarySearch_Iterative(int[] arr, int data) {

    // 1st and last indices:
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;

            if (arr[middle] == data) {
                return middle;
            }
        // if element is to the left or right of middle:
            if (data < arr[middle]) {
            // left half
                right = middle - 1;
            } else {
            // right half
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int binarySearch_Recursive(int[] arr, int data) {


        return binarySearch_Recursive(arr, data, 0, arr.length - 1);
    }

    public static int binarySearch_Recursive(int[] arr, int data, int left, int right) {

        if (left > right) {
            return -1;  // element NOT FOUND
        }

        int middle = (left + right) / 2;

        if (arr[middle] == data) {
            return middle;
        }
        // if element is to the left or right of middle:
        if (data < arr[middle]) {

            // Recursive call on LEFT half (right = middle - 1)
            return binarySearch_Recursive(arr, data, left, middle - 1);
        } else {

            // Recursive call on RIGHT half (left = middle + 1)
            return binarySearch_Recursive(arr, data, middle + 1, right);
        }
    }
}
