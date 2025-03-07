package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int right = 0, n = words.length;
        while (true) {
            int left = right;
            int sumLen = 0;
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right].length();
                right++;
            }

            if (right == n) {
                StringBuffer sb = joins(words, left, right, " ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                ans.add(sb.toString());
                continue;
            }

            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);

            StringBuffer sb = new StringBuffer();
            sb.append(joins(words, left, left + extraSpaces + 1, blank(avgSpaces + 1)));
            sb.append(blank(avgSpaces));
            sb.append(joins(words, left + extraSpaces + 1, right, blank(avgSpaces)));
            ans.add(sb.toString());
        }
    }

    private String blank(int nChars) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < nChars; j++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private StringBuffer joins(String[] words, int left, int right, String sep) {
        StringBuffer res = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; i++) {
            res.append(sep);
            res.append(words[i]);
        }
        return res;
    }
}
