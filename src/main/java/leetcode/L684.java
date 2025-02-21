package leetcode;

import utils.UF;

public class L684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);

        for (int[] edge : edges) {
            int p = edge[0], q = edge[1];

            if (uf.connected(p, q)) {
                return edge;
            }

            uf.union(p, q);
        }

        return new int[]{0, 0};
    }
}
