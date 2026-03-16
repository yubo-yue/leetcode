package leetcode;

import java.util.Arrays;

public class L2747 {
    public int[] countServer(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[] result = new int[m];
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0])); // sorted by end of query time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1])); // sorted by end of log time

        int[] cnt = new int[n+1];
        int activeServers = 0;
        int left = 0, right= 0;
        for (int i = 0; i < m; i++) {
            int currentTime = sortedQueries[i][0];
            int index = sortedQueries[i][1];
            int windowStart = currentTime - x;

            while (right < logs.length && logs[right][1] <= currentTime) {
                int serverId = logs[right][0];
                if (cnt[serverId] == 0) {
                    activeServers++;
                }
                cnt[serverId]++;
                right++;
            }
            while (left < logs.length && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                cnt[serverId]--;
                if (cnt[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }
            result[index] = n - activeServers;
        }
        return result;
    }

    public static void main(String[] args) {
        L2747 solution = new L2747();
        int n = 3;
        int[][] logs = { { 1, 3 }, { 2, 6 }, { 1, 5 } };
        int x = 5;
        int[] queries = { 10, 11 };
        int[] result = solution.countServer(n, logs, x, queries);
        System.out.print("Count of missed servers for each query: ");
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}
