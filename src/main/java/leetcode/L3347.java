package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class L3347 {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> diff = new TreeMap<>(); //有序
        for (int x : nums) {
            count.merge(x, 1, Integer::sum); // cnt[x]++
            diff.putIfAbsent(x, 0); // 把 x 插入 diff，以保证下面能遍历到 x
            // 把 [x-k, x+k] 中的每个整数的出现次数都加一
            diff.merge(x - k, 1, Integer::sum); // diff[x-k]++
            diff.merge(x + k + 1, -1, Integer::sum); // diff[x+k+1]--
        }

        int ans = 0;
        int sumD = 0;
        //离散化，只扫描关键跳变的点， TreeMap有序<c
        for (Map.Entry<Integer, Integer> e : diff.entrySet()) {
            sumD += e.getValue();
            ans = Math.max(ans, Math.min(sumD, count.getOrDefault(e.getKey(), 0) + numOperations));
        }
        return ans;
    }

    //generate test case
    public static void main(String[] args) {
        L3347 solution = new L3347();
        int[] nums = {1, 2, 4};
        int k = 1;
        int numOperations = 2;
        int result = solution.maxFrequency(nums, k, numOperations);
        System.out.println("Maximum frequency after operations: " + result);
    }
}
