package leetcode;

import java.util.Arrays;

public class L494 {

    // 494. Target Sum
    // https://leetcode.com/problems/target-sum/
    // You are given an integer array nums and an integer target.
    // You want to build an expression out of nums by adding one of the symbols
    // '+' and '-' before each integer in nums and concatenating all the
    // integers.
    // For example, if nums = [2, 1], you can add a '+' before 2 and a '-'
    // before 1 and concatenate them to build the expression "+2-1".
    // Return the number of different expressions that you can build, which
    // evaluates to target.
    // Example 1:
    // Input: nums = [1,1,1,1,1], target = 3
    // Output: 5
    // Explanation: There are 5 ways to assign symbols to make the sum of nums be
    // target 3.
    // -1 + 1 + 1 + 1 + 1 = 3
    // +1 - 1 + 1 + 1 + 1 = 3
    // +1 + 1 - 1 + 1 + 1 = 3
    // +1 + 1 + 1 - 1 + 1 = 3
    // +1 + 1 + 1 + 1 - 1 = 3
    // Example 2:
    // Input: nums = [2,7,9,3,4], target = 10
    // Output: 0
    // Constraints:
    // 1 <= nums.length <= 20
    // 0 <= nums[i] <= 1000
    // -1000 <= target <= 1000

    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }

        s += target;
        if (s < 0 || s % 2 != 0) {
            return 0;
        }

        // capacity
        int c = s / 2;
        int n = nums.length;
        int[][] memo = new int[n][c + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, n - 1, c, memo);
    }

    int dfs(int[] nums, int i, int c, int[][] memo) {
        if (i < 0) {
            return c == 0 ? 1 : 0;
        }

        if (memo[i][c] != -1) {
            return memo[i][c];
        }
        memo[i][c] = dfs(nums, i - 1, c, memo) + dfs(nums, i - 1, c - nums[i], memo);
        return memo[i][c];
    }
}
