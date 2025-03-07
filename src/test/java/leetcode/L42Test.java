package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L42Test {

    @Test
    void trap() {
        L42 algo = new L42();
        int ans = algo.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(6, ans);
    }
}