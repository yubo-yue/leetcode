package leetcode;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

class L1431Test {

    @Test
    void kidsWithCandies() {
        L1431 instance = new L1431();
        List<Boolean> result = instance.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        Assertions.assertThat(result).contains(true, false);
    }
}