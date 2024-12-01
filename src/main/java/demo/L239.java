package demo;

import utils.MonotonicQueue;

import java.util.ArrayList;
import java.util.List;

public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                result.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();

    }
}
