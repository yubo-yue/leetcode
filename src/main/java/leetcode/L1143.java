package leetcode;

public class L1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n][m];
    }

    // generate test case
    public static void main(String[] args) {
        L1143 solution = new L1143();
        String text1 = "abcde";
        String text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println("Length of longest common subsequence: " + result);
    }
}
