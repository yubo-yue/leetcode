package leetcode;

public class L755 {
    private static int[] dirs = {-1, 1};

    public int[] pourWater(int[] heights, int volume, int k) {
        int n = heights.length;

        while (volume > 0) {
            int dropIndex = k;

            for (int dir : dirs) {
                for (int i = k + dir; i >= 0 && i < n && heights[i] <= heights[i - dir]; i += dir) {
                    if (heights[i] <= heights[i - dir]) {
                        dropIndex = i;
                    }
                }
                if (dropIndex != k) {
                    break; //找到了下落的点
                }
            }
            heights[dropIndex]++;

            volume--;

        }
        return heights;
    }
}
