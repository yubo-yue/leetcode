package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L238Test {

    @Test
    void productExceptSelf() {
        L238 instance = new L238();

        int[] ans = instance.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int a : ans) {
            System.out.println(a);
        }
    }
}