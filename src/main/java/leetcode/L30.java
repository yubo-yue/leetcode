package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordCount = words.length, wordLen = words[0].length(), strLen = s.length();

        for (int i = 0; i < wordLen; i++) {
            if (i + wordCount * wordLen > strLen) {
                break;
            }

            Map<String, Integer> differ = new HashMap<>();

            for (int j = 0; j < wordCount; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }

            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) differ.remove(word);
            }

            for (int start = i; start < strLen - wordCount * wordLen + 1; start += wordLen) {
                if (start != i) {
                    String word = s.substring(start + (wordCount - 1) * wordLen, start + wordCount * wordLen);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - wordLen, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    result.add(start);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L30 algo = new L30();
        List<Integer> result = algo.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        result.forEach(System.out::println);
    }
}
