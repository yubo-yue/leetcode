package leetcode;

import java.util.PriorityQueue;

public class L786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0] * 1.0 / b[1], a[0] * 1.0 / a[1]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double fraction = arr[i] * 1.0 / arr[j];
                if (pq.size() < k || fraction < pq.peek()[0] * 1.0 / pq.peek()[1]) {
                    pq.offer(new int[]{arr[i], arr[j]});
                    if (pq.size() > k) {
                        pq.poll();
                    }
                }
            }
        }

        return pq.peek();
    }

    // generate test case
    public static void main(String[] args) {
        L786 solution = new L786();
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        int[] result = solution.kthSmallestPrimeFraction(arr, k);
        System.out.println("K-th smallest prime fraction: " + result[0] + "/" + result[1]);
    }
}
