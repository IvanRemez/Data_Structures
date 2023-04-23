package day06_AlgoProblems.ReversedLL;

public class Solution {
    public static void main(String[] args) {
        MySinglyLinkedList list = new MySinglyLinkedList();

        for (int i = 0; i < 10; i++) list.add(i);
        list.printNodes();
        System.out.println("After reverse in one pass");
        reverse(list);
        list.printNodes();
    }

    static void reverse(MySinglyLinkedList list) {
    // create two pointers
        Node prev = list.head;
        Node current = list.head.next;
    // while loop to iterate until current = null
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;    // change direction current to prev
            prev = current;         // move prev right to the current pos
            current = nextNode;     // move current right to the nextNode pos
        }
    // reverse head and tail
        list.tail = list.head;
        list.tail.next = null;
        list.head = prev;
    }
}