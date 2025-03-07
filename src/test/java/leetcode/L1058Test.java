package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L1058Test {

    @Test
    void mininizeErrors() {
        L1058 algo = new L1058();

        String r = algo.mininizeErrors(new String[]{"0.700", "2.800", "4.900"}, 8);
        assertEquals("1.000", r);
    }
}