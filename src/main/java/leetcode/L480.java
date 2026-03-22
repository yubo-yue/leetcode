package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class L480 {
    private TreeMap<Integer, Integer> left = new TreeMap<>(Comparator.reverseOrder()); // 大顶堆
    private TreeMap<Integer, Integer> right = new TreeMap<>(); // 小顶堆
    private int leftSize = 0, rightSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] medians = new double[n - k + 1];
        for (int i = 0; i < n; i++) {
            // 1. 添加新元素
            add(nums[i]);
            // 2. 移除旧元素
            if (i >= k) {
                remove(nums[i - k]);
            }

            // 3. 计算当前窗口的中位数
            if (i >= k - 1) {
                medians[i - k + 1] = getMedian();
            }
        }
        return medians;
    }

    void add(int num) {
        if (leftSize == 0 || num <= left.firstKey()) {
            left.merge(num, 1, Integer::sum);
            leftSize++;
        } else {
            right.merge(num, 1, Integer::sum);
            rightSize++;
        }
        balance();
    }

    void remove(int num) {
        if (num <= left.firstKey()) {
            left.merge(num, -1, Integer::sum);
            if (left.get(num) == 0) {
                left.remove(num);
            }
            leftSize--;
        } else {
            right.merge(num, -1, Integer::sum);
            if (right.get(num) == 0) {
                right.remove(num);
            }
            rightSize--;
        }
        balance();
    }

    void balance() {
        if (leftSize > rightSize + 1) {
            int num = left.firstKey();
            left.merge(num, -1, Integer::sum);
            if (left.get(num) == 0) {
                left.remove(num);
            }
            right.merge(num, 1, Integer::sum);
            leftSize--;
            rightSize++;
        } else if (rightSize > leftSize) {
            int num = right.firstKey();
            right.merge(num, -1, Integer::sum);
            if (right.get(num) == 0) {
                right.remove(num);
            }
            left.merge(num, 1, Integer::sum);
            rightSize--;
            leftSize++;
        }
    }

    double getMedian() {
        if (leftSize == rightSize) {
            return ((double) left.firstKey() + right.firstKey()) / 2;
        } else {
            return (double) left.firstKey();
        }
    }

    // generate test case
    public static void main(String[] args) {
        L480 solution = new L480();
        int[] nums = { 1,1,3,2,0,0 };
        int k = 3;
        double[] result = solution.medianSlidingWindow(nums, k);
        System.out.println("Medians of sliding windows: " + Arrays.toString(result));
    }

}
