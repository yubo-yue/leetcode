package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i<=n; i++) {
            for (int j = 0; j <i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        L139 l = new L139();
        boolean ans = l.wordBreak("leetcode", List.of("leet", "code"));
        System.out.println(ans);
    }
}
