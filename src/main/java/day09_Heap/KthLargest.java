package day09_Heap;

public class KthLargest {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 1, 5, 6, 4};
        System.out.println(getKthLargest(numbers, 2));
    }

    public static int getKthLargest(int[] array, int k) {

    // Create a Heap
        MyHeap heap = new MyHeap(array.length);

    // Put array into Heap
        for (int i = 0; i < array.length; i++) {
            heap.insert(array[i]);
        }
    // Remove root k-1 timesf
        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }
    // Return root
        return heap.peek();
    }
}
