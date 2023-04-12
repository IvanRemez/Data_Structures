package day05_Stacks;

import java.util.Deque;
import java.util.LinkedList;

public class CollectionStack {

    public static void main(String[] args) {

        Deque<Integer> collectionStack = new LinkedList<>();
        collectionStack.push(1);
        collectionStack.push(2);
        collectionStack.push(3);
        System.out.println(collectionStack.peek());
        System.out.println(collectionStack.pop());
        System.out.println("peek is: " + collectionStack.peek());

    }
}
