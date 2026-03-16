package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L2858 {
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>(); 
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], 0}); // original direction
            adj[edge[1]].add(new int[]{edge[0], 1}); // reversed direction
        }
        int[] ans = new int[n];
        ans[0] = dfs(0, -1, adj);
        reroot(0, -1, adj, ans);
        return ans;
    }

    private int dfs(int u, int parent, List<int[]>[] adj) {
        int reversals = 0;
        for (int[] neighbor : adj[u]) {
            int v = neighbor[0];
            int cost = neighbor[1];
            if (v != parent) {
                reversals += cost + dfs(v, u, adj);
            }
        }
        return reversals;
    }

    private void reroot(int u, int parent, List<int[]>[] adj, int[] ans) {
        for (int[] neighbor : adj[u]) {
            int v = neighbor[0];
            int cost = neighbor[1];
            if (v != parent) {
                ans[v] = ans[u] + (cost == 0 ? 1 : -1);
                reroot(v, u, adj, ans);
            }
        }
    }
}
