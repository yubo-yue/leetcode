package leetcode;

import java.util.Arrays;

public class L151 {
    public String reverseWords(String s1) {
        String s = s1.trim();
        int end = s1.length() - 1, start = end;

        StringBuffer buffer = new StringBuffer();
        while (start >= 0) {
            while ((start >= 0 && s.charAt(start) != ' ')) {
                start--;
            }
            buffer.append(s.substring(start + 1, end + 1)).append(' ');
            while (start >= 0 && s.charAt(start) == ' ') {
                start--;
            }
            end = start;
        }
        return buffer.toString().trim();
    }
}
