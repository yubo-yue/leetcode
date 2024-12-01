package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class L394 {
    public static void main(String[] args) {
        String s1 = "3[a2[c]]";
        L394 solution = new L394();
        String r = solution.decodeString(s1);
        System.out.println(r);
    }
    public String decodeString(String s) {
        Stack<String> stk = new Stack<>();
        int p = 0;
        char[] chars = s.toCharArray();
        while (p < chars.length) {
            char cur = chars[p];
            if (Character.isDigit(cur)) {
                StringBuilder buf = new StringBuilder();
                while (Character.isDigit(chars[p])) {
                    buf.append(chars[p++]);
                }
                stk.push(buf.toString());
            } else if (Character.isLetter(chars[p]) || chars[p] == '[') {
                stk.push(String.valueOf(chars[p++]));
            } else {
                p++; // skip ] character
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peek())) {
                    sub.addLast(stk.pop());
                }
                Collections.reverse(sub);

                stk.pop();// skip [
                int times = Integer.parseInt(stk.pop());
                StringBuilder sb = new StringBuilder();
                StringBuilder stkStr = new StringBuilder();
                for (String ss : sub) {
                    stkStr.append(ss);
                }
                String o = stkStr.toString();
                while (times-- > 0) {
                    sb.append(o);
                }
                stk.push(sb.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        Collections.reverse(stk);
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        return result.toString();
    }


}
