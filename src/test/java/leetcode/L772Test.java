package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L772Test {

    @Test
    void calculate() {
        L772 algo = new L772();
        Assertions.assertThat(algo.calculate("1+ 2*(2+4)")).isEqualTo(13);
        Assertions.assertThat(algo.calculate("1+3*((90-8)/2-40)")).isEqualTo(4);
    }
}