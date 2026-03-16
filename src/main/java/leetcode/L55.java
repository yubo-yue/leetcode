package leetcode;

public class L55 {
    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxReach) {
                maxReach = Math.max(maxReach, i+nums[i]);
                if (maxReach >= n-1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L55 solution = new L55();
        int[] nums = {2, 3, 1, 1, 4};
        boolean result = solution.canJump(nums);
        System.out.println("Can jump to the end: " + result);
    }
}
