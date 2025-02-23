package leetcode;

import java.util.TreeSet;

public class L220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int v) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            Long ceiling = set.ceiling((long) cur - (long) v);
            if (ceiling != null && ceiling <= (long) cur + (long) v) {
                return true;
            }
            set.add((long) cur);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
