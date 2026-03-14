package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L32 {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // 初始索引，方便计算长度
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // 更新基准索引
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    // generate test case
    public static void main(String[] args) {
        L32 solution = new L32();
        String s = "(()())";
        int result = solution.longestValidParentheses(s);
        System.out.println("Longest valid parentheses length: " + result);
    }
}
