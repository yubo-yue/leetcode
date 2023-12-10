package utils;

import java.util.LinkedList;

public class MonotonicQueue {
    private LinkedList<Integer> queue = new LinkedList<>();

    public void push(int n) {
        while (!queue.isEmpty() && queue.getLast() < n) {
            queue.pollLast();
        }
        queue.addLast(n);
    }

    public int max() {
        return queue.getFirst();
    }

    public void pop(int n) {
        if (n == queue.getFirst())
            queue.pollFirst();
    }
}
