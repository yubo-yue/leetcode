package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int windowLen = wordLen * words.length;

        Map<String, Integer> targetCnt = new HashMap<>();
        for (String w : words) {
            targetCnt.merge(w, 1, Integer::sum);
        }

        List<Integer> ans = new ArrayList<>();
        for (int start = 0; start < wordLen; start++) {
            Map<String, Integer> cnt = new HashMap<>();
            int overload = 0;
            for (int right = start + wordLen; right <= s.length(); right += wordLen) {
                String inWord = s.substring(right - wordLen, right);
                if (cnt.getOrDefault(inWord, 0).equals(targetCnt.getOrDefault(inWord, 0))) {
                    overload++;
                }
                cnt.merge(inWord, 1, Integer::sum);
                int left = right - windowLen;
                if (left < 0) {
                    continue;
                }

                if (overload == 0) {
                    ans.add(left);
                }
                String outWord = s.substring(left, left + wordLen);
                cnt.merge(outWord, -1, Integer::sum);
                if (cnt.get(outWord).equals(targetCnt.getOrDefault(outWord, 0))) {
                    overload--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        L30 algo = new L30();
        List<Integer> result = algo.findSubstring("ooobarfoothefoobarman", new String[]{"foo", "bar"});
        result.forEach(System.out::println);
    }
}
