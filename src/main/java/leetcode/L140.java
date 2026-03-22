package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class L140 {
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet);
    }

    private List<String> dfs(String s, Set<String> wordSet) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int i = 1; i < s.length()+1; i++) {
            String prefixString = s.substring(0,i);
            if (wordSet.contains(prefixString)) {
                List<String> suffixWays = dfs(s.substring(i), wordSet);
                for (String way : suffixWays) {
                    String joined = way.isEmpty() ? prefixString : prefixString + " " + way;
                    result.add(joined);
                }
            }
        }
        memo.put(s, result);

        return result;
    }

    //generate test case
    public static void main(String[] args) {
        L140 solution = new L140();
        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        List<String> result = solution.wordBreak(s, wordDict);
        System.out.println("Possible sentences: " + result);
    }
}
