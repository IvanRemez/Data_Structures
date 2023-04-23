package day06_AlgoProblems;

import day03_LinkedList.MySinglyLinkedList;
import day03_LinkedList.Node;

public class PrintMiddleNode {

    public static void main(String[] args) {
        MySinglyLinkedList sll= new MySinglyLinkedList();
        for (int i = 1; i <= 6; i++) {
            sll.add(i);
        }
        printMiddle(sll);
    }

    public static void printMiddle(MySinglyLinkedList sll) {
    // create 2 pointers:
        Node slow = sll.head;
        Node fast = sll.head;
    // iterate over the LinkedList:
        while (fast != sll.tail && fast.next != sll.tail) {
            slow = slow.next;           // single jump
            fast = fast.next.next;      // double jump
        }
    // fast is located on tail or before tail
        if (fast == sll.tail) {
            System.out.println(slow.id);    // on tail, ODD # of nodes -> 1 middle node
        } else {
            System.out.println(slow.id + ", " + slow.next.id);
            // before tail, EVEN # of nodes -> 2 middle nodes
        }
    }

}
