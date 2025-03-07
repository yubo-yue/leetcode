package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int OPEN = 0, CLOSE = 1;
        List<int[]> events = new ArrayList<>();
        for (List<Interval> emp : schedule) {
            for (Interval inv : emp) {
                events.add(new int[]{inv.start, OPEN});
                events.add(new int[]{inv.end, CLOSE});
            }
        }

        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<Interval> ans = new ArrayList<>();
        int prev = -1, balance = 0;
        for (int[] event : events) {
            if (balance == 0 && prev >= 0) {
                ans.add(new Interval(prev, event[0]));

            }
            balance += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }

        return ans;
    }
}
