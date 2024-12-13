package leetcode;

import java.util.*;

public class L17 {
    public static final Map<Character, String> PHONE_MAP = new HashMap<>();

    static {
        PHONE_MAP.put('2', "abc");
        PHONE_MAP.put('3', "def");
        PHONE_MAP.put('4', "ghi");
        PHONE_MAP.put('5', "jkl");
        PHONE_MAP.put('6', "mno");
        PHONE_MAP.put('7', "pqrs");
        PHONE_MAP.put('8', "tuv");
        PHONE_MAP.put('9', "wxyz");
    }

    public List<String> letterCombination(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        backtrack(digits, 0, buffer, ans);
        return ans;
    }

    private void backtrack(String digits, int start, StringBuilder buffer, List<String> ans) {
        if (buffer.length() == digits.length()) {
            ans.add(buffer.toString());
            return;
        }

        Character c = digits.charAt(start);
        String choices = PHONE_MAP.get(c);
        for (char choice : choices.toCharArray()) {
            buffer.append(choice);
            backtrack(digits, start+1, buffer, ans);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public static void main(String[] args) {
        L17 ins = new L17();
        String digits = "23";
        List<String> result = ins.letterCombination(digits);
        System.out.println(result);
        result = ins.letterCombination("2");
        System.out.println(result);
    }
}
