package leetcode;

public class L1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer result = new StringBuffer();
        int n = word1.length(), m = word2.length();
        int minLen = Math.min(n, m);
        for (int i = 0; i < minLen; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }

        while (minLen < n) {
            result.append(word1.charAt(minLen++));
        }
        while (minLen < m) {
            result.append(word2.charAt(minLen++));
        }
        return result.toString();
    }
}
