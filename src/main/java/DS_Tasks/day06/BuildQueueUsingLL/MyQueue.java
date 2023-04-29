package DS_Tasks.day06.BuildQueueUsingLL;
/*
Queues -Task
Build a queue using a linked list from scratch.
Implement the following operations.

-enqueue
-dequeue
-peek
-size
-isEmpty
 */

import java.util.NoSuchElementException;

public class MyQueue<T> {

    QNode<T> head;
    QNode<T> tail;
    int size;

    public MyQueue() {
    }

    boolean isEmpty() {
        return head == null;
    }

    void enqueue(T item) {                  // same as Add Last in LL
        QNode<T> node = new QNode<>(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    T dequeue() {                           // same as Remove First in LL
        QNode<T> headNode;

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {     // 1 element
            headNode = head;
            head = tail = null;
        } else {
            headNode = head;
            head = head.next;
        }
        size--;
        return headNode.value;
    }

    T peek() {
        return head.value;
    }

    int size() {
        return size;
    }

    void printQueue() {
        if (isEmpty()) return;

        QNode<T> current = head;

        while (current != null) {
            System.out.print(current.value);

            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
    }
}