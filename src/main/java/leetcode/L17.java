package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L17 {
    static Map<Character, String> PHONE_MAP = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder sb, List<String> ans) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        String chars = PHONE_MAP.get(digit);
        for (char c : chars.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb, ans);
            sb.deleteCharAt(index);
        }
    }
}
