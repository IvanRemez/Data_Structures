package DS_Tasks.day06.BuildQueueUsingLL;

public class QNode<T> {
   T value;
   QNode<T> next;

    public QNode(T value) {
        this.value = value;
    }

}