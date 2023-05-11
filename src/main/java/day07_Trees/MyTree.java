package day07_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {

    public TNode root;

    public MyTree() {
    }

    public void insert(int value) {

        TNode newNode = new TNode(value);
    // Tree is empty:
        if (root == null) {
            root = newNode;
            return;
        }
    // Tree NOT empty -> find place (null) to insert new Node
        TNode current = root;

        while (true) {             // will loop until insertion of newNode
            if (value <= current.value) {
        // ^^ LESS THAN current Node -> branch LEFT
                if (current.leftChild == null) {
                // if left is null -> insert here
                    current.leftChild = newNode;
                    break;      // exit loop after insertion
                }
            // if left is NOT null -> go 1 level deeper and repeat while loop
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                // if left is null -> insert here
                    current.rightChild = newNode;
                    break;      // exit loop after insertion
                }
            // if right is NOT null -> go 1 level deeper and repeat while loop
                current = current.rightChild;
            }
        }
    }

    // Pre-Order: Root - Left - Right
    public void preOrderTraversal(TNode root) {

        if (root == null) {     // base condition - termination
            return;
        }
        System.out.print(root.value + ", ");  // visit Root
        preOrderTraversal(root.leftChild);      // visit Left subtree
        preOrderTraversal(root.rightChild);     // visit Right subtree
    }

    // In-Order: Left - Root - Right
    public void inOrderTraversal(TNode root) {     // Ascending Order **

        if (root == null) {     // base condition - termination
            return;
        }
        inOrderTraversal(root.leftChild);
        System.out.print(root.value + ", ");
        inOrderTraversal(root.rightChild);
    }

    // Post-Order: Left - Right - Root
    public void postOrderTraversal(TNode root) {

        if (root == null) {     // base condition - termination
            return;
        }
        postOrderTraversal(root.leftChild);      // visit Left subtree
        postOrderTraversal(root.rightChild);     // visit Right subtree
        System.out.print(root.value + ", ");  // visit Root

    }
    // Level-Order
    public void levelOrderTraversal(TNode root) {

        if (root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode toVisit = queue.poll();   // pull node without removing
            System.out.print(toVisit.value + ", ");

            if (toVisit.leftChild != null) {
                queue.add(toVisit.leftChild);
            }
            if (toVisit.rightChild != null) {
                queue.add(toVisit.rightChild);
            }
        }
    }
}
