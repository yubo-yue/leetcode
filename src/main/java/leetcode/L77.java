package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new LinkedList<>(), 1, n, k, ans);
        return ans;
    }

    private void backtrack(LinkedList<Integer> track, int start, int n, int k, List<List<Integer>> ans) {
        if (track.size() == k) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(track, i+1, n, k, ans);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        L77 algo = new L77();
        List<List<Integer>> ans = algo.combine(4, 2);
        System.out.println(ans);
    }
}
