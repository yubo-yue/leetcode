package leetcode;

public class L34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        int l = binarySearch(nums, target, true);
        int r = binarySearch(nums, target, false);

        return new int[]{l, r};
    }

    private int binarySearch(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length-1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L34 algo = new L34();

        int[] result = algo.searchRange(new int[] {5,7,7,8,8,10}, 10);
        System.out.println(result[0] + ", " + result[1]);
    }
}
