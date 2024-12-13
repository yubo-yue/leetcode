package leetcode;

public class L70 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        L70 l = new L70();
        int ans = l.climbStairs(3);
        System.out.println(ans);
        ans = l.climbStairs(2);
        System.out.println(ans);
    }
}
