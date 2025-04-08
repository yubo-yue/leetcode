package leetcode;

import java.util.*;

public class L212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        StringBuffer track = new StringBuffer();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> wordSet = new HashSet<>();
        Collections.addAll(wordSet, words);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                track.append(board[i][j]);
                backtrack(board, i, j, track, visited, wordSet, ans);
                track.deleteCharAt(track.length() - 1);
                visited[i][j] = false;
            }
        }
        return ans;
    }

    private void backtrack(char[][] board, int i, int j, StringBuffer track, boolean[][] visited, Set<String> wordSet, List<String> ans) {
        if (track.length() > 10) {
            return;
        }

        if (wordSet.contains(track.toString())) {
            ans.add(track.toString());
            wordSet.remove(track.toString());
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int dx = i + dir[0];
            int dy = j + dir[1];
            if (dx < 0 || dx >= board.length || dy < 0 || dy >= board[0].length || visited[dx][dy]) {
                continue;
            }
            track.append(board[dx][dy]);
            visited[dx][dy] = true;
            backtrack(board, dx, dy, track, visited, wordSet, ans);
            visited[dx][dy] = false;
            track.deleteCharAt(track.length() - 1);
        }
    }
}
