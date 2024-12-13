package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class L151Test {

    @Test
    void reverseWords() {
        L151 instance = new L151();
        String s = "the sky is blue";
        String r = instance.reverseWords(s);
        System.out.println(s + " : " + r);
    }
}