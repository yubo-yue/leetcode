package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L2189Test {
    @Test
    void name() {
        L2189 algo = new L2189();

        int r = algo.houseOfCards(16);

        assertEquals(2, r);

    }
}