package day03_LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class SinglyLinkedListApp {

    public static void main(String[] args) {

        MySinglyLinkedList myList = new MySinglyLinkedList();

        System.out.println(myList.isEmpty());

        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }
//        myList.printNodes();
//        myList.deleteById(9);
//        myList.printNodes();
//        System.out.println("-----------------------------------------");
//
//////  Assignment 1:
////        System.out.println("Index of 3: " + myList.indexOf(3));
////        System.out.println("-----------------------------------------");
////
//////  Assignment 2:
////        myList.addFirst(3);
////        myList.printNodes();
////        System.out.println("-----------------------------------------");

        myList.printNodes();
        System.out.println("Kth item from Last: " + myList.getKthItemFromLast(10));
        myList.removeKthItemFromLast(10);
        myList.printNodes();
    }
}
