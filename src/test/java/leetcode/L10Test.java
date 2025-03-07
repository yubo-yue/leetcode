package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L10Test {

    @Test
    void isMatch() {
        L10 algo = new L10();
        boolean r = algo.isMatch("aa", "a");
        assertFalse(r);
        r = algo.isMatch("aa", "a*");
        assertTrue(r);
        r = algo.isMatch("ab", ".*");
        assertTrue(r
        );
    }
}