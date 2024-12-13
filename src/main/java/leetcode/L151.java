package leetcode;

import java.util.Arrays;

public class L151 {
    public String reverseWords(String s) {
        String t = s.strip();
        String[] words = t.split("\s+");
        StringBuffer buf = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            buf.append(words[i]);
            if (i != 0) {
                buf.append(' ');
            }
        }
        return buf.toString();

    }
}
