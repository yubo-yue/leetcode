package leetcode;

public class L76 {
    public String minWindow(String s, String t) {
        int[] window = new int[256], need = new int[256];
        int minLen = Integer.MAX_VALUE, start = 0;
        int count = 0, valid = 0;
        for (char c : t.toCharArray()) {
            if (need[c] == 0) count++;
            need[c]++;
        }

        int n = s.length();
        int left = 0, right = 0;
        while (right < n) {
            char c = s.charAt(right++);

            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }

            while (valid == count) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char d = s.charAt(left++);
                if (need[d] > 0) {
                    if (need[d] == window[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        L76 algo = new L76();
        String result = algo.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }
}
