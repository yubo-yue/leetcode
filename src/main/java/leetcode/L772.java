package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L772 {

    private int index;

    // Basic Calculator III
    // Implement a basic calculator to evaluate a simple expression string. The
    // expression string may contain open ( and closing parentheses ), the plus + or
    // minus sign -, non-negative
    // integers and empty spaces . The expression string contains only non-negative
    // integers, +, -, *, / operators , open ( and closing parentheses ) and empty
    // spaces . The integer division should truncate toward zero. You may assume
    // that the given expression is always valid. All intermediate results will be
    // in the range of [-231, 231 - 1]. Note: You are not allowed to use any
    // built-in function which evaluates strings as mathematical expressions, such
    // as eval().
    public int calculate(String s) {
        int[] result = helper(s, 0);
        // result[0] is the index of the closing parenthesis, result[1] is the value of
        // the expression
        return result[1];
    }

    private int[] helper(String s, int start) {
        int[] result = new int[2];
        int num = 0;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = start; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                num = num * 10 + (cur - '0');
            }

            if (cur == '(') {
                int[] innerResult = helper(s, i + 1);
                num = innerResult[1];
                i = innerResult[0];
            }

            if ((!Character.isDigit(cur) && cur != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = cur;
                num = 0;
            }

            if (cur == ')') {
                result[0] = i;
                break;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        result[1] = sum;
        return result;
    }

    // generate test case
    public static void main(String[] args) {
        L772 solution = new L772();
        String expression = "(3 + 2) * 2";
        int result = solution.calculate(expression);
        System.out.println("Result: " + result);
    }
}
