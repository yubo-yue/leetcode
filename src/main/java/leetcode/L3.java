package leetcode;

public class L3 {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            int c = s.charAt(right);
            count[c]++;
            right++;
            while (count[c] > 1) {
                int d = s.charAt(left++);
                count[d]--;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args) {
        L3 algo = new L3();
        int r = algo.lengthOfLongestSubstring(" ");
        System.out.println(r);
    }
}
