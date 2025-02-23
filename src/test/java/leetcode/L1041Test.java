package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L1041Test {

    @Test
    void isRobotBounded() {
        L1041 algo = new L1041();
        boolean r = algo.isRobotBounded("GGLLGG");
        assertTrue(r);
        r = algo.isRobotBounded("GG");
        assertFalse(r);
        r = algo.isRobotBounded("GL");
        assertTrue(r);
    }
}