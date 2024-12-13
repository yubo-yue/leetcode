package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class L345 {
    public String reverseVowels(String s) {
        //lote -> leto
        Stack<Character> vowels = new Stack<>();
        Set<Character> vowelSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.contains(Character.toLowerCase(s.charAt(i)))) {
                vowels.push(s.charAt(i));
            }
        }
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.contains(Character.toLowerCase(s.charAt(i)))) {
                buf.append(vowels.pop());
            } else {
                buf.append(s.charAt(i));
            }
        }
        return buf.toString();
    }

    public String reverseVowels1(String s) {
        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();
        while (l < r) {
            if (isVowel(arr[l]) && isVowel(arr[r])) {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
                continue;
            }
            if (!isVowel(arr[l])) l++;
            if (!isVowel(arr[r])) r++;
        }
        return new String(arr);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
