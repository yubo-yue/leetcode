package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L1071Test {

    @Test
    void gcdOfStrings() {
        String a = "ABCABC";
        String b = "ABC";
        String r = new L1071().gcdOfStrings(a, b);
        assertEquals("ABC", r);
    }

    @Test
    void test01() {
        String a = "ABABAB";
        String b = "ABAB";
        String r = new L1071().gcdOfStrings(a, b);
        assertEquals("AB", r);
    }
}