package leetcode;

import java.util.*;

public class L1657 {
    public static void main(String[] args) {
        L1657 solution = new L1657();
        boolean r = solution.closeStrings("abc", "bac");
        System.out.println(r);
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        Set<Character> keys1 = map1.keySet();
        Set<Character> keys2 = map2.keySet();
        if (keys1.size() != keys2.size() || !keys1.containsAll(keys2)) {
            return false;
        }

        List<Integer> vals1 = map1.values().stream().sorted().toList();
        List<Integer> vals2 = map2.values().stream().sorted().toList();
        if (!vals1.equals(vals2)) {
            return false;
        }
        return true;
    }
}
