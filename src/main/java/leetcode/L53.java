package leetcode;

public class L53 {

    // 53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // generate test case
    public static void main(String[] args) {
        L53 solution = new L53();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = solution.maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
    }
}
