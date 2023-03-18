package day03_LinkedList;

public class MySinglyLinkedList {

    Node head;
    Node tail;
    int size;
    boolean isEmpty() {
        return head == null;
    }

    void add(int data) {
        // create a new Node Object from data
        Node node = new Node(data);

        if (isEmpty()) {    // if list is empty
            head = tail = node;
            size++;
        }else {
            tail.next = node;
            tail = node;
            size++;
        }
    }
//  Assignment 2:
    void addFirst(int data) {

        Node node = new Node(data);

        if (isEmpty()) {
            head = tail = node;
            size++;
        }else {
            node.next = head;
            head = node;
        }
    }


    void deleteById(int id) {
        // check if empty
        if (isEmpty()) {
            System.out.println("List is empty!");
        }
        // assign prev and current with the head

        Node prev = head;
        Node current = head;

        while (current != null) {

            if (current.id == id) { // if there is a match

        // case 1 - head
                if (current == head) {
                    head = current.next;
                    current.next = null;

        // case 2 - tail
                } else if (current == tail) {
                    tail = prev;    // 2nd to last becomes tail
                    prev.next = null;   // ex-tail becomes eligible for GC

        // case 3 - middle
                }else {
                    prev.next = current.next;
                    current.next = null;    // current becomes eligible for GC
                }
                size--;
            }
            // move forward in List until current = null
            prev = current;
            current = current.next;
        }
    }

//  Assignment 1:
    int indexOf(int id) {

        if (isEmpty()) {
            return -1;
        }
        int position = 0;

    // iterate through the list:
        Node current = head;    // set my current with the starting element (head)
        while (current != null) {

            if (current.id == id) {
                return position;
            }
            position++;
            current = current.next;
        }
        return -1;
    }

    void printNodes() {

        Node current = head;
        while (current != null) {

            if (current.next == null) {
                System.out.println(current.id + " -> null");
            } else {
                System.out.print(current.id + " -> ");
            }
            current = current.next;
        }
    }
}
