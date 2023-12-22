package ms;

import java.util.Stack;

public class T2 {

    // + - * / 0-9 ( )
    // a - b * c + d
    // a, b, c -> a, b * c, d -> a, b*c + d -> a - b*c +d
    // (-,+), (/ *), -> - -> -, + -> - -> ...
    //

    int compute(String expr) {
        int result = 0;
        int n = expr.length();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = expr.charAt(i);
            int term = 0;
            if ( c >= '0' && c <= '9') {
                while (i < n) {
                    term = term * 10 + (c - '0');
                    i++;
                }
            }

        }
        return result;
    }
}
