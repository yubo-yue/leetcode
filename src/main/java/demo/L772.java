package demo;

import java.util.Stack;

public class L772 {
    public int calculate(String s) {
        return helper(s, 0)[1];
    }

    private int[] helper(String s, int start) {
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        int num = 0;
        int[] pair = new int[2];

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                int[] tmp = helper(s, i + 1);
                num = tmp[1];
                i = tmp[0];
            }

            if (!Character.isDigit(c) && !Character.isSpaceChar(c) || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                num = 0;
                preSign = c;
            }

            if (c == ')') {
                pair[0] = i;
                break;
            }
        }
        while (!stack.isEmpty()) {
            pair[1] += stack.pop();
        }
        return pair;
    }
}
