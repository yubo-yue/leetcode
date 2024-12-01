package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L1207 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,2,1,1,3};
        L1207 solution = new L1207();
        System.out.println(solution.uniqueOccurrences(ints));
    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int a : arr) {
            counts.merge(a, 1, Integer::sum);
        }
        long p = counts.size();
        long r = counts.values().stream().distinct().count();
        System.out.printf("map size : %d, value size: %d\n", p, r);
        return r == p;
    }
}
