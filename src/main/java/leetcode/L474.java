package leetcode;

import java.util.Arrays;

public class L474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int k = strs.length;
        int[] cnts = new int[k];
        for (int i = 0; i < k; i++) {
            cnts[i] = count(strs[i]);
        }

        int[][][] memo = new int[k][m + 1][n + 1];
        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return dfs(k - 1, m, n, strs, cnts, memo);
    }

    private int dfs(int i, int j, int k, String[] strs, int[] cnts, int[][][] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        // not choose strs[i]
        int res = dfs(i - 1, j, k, strs, cnts, memo);
        // choose strs[i]
        int zeros = cnts[i];
        int ones = strs[i].length() - zeros;
        if (j >= zeros && k >= ones) {
            res = Math.max(res, dfs(i - 1, j - zeros, k - ones, strs, cnts, memo) + 1);
        }
        memo[i][j][k] = res;
        return res;
    }

    private int count(String str) {
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                cnt++;
            }
        }
        return cnt;
    }

}
