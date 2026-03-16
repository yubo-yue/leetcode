package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L834 {
    private List<Integer>[] adj;
    private int[] count; // count[i] is the number of nodes in the subtree rooted at i
    private int[] ans;
    private int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        this.adj = new ArrayList[n];
        this.count = new int[n];
        this.ans = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfs(0, -1);
        reroot(0, -1);

        return ans;
    }

    void dfs(int u, int p) {
        count[u] = 1;
        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u);
                count[u] += count[v];
                ans[u] += ans[v] + count[v]; 
            }
        }
    }

    void reroot(int u, int p) {
        for (int v : adj[u]) {
            if (v != p) {
                ans[v] = ans[u] - count[v] + (n - count[v]);
                reroot(v, u);
            }
        }
    }

    // generate test case
    public static void main(String[] args) {
        L834 solution = new L834();
        int n = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
        int[] result = solution.sumOfDistancesInTree(n, edges);
        System.out.print("Sum of distances in tree: ");
        for (int distance : result) {
            System.out.print(distance + " ");
        }
    }
}
