package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L1768Test {
    @Test
    public void test() {
        L1768 instance = new L1768();
        String word1 = "abc";
        String word2 = "de";

        String result = instance.mergeAlternately(word1, word2);
        assertEquals("adbec", result);

    }

}