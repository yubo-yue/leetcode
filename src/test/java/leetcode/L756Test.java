package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class L756Test {

    @Test
    void pyramidTransition() {
        L756 algo = new L756();
        boolean r = algo.pyramidTransition("BCD", List.of("BCC", "CDE", "CEA", "FFF"));
        assertFalse(r);

    }

    @Test
    void testBitOps() {
        int a = 0;
        int r = (1 << a);
        System.out.println("1<<0:" + r);
    }


}