package leetcode;

import java.util.Arrays;

public class L2343 {

    public int[] answerQueries(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int strLen = nums[0].length();
        int[] answer = new int[m];

        // 1. 将查询按 trim 排序，同时保留原始序号以便填充结果
        Integer[] qIdx = new Integer[m];
        for (int i = 0; i < m; i++)
            qIdx[i] = i;
        Arrays.sort(qIdx, (a, b) -> Integer.compare(queries[a][1], queries[b][1]));

        // 2. 初始化下标数组。这个数组的顺序将随着基数排序不断演变。
        // currentOrder[i] 表示当前排名第 i 的元素在原始 nums 中的下标。
        int[] currentOrder = new int[n];
        for (int i = 0; i < n; i++)
            currentOrder[i] = i;

        int currentTrim = 0;
        // 3. 开始基数排序流程：从右往左第 1 位到第 strLen 位
        for (int i = 0; i < m; i++) {
            int qIdxOriginal = qIdx[i];
            int targetTrim = queries[qIdxOriginal][1];
            int k = queries[qIdxOriginal][0];

            // 增量排序：如果当前 trim 不够，就继续往左看一位，进行稳定排序
            while (currentTrim < targetTrim) {
                currentTrim++;
                int charPos = strLen - currentTrim;
                currentOrder = countingSort(nums, currentOrder, charPos);
            }

            // 当前的 currentOrder 已经是按 targetTrim 位排序好的稳定序列
            answer[qIdxOriginal] = currentOrder[k - 1];
        }

        return answer;
    }

    /**
     * 稳定的计数排序
     * 
     * @param nums     原始字符串数组
     * @param oldOrder 上一轮排序后的下标顺序
     * @param pos      当前要排序的字符位置（从左往右计）
     * @return 这一轮排序后的新下标顺序
     */
    private int[] countingSort(String[] nums, int[] oldOrder, int pos) {
        int n = nums.length;
        int[] newOrder = new int[n];
        int[] count = new int[10]; // 数字 0-9

        // 统计当前位每个数字出现的频率
        for (int idx : oldOrder) {
            int digit = nums[idx].charAt(pos) - '0';
            count[digit]++;
        }

        // 计算前缀和，确定每个数字在 newOrder 中的结束位置
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 倒序遍历 oldOrder 以保持稳定性
        // 注意：因为 oldOrder 已经包含了之前位的排序信息，
        // 我们从后往前填入 newOrder 才能确保在当前位数字相同时，
        // 维持上一轮的相对顺序。
        for (int i = n - 1; i >= 0; i--) {
            int idx = oldOrder[i];
            int digit = nums[idx].charAt(pos) - '0';
            newOrder[count[digit] - 1] = idx;
            count[digit]--;
        }

        return newOrder;
    }
}
