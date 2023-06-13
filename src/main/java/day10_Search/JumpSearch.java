package day10_Search;

public class JumpSearch {

    public static void main(String[] args) {

        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }

        System.out.println("Jump Search:");
        System.out.println(jumpSearch(nums, 6));
        System.out.println(jumpSearch(nums, 0));
        System.out.println(jumpSearch(nums, 9));
        System.out.println(jumpSearch(nums, 11));
        System.out.println(jumpSearch(nums, -1));

    }

    public static int jumpSearch(int[] arr, int data) {

        int blockSize = (int) Math.sqrt(arr.length);
        int start = 0;
        int next = blockSize;

        while (start < arr.length && arr[next - 1] < data) {
        // ^^ make sure we're within arr boundaries AND data is larger than
            // last element within current block = arr[next - 1]
            // if so, jump to next block:
            start = next;
            next += blockSize;

        // in case of uneven blockSizes, to avoid IndexOutOfBounds exception:
            if (next > arr.length) {
                next = arr.length;
            }
        }
        // Linear search within current block:
        for (int i = start; i < next; i++) {

            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

}
