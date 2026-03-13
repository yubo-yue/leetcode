package leetcode;

import java.util.Arrays;
import java.util.List;

public class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        for (int j = 0; j < n; j++) {
            f[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }

    // generate test case
    public static void main(String[] args) {
        L120 solution = new L120();
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );
        int result = solution.minimumTotal(triangle);
        System.out.println("Minimum path sum: " + result);
    }
}
