package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L756 {

    public static void main(String[] args) {
        List<String> allowed = List.of("BCC", "CDE", "CEA", "FFF");
        String bottom = "BCD";
        L756 s = new L756();
        boolean r = s.pyramidTransition(bottom, allowed);
        System.out.println(r);

        Map<String, String> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();

    }


    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] T = new int[7][7];
        for (String a : allowed) {
            T[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');
        }

        int N = bottom.length() ;// N*N 的矩阵来表示
        int[][] A = new int[N][N];
        int t = 0;
        for (char c : bottom.toCharArray()) {
            A[N-1][t++] = c-'A';
        }
        return solve(A, T, N, 0);
    }

    /**
     *
     * @param A
     * @param T
     * @param N 1..N 对应N*N数组的0..N-1
     * @param i 一行内的下标， 从0到N..1
     * @return
     */
    private boolean solve(int[][] A, int[][] T, int N, int i) {
        if (N == 1 && i == 1) {
            return true;
        } else if (N == i) {
            return solve(A, T, N-1, 0);
        } else {
            int w = T[A[N][i]][A[N][i+1]];
            for (int b = 0; b <7; b++) {
                if (((w>>b) & 1) != 0) {
                    A[N-1][i]= b;
                    if (solve(A, T, N, i+1)) return true;
                }
            }
        }
        return false;
    }


}
