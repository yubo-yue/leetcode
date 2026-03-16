package leetcode;

public class L2526 {

    public int minCapacity(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            right = Math.max(right, weight);
        }
        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] <= capacity) {
                count++;
                i++;
            }
            if (count >= days) {
                return true;
            }
        }
        return false;
    }

    // generate test case
    public static void main(String[] args) {
        L2526 solution = new L2526();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int result = solution.minCapacity(weights, days);
        System.out.println("Minimum capacity to ship within " + days + " days: " + result);
    }
}
