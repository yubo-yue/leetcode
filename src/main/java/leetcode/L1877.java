package leetcode;

import java.util.Arrays;

public class L1877 {

    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxSum = 0;
        for (int i = 0; i < n / 2; i++) {
            maxSum = Math.max(maxSum, nums[i] + nums[n - 1 - i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        L1877 solution = new L1877();
        int[] nums = {3, 5, 2, 3};
        int result = solution.minPairSum(nums);
        System.out.println("Minimum possible maximum pair sum: " + result);
    }
}
