package leetcode;

import java.util.*;

public class L380 {

    public static class RandomizedSet {
        private List<Integer> nums;
        private Map<Integer, Integer> valToIndex;
        private Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            valToIndex = new HashMap<>();
            random = new Random();

        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            nums.add(val);
            valToIndex.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }

            int index = valToIndex.get(val);
            int last = nums.get(nums.size() - 1);
            valToIndex.put(last, index);
            nums.set(index, last);

            nums.remove(nums.size() - 1);
            valToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            int randomeIdx = random.nextInt(nums.size());
            return nums.get(randomeIdx);
        }
    }
}
