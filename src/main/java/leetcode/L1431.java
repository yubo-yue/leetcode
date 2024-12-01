package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(candies[i], maxCandies);
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies > maxCandies) {
                result.add(true);
            } else
                result.add(false);
        }
        return result;
    }
}
