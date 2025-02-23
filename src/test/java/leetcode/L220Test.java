package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L220Test {

    @Test
    void containsNearbyAlmostDuplicate() {
        L220 algo = new L220();
        boolean r = algo.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
        assertTrue(r);
        r = algo.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 1, 0);
        assertFalse(r);
    }
}