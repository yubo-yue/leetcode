package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L22 {
    public static final char[] LETTERS = new char[]{'(', ')'};

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(int n, int start, StringBuilder buffer, List<String> result) {
        if (start == n * 2) {
            if (isValid(buffer))
                result.add(buffer.toString());
            return;
        }

        for (char choice : LETTERS) {
            buffer.append(choice);
            backtrack(n, start + 1, buffer, result);
            buffer.deleteCharAt(buffer.length() - 1);
        }

    }

    boolean isValid(StringBuilder buffer) {
        int balance = 0;
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == '(') {
                balance++;
            }
            if (buffer.charAt(i) == ')') {
                balance--;
            }

            if (balance < 0)
                return false;
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        L22 algo = new L22();
        List<String> ans = algo.generateParenthesis(3);
        System.out.println(ans);
    }
}
