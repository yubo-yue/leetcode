package leetcode;

import java.util.*;

public class L2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int j : nums1) {
            map1.put(j, j);
        }
        for (int j : nums2) {
            map2.put(j, j);
        }
        Set<Integer> exist1 = new HashSet<>();
        for (int j : nums1) {
            if (!map2.containsKey(j)) {
                exist1.add(j);
            }
        }
        Set<Integer> exist2 = new HashSet<>();

        for (int j : nums2) {
            if (!map1.containsKey(j)) {
                exist2.add(j);
            }
        }
        return List.of(new ArrayList<>(exist1), new ArrayList<>(exist2));
    }
}
