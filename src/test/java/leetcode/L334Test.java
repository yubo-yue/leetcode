package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L334Test {
    private L334 instance;

    @BeforeEach
    void setup() {
        instance = new L334();
    }

    @Test
    void increasingTriplet() {
        int[] a = {2, 1, 5, 3, 4, 6};
        boolean r = instance.increasingTriplet(a);
        assertTrue(r);

    }
}