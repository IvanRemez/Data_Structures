package Review.Stacks;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T t) {
        this.value = t;
    }
}