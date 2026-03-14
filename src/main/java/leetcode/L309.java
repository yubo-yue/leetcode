package leetcode;

public class L309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int[][] f = new int[n][2];

        f[0][0] = 0; // Not holding stock on day 0
        f[0][1] = -prices[0]; // Holding stock on day
        f[1][0] = Math.max(f[0][0], f[0][1] + prices[1]); // Not holding stock on day 1
        f[1][1] = Math.max(f[0][1], f[0][0] - prices[1]); // Holding stock on day 1

        for (int i = 2; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]); // Not holding stock on day i
            f[i][1] = Math.max(f[i - 1][1], f[i - 2][0] - prices[i]); // Holding stock on day i
        }
        return f[n - 1][0]; // Maximum profit on the last day when not
    }

    // generate test case
    public static void main(String[] args) {
        L309 solution = new L309();
        int[] prices = { 1, 2, 3, 0, 2 };
        int result = solution.maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }
}
