package leetcode;

import java.util.TreeMap;

public class L3013 {
    private int sizeL = 0;
    private int sumL = 0;
    private TreeMap<Integer, Integer> L = new TreeMap<>();
    private TreeMap<Integer, Integer> R = new TreeMap<>();

    private long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int m = k - 2; // 每次选一个点，最多能覆盖 k-1 个点，所以需要 m 轮覆盖剩余点

        // 第一个可能得窗口从i1=1开始, right is 1+dist
        for (int i = 2; i <= Math.min(n - 1, 1 + dist); i++) {
            add(nums[i], m);
        }

        long minCost = (long) nums[0] + nums[1] + sumL;

        // 从 i1=2 开始，每次移动窗口，更新 minCost
        for (int i1 = 2; i1 < n - m; i1++) {
            // 移动窗口：移除 i1-1，添加 i1+dist
            remove(nums[i1], m);
            int newRight = i1 + dist;
            if (newRight < n) {
                add(nums[newRight], m);
            }
            // 计算以当前i1为起点的总代价
            minCost = Math.min(minCost, (long) nums[0] + nums[i1] + sumL);
        }
        return minCost;
    }

    // 添加元素到窗口，并维护 L 和 R 的平衡
    void add(int x, int m) {
        if (m == 0) {
            return;
        }

        if (sizeL < m) {
            L.put(x, L.getOrDefault(x, 0) + 1);
            sizeL++;
            sumL += x;
        } else {
            int maxL = L.lastKey();
            if (x < maxL) {
                removeFromMap(L, maxL);
                sumL -= maxL;
                L.put(x, L.getOrDefault(x, 0) + 1);
                sumL += x;
                R.put(maxL, R.getOrDefault(maxL, 0) + 1);
            } else {
                R.put(x, R.getOrDefault(x, 0) + 1);
            }
        }
    }

    // 从窗口中移除元素，并维护 L 和 R 的平衡
    void remove(int x, int m) {
        if (m == 0) {
            return;
        }

        if (L.containsKey(x)) {
            removeFromMap(L, x);
            sizeL--;
            sumL -= x;

            if (!R.isEmpty()) {
                int minR = R.firstKey();
                removeFromMap(R, minR);
                L.put(minR, L.getOrDefault(minR, 0) + 1);
                sizeL++;
                sumL += minR;
            }
        } else {
            removeFromMap(R, x);
        }
    }

    // 辅助方法：从 TreeMap 中移除一个元素，处
    void removeFromMap(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
    

    // generate test case
    public static void main(String[] args) {
        L3013 solution = new L3013();
        int[] nums = { 1, 3, 2, 6, 4, 2 };
        int k = 3;
        int dist = 3;
        long result = solution.minimumCost(nums, k, dist);
        System.out.println("Minimum cost: " + result);
    }
}
