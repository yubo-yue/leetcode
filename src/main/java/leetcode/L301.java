package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L301 {

    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0, rRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lRemove++;
            } else if (c == ')') {
                if (lRemove > 0) {
                    lRemove--;
                } else {
                    rRemove++;
                }
            }
        }

        List<String> ans = new ArrayList<>();
        dfs(s, 0, lRemove, rRemove, ans);
        return ans;
    }

    private void dfs(String s, int start, int lRemove, int rRemove, List<String> ans) {
        if (lRemove == 0 && rRemove == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(' && lRemove > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), i, lRemove - 1, rRemove, ans);
            } else if (s.charAt(i) == ')' && rRemove > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), i, lRemove, rRemove - 1, ans);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) { // More ')' than '('
                    return false;
                }
            }
        }
        return count == 0;
    }

    // generate test case
    public static void main(String[] args) {
        L301 solution = new L301();
        String s = "()())()";
        List<String> result = solution.removeInvalidParentheses(s);
        System.out.println("Valid strings after removing invalid parentheses: " + result);
    }
}
