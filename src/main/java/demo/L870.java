package demo;

import java.util.PriorityQueue;

public class L870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }

        int left = 0, right = n - 1;
        int[] ans = new int[n];

        while (!maxpq.isEmpty()) {
            int[] cur = maxpq.poll();
            int i = cur[0], maxval = cur[1];
            if (maxval < nums1[right]) {
                ans[i] = nums1[right--];
            } else {
                ans[i] = nums1[left++];
            }
        }

        return ans;
    }

}
