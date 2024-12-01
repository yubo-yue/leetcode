package demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class L239Test {

    @Test
    void maxSlidingWindow() {
        L239 algo = new L239();
        assertThat(algo.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).containsExactly(3, 3, 5, 5, 6, 7);
    }
}