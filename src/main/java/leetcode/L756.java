package leetcode;

import java.util.*;

public class L756 {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String a : allowed) {
            String key = a.substring(0, 2);
            map.getOrDefault(key, new ArrayList<>()).add(a.substring(2));
        }
        return dfs(map, bottom, new StringBuffer(), 0);
    }

    private boolean dfs(Map<String, List<String>> map, String bottom, StringBuffer nextBottom, int pos) {
        if (pos == bottom.length() - 1) {
            bottom = nextBottom.toString();
            nextBottom = new StringBuffer();
            pos = 0;
        }

        if (bottom.length() == 1) {
            return true;
        }
        String key = bottom.substring(pos, pos + 2);
        if (map.containsKey(key)) {
            for (String val : map.get(key)) {
                nextBottom.append(val);
                if (dfs(map, bottom, nextBottom, pos + 1)) {
                    return true;
                }
                nextBottom.setLength(nextBottom.length() - 1);
            }
        }
        return false;
    }


}
