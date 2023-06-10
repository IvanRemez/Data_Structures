package day09_Heap;

public class HeapApp {

    public static void main(String[] args) {

        MyHeap heap = new MyHeap(10);
        heap.insert(61);
        heap.insert(120);
        heap.insert(52);
        heap.insert(45);
        heap.insert(81);

        System.out.println("Heap values after inserting 81");
        heap.printHeap();

        System.out.println(heap.remove());
        System.out.println("Heap values after removing 120");
        heap.printHeap();

        heap.insert(130);
        heap.printHeap();

        int[] numbers = {1, 2, 5, 6, 8, 21, 0};
        int[] numbers2 = {5, 8, 6, 8, 8, 2, 1, 5, 7, 6, 7, 4};
        MyHeap heap2 = new MyHeap(numbers);
        MyHeap heap3 = new MyHeap(numbers2);
        System.out.println("Printing heapified array");
        heap2.printHeap();
        heap3.printHeap();

    }
}
