package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class L68Test {

    @Test
    void fullJustify() {
        L68 algo = new L68();
        List<String> result = algo.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        for (String r : result) {
            System.out.println(r);
        }
    }
}