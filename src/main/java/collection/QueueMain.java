package collection;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
