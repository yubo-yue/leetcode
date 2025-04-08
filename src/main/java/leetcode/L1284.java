package leetcode;

import java.util.*;

public class L1284 {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {0, 0}};

    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int start = encode(mat, m, n), step = 0; // initial state
        if (start == 0) {
            return step;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[][] cur = decode(queue.poll(), m, n);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        convert(cur, m, n, i, j);
                        int xCur = encode(cur, m, n);
                        if (xCur == 0) {
                            return step;
                        }
                        if (!visited.contains(xCur)) {
                            visited.add(xCur);
                            queue.offer(xCur);
                        }
                        convert(cur, m, n, i, j);
                    }
                }
            }
        }
        return -1;
    }

    private void convert(int[][] mat, int m, int n, int i, int j) {
        for (int k = 0; k < 5; k++) {
            int nx = i + dirs[k][0], ny = j + dirs[k][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                mat[nx][ny] ^= 1;
            }
        }
    }

    private int encode(int[][] mat, int m, int n) {
        int x = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x = x * 2 + mat[i][j];
            }
        }
        return x;
    }

    private int[][] decode(int x, int m, int n) {
        int[][] mat = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                mat[i][j] = x & 1;
                x >>= 1;
            }
        }
        return mat;
    }
}
