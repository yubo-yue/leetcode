package leetcode;

public class L153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        L153 algo = new L153();
        int minVal = algo.findMin(new int[]{3,4,5,1,2});
        System.out.println(minVal);
    }
}
