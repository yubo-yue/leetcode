package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new LinkedList<Integer>(), nums, new boolean[nums.length], ans);
        return ans;
    }

    private void backtrack(LinkedList<Integer> track, int[] choices, boolean[] used, List<List<Integer>> ans) {
        if (track.size() == choices.length) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < choices.length; i++) {
            if (!used[i]) {
                used[i] = true;
                track.add(choices[i]);
                backtrack(track, choices, used, ans);
                track.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        L46 algo = new L46();
        List<List<Integer>> result = algo.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
