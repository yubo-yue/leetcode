package leetcode;

import java.util.Stack;

public class L772 {
    public int calculate(String s) {
        return helper(s, 0)[1];
    }

    private int[] helper(String s, int start) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char preSign = '+';
        int[] pair = new int[2];

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }

            if (c == '(') {
                int[] tmp = helper(s, i+1);
                num = tmp[1];
                i = tmp[0]; // the index of corresponding ')' character.
            }

            if ((!Character.isDigit(c) && !Character.isSpaceChar(c)) || i == s.length() - 1) {
                int pre = 0;
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                preSign = c;
                num = 0;
            }
            if (c == ')') {
                pair[0] = i;
                break;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        pair[1] = result;
        return pair;
    }
}
