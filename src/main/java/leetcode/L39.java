package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;
        backtrack(track, trackSum, candidates, 0, target, ans);
        return ans;
    }

    private void backtrack(LinkedList<Integer> track, int trackSum, int[] choices, int start, int target, List<List<Integer>> ans) {
        if (trackSum == target) {
            ans.add(new ArrayList<>(track));
            return;
        }

        if (trackSum > target) {
            return;
        }

        for (int i = start; i < choices.length; i++) {
            track.add(choices[i]);
            trackSum += choices[i];
            backtrack(track, trackSum, choices, i, target, ans);
            trackSum -= choices[i];
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        L39 algo = new L39();
        List<List<Integer>> ans = algo.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(ans);
    }
}
