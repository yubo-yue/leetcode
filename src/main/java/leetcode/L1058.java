package leetcode;

import java.util.Arrays;

public class L1058 {
    public String mininizeErrors(String[] prices, int target) {
        int n = prices.length;
        double[][] nums = new double[n][3];

        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            nums[i][0] = Double.parseDouble(prices[i]);
            nums[i][1] = nums[i][0] - Math.floor(nums[i][0]);
            nums[i][2] = Math.ceil(nums[i][0]) - nums[i][0];
            min += (int) Math.floor(nums[i][0]);
            max += (int) Math.ceil(nums[i][0]);
        }

        if (target < min || target > max) {
            return "-1";
        }

        int count = target - min;
        double result = 0.0;
        Arrays.sort(nums, (x, y) -> {
            if (Double.compare(x[2], y[2]) == 0) {
                return Double.compare(x[1], y[1]);
            } else {
                return Double.compare(x[2], y[2]);
            }
        });

        for (int i = 0; i < n; i++) {
            if (nums[i][1] == 0d) {
                continue;
            }

            if (count > 0) {
                result += nums[i][2];
                count--;
            } else {
                result += nums[i][1];
            }
        }

        return String.format("%.3f", result);
    }
}
