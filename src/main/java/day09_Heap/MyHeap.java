package day09_Heap;

import java.util.NoSuchElementException;

public class MyHeap {

    int[] items;
    int size;

    public MyHeap(int capacity) {
        this.items = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (size == items.length) {
            throw new IllegalStateException();
        } else {
            items[size] = value;
            size++;
            bubbleUp();
        }
    }

    public void bubbleUp() {
        // calculate start point/index
        int index = size - 1; // position of last inserted element

        // while index > 0 && parent is < child, continue
        // 1. swap parent and child
        // 2. calculate next parent index
        while (index > 0 && items[index] > items[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index); // like current = current.next
        }
    }

    public void bubbleDown() {
        // start from root
        int index = 0;
        int largerChildIndex;

        while (index <= size && !isValidParent(index)) {

            largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex); // swap parent and larger child
            index = largerChildIndex;   // assign larger child as new parent
        }
    }

    public void printHeap() {

        for (int i = 0; i < size; i++) {

            System.out.print(items[i] + ", ");
        }
        System.out.println();
    }

    public int remove() {

        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            int result = items[0]; // store root's value into temp variable (result),
                                // which remove method will return
            items[0] = items[size - 1]; // assign last element to root
            size--;
            bubbleDown();
            return result;
        }
    }

    public int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public boolean hasLeftChild(int index) {

        return leftChildIndex(index) < size;
        // if child index is < Heap size, it's a valid index
    }

    public boolean hasRightChild(int index) {

        return rightChildIndex(index) < size;
    }

    public int largerChildIndex(int index) {
        // no child:
        if (!hasLeftChild(index)) {
            return index;
        }
        // 1 child (must be left):
        else if (!hasRightChild(index)) {
            return leftChildIndex(index);
        }
        // 2 children:
        return (items[leftChildIndex(index)] > items[rightChildIndex(index)])
                ? leftChildIndex(index) : rightChildIndex(index);
             // if leftChild value (items[]) > rightChild value,
                // return leftChild index, else return rightChild index
    }

    public void swap(int first, int second) {

        int temp = items[first]; // store 1st value into temp

        items[first] = items[second];
        items[second] = temp;
    }

    public boolean isValidParent(int index) {

        if (!hasLeftChild(index)) { // if there are no children to check values against,
                                    // it's a valid parent
            return true;
        } else {
            boolean isValid = items[index] > items[leftChildIndex(index)];
            // ^^ if parent value > leftChild value, parent isValid

            if (hasRightChild(index)) { // check if there is also a rightChild
                isValid= (items[index] >= items[leftChildIndex(index)] &&
                        items[index] >= items[rightChildIndex(index)]);
                // compare parents value against rightChild value
            }
            return isValid;
        }
    }

}
