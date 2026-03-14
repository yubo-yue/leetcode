package leetcode;

import java.util.Arrays;

public class L188 {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];  // buy[j]: 完成第j次买入后的最大利润
        int[] sell = new int[k + 1]; // sell[j]: 完成第j次卖出后的最大利润
        Arrays.fill(buy, Integer.MIN_VALUE / 2);
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        return sell[k];
    }

    private int dfs(int[] prices, int i, int j, int holding, int[][][] memo) {
        if (j < 0) {
            return Integer.MIN_VALUE / 2;
        }
        if (i < 0) {
            return holding == 0 ? 0 : Integer.MIN_VALUE / 2;
        }

        if (memo[i][j][holding] != 0) {
            return memo[i][j][holding];
        }

        if (holding == 0) {
            memo[i][j][holding] = Math.max(dfs(prices, i - 1, j, 0, memo),
                    dfs(prices, i - 1, j - 1, 1, memo) + prices[i]);
        } else {
            memo[i][j][holding] = Math.max(dfs(prices, i - 1, j, 1, memo), 
                    dfs(prices, i - 1, j, 0, memo) - prices[i]);
        }
        return memo[i][j][holding];
    }

    public static void main(String[] args) {
        L188 solution = new L188();
        int k = 2;
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        int result = solution.maxProfit(k, prices);
        System.out.println("Maximum profit with at most " + k + " transactions: " + result);
    }
}
