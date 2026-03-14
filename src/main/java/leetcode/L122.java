package leetcode;

public class L122 {
    public int maxProfit(int[] prices) {
        int[][] f = new int[prices.length][2];
        f[0][0] = 0;
        f[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][1] + prices[i]);
            f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i]);
        }
        return f[prices.length - 1][0];
    }

    // generate test case
    public static void main(String[] args) {
        L122 solution = new L122();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int result = solution.maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }
}
