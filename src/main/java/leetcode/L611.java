package leetcode;
import java.util.Arrays;

public class L611 {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    // generate test case
    public static void main(String[] args) {
        L611 solution = new L611();
        int[] nums = { 2, 2, 3, 4 };
        int result = solution.triangleNumber(nums);
        System.out.println("Number of valid triangles: " + result);
    }

}
