package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class L755Test {

    @Test
    void pourWater() {
        L755 algo = new L755();
        int[] r = algo.pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1}, 5, 2);
        System.out.println(Arrays.toString(r));

    }
}