package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class L751Test {

    @Test
    void ipToCIDR() {
        L751 algo = new L751();
        List<String> r = algo.ipToCIDR("117.145.102.62", 8);
        for (String rr : r) {
            System.out.println(rr);
        }
        int x = 12;
        System.out.println(x & -x);
    }
}