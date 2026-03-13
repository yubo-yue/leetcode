package leetcode;

public class L1749 {

    public int maxAbsoluteSum(int[] nums) {
        int positiveSum = 0, negativeSum = 0;
        int positiveMax = 0, negativeMin = 0;
        for (int num : nums) {
            positiveSum += num;
            negativeSum += num;
            positiveMax = Math.max(positiveMax, positiveSum);
            negativeMin = Math.min(negativeMin, negativeSum);
            positiveSum = Math.max(positiveSum, 0);
            negativeSum = Math.min(negativeSum, 0);
        }
        return Math.max(positiveMax, -negativeMin);

    }

    // generate test case
    public static void main(String[] args) {
        L1749 solution = new L1749();
        int[] nums = { 1, -3, 2, 3, -4 };
        int result = solution.maxAbsoluteSum(nums);
        System.out.println("Maximum absolute sum: " + result);
    }
}
