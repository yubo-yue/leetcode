package utils;

/**
 * 实现一个差分数值的帮助类
 */
public class Difference {
    private int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }


    public int[] result() {
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }

        return result;
    }

    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }
}
