package leetcode;

import java.util.HashSet;
import java.util.Set;

public class L52 {
    public int totalQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        int result = backtrack(n, 0, columns, diagonals1, diagonals2);
        return result;
    }

    private int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (n == row) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) continue;
            int d1 = row - i;
            if (diagonals1.contains(d1)) continue;
            int d2 = row + i;
            if (diagonals2.contains(d2)) continue;

            columns.add(i);
            diagonals1.add(d1);
            diagonals2.add(d2);
            backtrack(n, row+1, columns, diagonals1, diagonals2);
            diagonals2.remove(d2);
            diagonals1.remove(d1);
            columns.remove(i);
        }
        return count;
    }


}
