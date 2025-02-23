package leetcode;

public class L221 {

    public int maximumSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int side = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] != '1') continue;
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                side = Math.max(side, dp[i][j]);
            }
        }
        return side * side;
    }
}
