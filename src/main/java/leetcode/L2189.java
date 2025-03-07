package leetcode;

public class L2189 {
    public int houseOfCards(int n) {
        int maxTriangles = (n + 1) / 3;
        int[][] dp = new int[maxTriangles + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= maxTriangles; i++) {
            int currCards = 3 * i - 1;
            for (int j = 0; j <= n; j++) {
                if (j < currCards) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - currCards];
                }
            }

        }
        return dp[maxTriangles][n];
    }
}
