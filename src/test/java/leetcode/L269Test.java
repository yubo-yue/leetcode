package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L269Test {

    @Test
    void alienOrder() {
        L269 aglo = new L269();
        String r = aglo.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println(r);
    }

    @Test
    void alienOrder_01() {
        L269_01 algo = new L269_01();
        String r = algo.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println(r);
    }
}