package leetcode;

import java.util.Arrays;

public class L151 {
    public String reverseWords(String s1) {
        String s = s1.trim();
        int end = s.length() - 1, start = end;
        StringBuffer ans = new StringBuffer();
        while (start >= 0) {
            while (start>=0 && s.charAt(start) != ' ') start--;
            ans.append(s, start + 1, end + 1).append(' ');
            while (start>=0 && s.charAt(start) == ' ') start--;
            end = start;
        }

        return ans.toString().trim();

    }
}
