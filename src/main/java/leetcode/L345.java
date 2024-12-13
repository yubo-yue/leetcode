package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class L345 {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (isVowel(chars[left]) && isVowel(chars[right])) {
                swap(chars, left, right);

                left++;
                right--;
                continue;
            }
            if (!isVowel(chars[left])) {
                left++;
            }

            if (!isVowel(chars[right])) {
                right--;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char t = chars[left];
        chars[left] = chars[right];
        chars[right] = t;
    }

    boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }

        return false;
    }


}
