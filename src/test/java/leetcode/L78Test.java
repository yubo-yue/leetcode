package leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class L78Test {
    private final L78 solution = new L78();

    @Test
    void minDistance_SameStrings_ReturnsZero() {
        assertEquals(0, solution.minDistance("horse", "horse"));
    }

    @Test
    void minDistance_DifferentStrings_ReturnsEditDistance() {
        assertEquals(3, solution.minDistance("horse", "ros"));
        assertEquals(5, solution.minDistance("intention", "execution"));
    }

    @Test
    void minDistance_EmptyStrings_ReturnsLength() {
        assertEquals(5, solution.minDistance("", "hello"));
        assertEquals(4, solution.minDistance("test", ""));
        assertEquals(0, solution.minDistance("", ""));
    }

    @Test
    void minDistance_SingleCharDifference_ReturnsOne() {
        assertEquals(1, solution.minDistance("cat", "cut"));
        assertEquals(1, solution.minDistance("hello", "hallo"));
    }
}