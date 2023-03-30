package day04_LinkedLists;

public class UserLinkedList {

    UserNode head;
    UserNode tail;
    int size;

    public UserLinkedList() {
        this.size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void insertLast(UserNode node) {
// 1. list is empty
        if (isEmpty()) {
            head = tail = node;
// 2. not empty
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void printNames() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
// assign current to head
        UserNode current = head;
// loop
        System.out.println();
        while (current != null) {
            System.out.print(current.name + " -> ");
            current = current.next;
            if (current == null) {
                System.out.print("null");
            }
        }
    }

    void deleteByName(String name) {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        UserNode previous = head;
        UserNode current = head;
        while (current != null) {
            if (current.name.equals(name)) {
            // case 1: head
                if (current == head) {
                    if (head == tail) {
                        tail = null;
                    }
                    head = current.next;
                    current.next = null;
                }
            // case 2: tail
                if (current == tail) {
                    previous.next = null;
                    tail = previous;
            // case 3: middle
                } else {
                    previous.next = current.next;
                    current.next = null;
                }
                size--;
            }
            previous = current;
            current = current.next;
        }
    }

}
