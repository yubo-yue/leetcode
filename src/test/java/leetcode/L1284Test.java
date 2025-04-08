package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L1284Test {

    @Test
    void minFlips() {
        L1284 algo = new L1284();

        int r = algo.minFlips(new int[][]{{0, 0}, {0, 1}});
        assertEquals(3, r);
    }
}