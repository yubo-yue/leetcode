package leetcode;

import java.util.Arrays;

public class L188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] df = new int[n + 1][k + 1][2];
        for (int[][] matrix : df) {
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MIN_VALUE / 2);
            }
        }
        for (int j = 0; j <= k; j++) {
            df[0][j][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            df[i][0][0] = df[i - 1][0][0];
            df[i][0][1] = Math.max(df[i - 1][0][1], df[i - 1][0][0] - prices[i - 1]);
            for (int j = 1; j <= k; j++) {
                df[i][j][0] = Math.max(df[i - 1][j][0], df[i - 1][j - 1][1] + prices[i - 1]);
                df[i][j][1] = Math.max(df[i - 1][j][1], df[i - 1][j][0] - prices[i - 1]);
            }
        }
        return df[n][k][0];
    }

    private int dfs(int days, int times, int holding, int[] prices, int[][][] memo) {
        if (times < 0) {
            return Integer.MIN_VALUE / 2;
        }
        if (days < 0) {
            return holding == 0 ? 0 : Integer.MIN_VALUE / 2;
        }

        if (memo[days][times][holding] != 0) {
            return memo[days][times][holding];
        }

        if (holding == 0) {
            memo[days][times][holding] = Math.max(dfs(days - 1, times, 0, prices, memo),
                    dfs(days - 1, times - 1, 1, prices, memo) + prices[days]);
        } else {
            memo[days][times][holding] = Math.max(dfs(days - 1, times, 1, prices, memo),
                    dfs(days - 1, times, 0, prices, memo) - prices[days]);
        }
        return memo[days][times][holding];
    }

    public static void main(String[] args) {
        L188 solution = new L188();
        int k = 2;
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        int result = solution.maxProfit(k, prices);
        System.out.println("Maximum profit with at most " + k + " transactions: " + result);
    }
}
