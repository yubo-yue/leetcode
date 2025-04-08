package leetcode;

import java.util.*;

public class L269 {
    static final int VISITING = 1, VISITED = 2;

    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> states = new HashMap<>();
    boolean valid = true;
    char[] order;
    int index;

    public String alienOrder(String[] words) {
        int n = words.length;

        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 1; i < n && valid; i++) {
            addEdges(words[i - 1], words[i]);
        }

        if (!valid) return "";

        order = new char[edges.size()];
        index = edges.size() - 1;
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!states.containsKey(u)) {
                dfs(u);
            }
        }
        if (!valid) return "";
        return new String(order);
    }

    private void dfs(char u) {
        states.put(u, VISITING);
        List<Character> adjacent = edges.get(u);
        for (char v : adjacent) {
            if (!states.containsKey(v)) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (states.get(v) == VISITING) {
                valid = false;
                return;
            }
        }
        states.put(u, VISITED);
        order[index--] = u;
    }

    private void addEdges(String before, String after) {
        int bLen = before.length(), aLen = after.length();
        int len = Math.min(bLen, aLen);

        int index = 0;
        while (index < len) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                break;
            }
            index++;
        }

        if (index == len && bLen > aLen) {
            valid = false;
        }
    }
}
