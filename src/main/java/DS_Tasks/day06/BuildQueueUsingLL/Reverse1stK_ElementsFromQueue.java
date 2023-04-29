package DS_Tasks.day06.BuildQueueUsingLL;
/*
Queues -Assignment
1. Given an integer K and a queue of integers, write code to reverse the order of the
first K elements of the queue.

-Input: Q = [10, 20, 30, 40, 50], K = 4 -Output: Q = [40,30, 20, 10,50]

Hint: You can use stack to reverse the order of first K elements
 */

import DS_Tasks.day06.BuildQueueUsingLL.MyQueue;

import java.util.Stack;

public class Reverse1stK_ElementsFromQueue {

    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        System.out.println("Initial Queue: ");
        queue.printQueue();
        System.out.println();
        System.out.println("After 1st K elements reversed: ");
        reverseFirstK_Elements(queue, 4).printQueue();
    }


    public static MyQueue<Integer> reverseFirstK_Elements(MyQueue<Integer> queue, int K) {

// create a Stack
        Stack<Integer> stack = new Stack<>();
// push K elements into stack
        for (int i = 0; i < K; i++) {
            stack.push(queue.dequeue());
        }
// enqueue(add) elements back into queue
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
// dequeue(remove) and enqueue(add) size of queue - K times
    // remove REMAINING elements from HEAD (front) of queue and place
    // them in the end so that your original K elements which were
    // reversed are back it the beginning of the queue
        for (int i = 0; i < queue.size - K; i++) {
            queue.enqueue(queue.dequeue());
        }

        return queue;
    }

}
