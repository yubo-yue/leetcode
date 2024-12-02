package leetcode;

public class L1768 {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.min(len1, len2);
        StringBuffer result = new StringBuffer();
        int idx = 0;
        while (idx < len) {
            result.append(word1.charAt(idx));
            result.append(word2.charAt(idx));
            idx++;
        }

        if (idx < len1) {
            result.append(word1.substring(idx));
        }

        if (idx < len2) {
            result.append(word2.substring(idx));
        }

        return result.toString();

    }
}
