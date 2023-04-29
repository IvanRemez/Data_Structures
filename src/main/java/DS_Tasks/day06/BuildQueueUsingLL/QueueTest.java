package DS_Tasks.day06.BuildQueueUsingLL;

public class QueueTest {

    public static void main(String[] args) {

        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println("Size of Queue is: " + myQueue.size);
        System.out.println("Head is: " + myQueue.peek());
        System.out.println("1st element removed from Queue: " + myQueue.dequeue());
        System.out.println("Head is: " + myQueue.peek());
    }
}
