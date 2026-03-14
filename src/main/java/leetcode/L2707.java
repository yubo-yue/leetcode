package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class L2707 {
    public int extraCharacters(String s, String[] dictionary) {
        HashSet<String> dictSet = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // No extra characters needed for an empty string
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // Consider the current character as extra
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dictSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]); // No extra characters for this substring
                }
            }

        }
        return dp[n];
    }

    private int dfs(int start, String s, HashSet<String> dictSet) {
        // Implementation of the DFS function
        if (start == s.length()) {
            return 0;
        }

        int res = dfs(start + 1, s, dictSet) + 1; // Consider the current character as extra
        for (int j = start; j < s.length(); j++) {
            String substring = s.substring(start, j + 1);
            if (dictSet.contains(substring)) {
                res = Math.min(res, dfs(j + 1, s, dictSet)); // No extra characters for this substring
            }
        }
        return res;
    }

    // generate test case
    public static void main(String[] args) {
        L2707 solution = new L2707();
        String s = "leetcod";
        String[] dictionary = { "leet", "code", "leetcode" };
        int result = solution.extraCharacters(s, dictionary);
        System.out.println("Minimum extra characters needed: " + result);
    }
}
