package leetcode;

import java.util.Arrays;

public class L322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] f= new int[n+1][amount + 1];
        // f[0][0]=0;
        Arrays.fill(f[0], amount + 1);

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=amount; j++) {
                if (coins[i-1] > j) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - coins[i-1]] + 1);
                }
            }
        }
        int ans = f[n][amount];
        return ans > amount ? -1 : ans;
    }

    int dfs(int i, int amount, int[] coins) {
        if (i < 0) {
            return amount == 0 ? 0 : Integer.MAX_VALUE;
        }

        if (amount < coins[i]) {
            return dfs(i - 1, amount, coins);
        }
        return Math.min(dfs(i - 1, amount, coins), dfs(i, amount - coins[i], coins) + 1);
    }

    // generate test case
    public static void main(String[] args) {
        L322 solution = new L322();
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int result = solution.coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + result);
    }
}
