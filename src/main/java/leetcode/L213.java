package leetcode;

public class L213 {
    
    // 213. House Robber II
    // https://leetcode.com/problems/house-robber-ii/
    // You are a professional robber planning to rob houses along a street. Each
    // house has a certain amount of money stashed, the only constraint stopping
    // you from robbing each of them is that adjacent houses have security systems
    // connected and it will automatically contact the police if two adjacent
    // houses were broken into on the same night.
    // Given an integer array nums representing the amount of money of each house,
    // return the maximum amount of money you can rob tonight without alerting the
    // police.
    // Example 1:
    // Input: nums = [2,3,2]
    // Output: 3
    // Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
    // 2), because they are adjacent houses.
    // Example 2:
    // Input: nums = [1,2,3,1]
    // Output: 4
    // Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    // Total amount you can rob = 1 + 3 = 4.
    // Example 3:
    // Input: nums = [0]
    // Output: 0
    // Constraints:
    // 1 <= nums.length <= 100
    // 0 <= nums[i] <= 1000

     public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
     }

     private int rob(int[] nums, int start, int end) {
        int[] df = new int[end - start + 1];
        df[0] = nums[start];
        if (end - start >= 1) {
            df[1] = Math.max(nums[start], nums[start + 1]);
        }
        for (int i = 2; i < df.length; i++) {
            df[i] = Math.max(df[i - 1], df[i - 2] + nums[start + i]);
        }
        return df[df.length - 1];
     }

     public static void main(String[] args) {
        L213 solution = new L213();
        int[] nums = {2, 3, 2};
        int result = solution.rob(nums);
        System.out.println("Maximum amount of money you can rob: " + result);       
     }
}
