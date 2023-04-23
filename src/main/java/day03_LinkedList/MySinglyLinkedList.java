package day03_LinkedList;

public class MySinglyLinkedList {

    public Node head;
    public Node tail;
    int size;

    boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        // create a new Node Object from data
        Node node = new Node(data);

        if (isEmpty()) {    // if list is empty
            head = tail = node;
            size++;
        } else {
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
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public int getKthItemFromLast(int k) {
        // create 2 pointers
        Node ptr1 = head;
        Node ptr2 = head;
        // move ptr2 K-1 times
        for (int i = 0; i < k - 1; i++) {

            ptr2 = ptr2.next;
        }
        // move both pointers until ptr2 hits last element
        while (ptr2.next != null) {

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // ptr1 is on the Kth element from the Last
        return ptr1.id;
    }
// *** INTERVIEW TASK: ***
    public void removeKthItemFromLast(int k) {
        // create 3 pointers
        Node ptr1 = head;
        Node ptr2 = head;
        Node prev = null;
        // ^^ need additional pointer to connect list after removal

        // move ptr2 K-1 times
        for (int i = 0; i < k - 1; i++) {

            ptr2 = ptr2.next;
        }
        // move both pointers until ptr2 hits last element
        while (ptr2.next != null) {

            prev = ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // ptr1 is on the Kth element from the Last
        // Do delete operation
        if (ptr1 == head) {

            head = ptr1.next;
            ptr1.next = null;
            size--;

        } else if (ptr1 == tail) {

            tail = prev;
            prev.next = null;
            size--;

        } else {

            prev.next = ptr1.next;
            ptr1.next = null;
            size--;
        }
    }

    public void removeKthFromLast2(int k) {
        Node ptr1 = head;
        Node ptr2 = head;
        for (int i = 0; i < k - 1; i++) {

            ptr2 = ptr2.next;

            if (ptr2 == null) System.out.println("Less than k elements");

            else if (ptr2.next == null) {
                head = ptr1.next;
                ptr1.next = null;
                return;
            }
        }
        while (ptr2.next.next != null) {

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

        }

        ptr1.next = ptr1.next.next;
        ptr1 = ptr1.next;
        ptr1 = null;
    }

        void deleteById ( int id){      // Uses 2 passes (delete operation is the 2nd)
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
                    } else {
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
        int indexOf ( int id){

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

        void printNodes () {

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
