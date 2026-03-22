package leetcode;

public class L31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n-2;
        while (i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = n-1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }

    void swap(int[] nums, int i , int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    // generate test case
    public static void main(String[] args) {
        L31 solution = new L31();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println("Next permutation: " + java.util.Arrays.toString(nums));
    }

}
