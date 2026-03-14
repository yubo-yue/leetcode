package leetcode;

public class L300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            ans = Math.max(ans, ++f[i]);
        }
        return ans;
    }

    // generate test case
    public static void main(String[] args) {
        L300 solution = new L300();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int result = solution.lengthOfLIS(nums);
        System.out.println("Length of longest increasing subsequence: " + result);
    }
}
