package leetcode;

public class L1049 {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] arr = new int[1001];
        Difference difference = new Difference(arr);

        for (int[] trip : trips) {
            difference.increment(trip[1], trip[2] - 1, trip[0]);
        }

        int[] result = difference.result();
        for (int passengers : result) {
            if (passengers > capacity) {
                return false;
            }
        }
        return true;
    }

    public static class Difference {
        int[] diff;

        public Difference(int[] arr) {
            diff = new int[arr.length];
            diff[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                diff[i] = arr[i] - arr[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            for (int i = 1; i < diff.length; i++) {
                diff[i] += diff[i - 1];
            }
            return diff;
        }
    }
}
