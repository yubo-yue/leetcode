package leetcode;

public class L279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏情况，i个1的平方
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    // generate test case
    public static void main(String[] args) {
        L279 solution = new L279();
        int n = 12;
        int result = solution.numSquares(n);
        System.out.println("Minimum number of perfect squares: " + result);
    }
}
