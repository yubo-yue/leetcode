package leetcode;

public class L121 {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }

    // generate test case
    public static void main(String[] args) {
        L121 solution = new L121();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int result = solution.maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }
}
