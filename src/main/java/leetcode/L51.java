package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        int[] cols = new int[n]; // r -> cols[r] is column
        dfs(0, n, cols, used, result);

        return result;
    }

    private void dfs(int r, int n, int[] cols, boolean[] used, List<List<String>> result) {
        if (r == n) {
            result.add(convert(cols));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!used[c]) {
                used[c] = true;
                if (isValid(r, c, cols)) {
                    cols[r] = c;
                    dfs(r + 1, n, cols, used, result);
                    cols[r] = 0;
                }

                used[c] = false;
            }
        }
    }

    private boolean isValid(int r, int c, int[] cols) {
        for (int curR = 0; curR < r; curR++) {
            int curC = cols[curR];
            if ((curR + curC) == (r + c) || (curR - curC) == (r - c)) {
                return false;
            }

        }
        return true;

    }

    private List<String> convert(int[] cols) {
        List<String> ans = new ArrayList<>();
        for (int c : cols) {
            char[] chs = new char[cols.length];
            Arrays.fill(chs, '.');
            chs[c] = 'Q';
            ans.add(new String(chs));
        }
        return ans;
    }

    public static void main(String[] args) {
        L51 l = new L51();
        System.out.println(l.solveNQueens(4));
    }
}
