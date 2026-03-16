package leetcode;

public class L2730 {

    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int same = 0;
        int left = 0;
        for (int right = 1; right < n; right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                same++;
            }
            while (same > 1) {
                if (s.charAt(left) == s.charAt(left + 1)) {
                    same--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        L2730 solution = new L2730();
        String s = "52233";
        int result = solution.longestSemiRepetitiveSubstring(s);
        System.out.println("Length of the longest semi-repetitive substring: " + result);
    }
}
