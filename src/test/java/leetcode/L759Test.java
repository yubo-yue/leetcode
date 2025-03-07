package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class L759Test {

    @Test
    void employeeFreeTime() {
        L759 algo = new L759();

        List<Interval> ans = algo.employeeFreeTime(List.of(List.of(new Interval(1, 2), new Interval(5, 6)), List.of(new Interval(1, 3)), List.of(new Interval(4, 10))));
        ans.forEach(interval -> {
            System.out.printf("interval start=%d, end=%d%n", interval.start, interval.end);
        });
    }
}