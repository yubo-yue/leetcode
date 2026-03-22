package leetcode;

public class L11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L11 l11 = new L11();
        System.out.println(l11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
