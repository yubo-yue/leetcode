package leetcode;

public class L1349 {

    public int maxStudents(char[][] seats) {
        int max = 0;
        int m = seats.length, n = seats[0].length;

        for (int i = 0; i < 1 << n; i++) {
            max = Math.max(max, dp(seats, m - 1, i));
        }
        return max;
    }

    private int dp(char[][] seats, int row, int status) {
        return 0;
    }
}
