package leetcode;

public class L1768 {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.min(len1, len2);

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            buffer.append(word1.charAt(i));
            buffer.append(word2.charAt(i));
        }
        if (len < len1) {
            buffer.append(word1.substring(len));
        }

        if (len < len2) {
            buffer.append(word2.substring(len));
        }
        return buffer.toString();
    }
}
