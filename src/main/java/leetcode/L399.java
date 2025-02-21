package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind uf = new UnionFind(2 * equationsSize);
        int id = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String v1 = equation.get(0);
            String v2 = equation.get(1);
            if (!map.containsKey(v1)) {
                map.put(v1, id);
                id++;
            }
            if (!map.containsKey(v2)) {
                map.put(v2, id);
                id++;
            }

            uf.union(map.get(v1), map.get(v2), values[i]);

        }

        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String v1 = queries.get(i).get(0);
            String v2 = queries.get(i).get(1);
            Integer id1 = map.get(v1);
            Integer id2 = map.get(v2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = uf.isConnected(id1, id2);
            }
        }
        return res;
    }
}

class UnionFind {
    private int[] parent;
    private double[] weight;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
    }

    public void union(int p, int q, double value) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        parent[rootP] = rootQ;
        weight[rootP] = weight[q] * value / weight[p];
    }

    public int find(int x) {
        if (x != parent[x]) {
            int origin = parent[x];
            parent[x] = find(parent[x]);
            weight[x] = weight[x] * weight[origin];
        }
        return parent[x];
    }

    public double isConnected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return weight[p] / weight[q];
        } else {
            return -1.0d;
        }
    }
}
