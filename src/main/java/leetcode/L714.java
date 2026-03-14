package leetcode;

public class L714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] f = new int[prices.length][2];
        f[0][0] = 0;
        f[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][1] + prices[i] - fee);
            f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i]);
        }
        return f[prices.length - 1][0];
    }

    // generate test case
    public static void main(String[] args) {
        L714 solution = new L714();
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        int result = solution.maxProfit(prices, fee);
        System.out.println("Maximum profit: " + result);
    }
}
