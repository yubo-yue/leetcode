package leetcode;

public class L209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int left = 0;
        int s = 0;
        for (int right = 0; right < n; right++) {
            int x = nums[right];
            s += x;
            while (s >= target) {
                ans = Math.min(ans, right - left + 1);
                s -= nums[left];
                left++;
            }
            
        }
        return ans < n + 1 ? ans : 0;

    }
    // generate test case
    public static void main(String[] args) {
        L209 l209 = new L209();
        System.out.println(l209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
