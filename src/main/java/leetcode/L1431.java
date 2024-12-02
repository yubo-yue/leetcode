package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int candy : candies) {
            if (candy > max)
                max = candy;
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
