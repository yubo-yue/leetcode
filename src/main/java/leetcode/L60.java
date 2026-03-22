package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L60 {
    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        for (int i = 0; i < k - 1; i++) {
            nextPermutation(nums);
        }
        for (int i = 0; i < n; i++) {
            ans.append(nums[i]);
        }
        return ans.toString();
    }

    void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
