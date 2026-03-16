package leetcode;

import java.util.PriorityQueue;

public class PQTest {

    // generate test for priority queue of int, to show lowest heap and highest heap
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int[] nums = {5, 3, 8, 1, 2};
        for (int num : nums) {
            minHeap.offer(num);
            maxHeap.offer(num);
        }

        System.out.println("Min Heap:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        System.out.println("Max Heap:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }
}
