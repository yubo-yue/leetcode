package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(0, nums, ans, path, used);
        return ans;
    }

    private void dfs(int start, int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] used) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                dfs(start + 1, nums, ans, path, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    //generate test case
    public static void main(String[] args) {
        L46 solution = new L46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println("Permutations of " + java.util.Arrays.toString(nums) + ": " + result);
    }
}
