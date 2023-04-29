package DS_Tasks.day06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class CollectionsQueueTasks {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add("John");
        priorityQueue.add("Michael");
        priorityQueue.add("Carol");
        System.out.println(priorityQueue.remove());     // Carol
        System.out.println(priorityQueue.remove());     // John
        System.out.println(priorityQueue.remove());     // Michael
        // ^^ No Comparator defined so removes in Alphabetical order

    }
}
