package leetcode;

import org.junit.jupiter.api.Test;

class L344Test {

    @Test
    void increasingTriple() {
        L344 instance = new L344();
        boolean result = instance.increasingTriple(new int[]{2, 1, 5, 0, 4, 6});
        System.out.println(result);
    }
}