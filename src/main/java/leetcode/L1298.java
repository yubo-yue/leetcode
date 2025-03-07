package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class L1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        int n = status.length;
        boolean[] canOpen = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (!visited[box] && canOpen[box]) {
                visited[box] = true;
                queue.offer(box);
                ans += candies[box];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int key : keys[cur]) {
                canOpen[key] = true;
                if (!visited[key] && hasBox[key]) {
                    visited[key] = true;
                    ans += candies[key];
                    queue.offer(key);
                }
            }

            for (int box : containedBoxes[cur]) {
                hasBox[box] = true;
                if (!visited[box] && canOpen[box]) {
                    visited[box] = true;
                    ans += candies[box];
                    queue.offer(box);
                }

            }

        }


        return ans;
    }
}