package leetcode;

public class L518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - coins[i - 1]];
                }
            }
        }
        return f[n][amount];
    }

    // generate test case
    public static void main(String[] args) {
        L518 solution = new L518();
        int amount = 5;
        int[] coins = { 1, 2, 5 };
        int result = solution.change(amount, coins);
        System.out.println("Number of combinations: " + result);
    }
}
