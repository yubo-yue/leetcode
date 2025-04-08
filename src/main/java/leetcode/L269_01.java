package leetcode;

import java.util.*;

public class L269_01 {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
                inDegree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String pre = words[i];
            String after = words[i + 1];
            int minLen = Math.min(pre.length(), after.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = pre.charAt(j);
                char c2 = after.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
                if (j == minLen - 1 && pre.length() > after.length()) return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);

            for (char neighbor : graph.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (result.length() != inDegree.size()) {
            return "";
        }
        return result.toString();
    }
}
