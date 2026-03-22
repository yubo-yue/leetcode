package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L399 {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        // 构建图：每个变量是一个节点，每个方程是一个有向边，权重是除法结果
        for (int i = 0; i < equations.length; i++) {
            String u = equations[i][0];
            String v = equations[i][1];
            double weight = values[i];
            graph.computeIfAbsent(u, k->new HashMap<>()).put(v, weight);
            graph.computeIfAbsent(v, k->new HashMap<>()).put(u, 1.0 / weight);
        }

        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String start = queries[i][0];
            String end = queries[i][1];
            if (!graph.containsKey(start)||!graph.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                results[i] = dfs(graph, start, end, new HashSet<>());
            }
        }
        return results;
    }
    double dfs(Map<String, Map<String, Double>> graph, String current, String target, Set<String> visited) {
        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);

        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            double weight = entry.getValue();
            if (next.equals(target)) {
                return weight;
            }
            if (!visited.contains(next)) {
                double result = dfs(graph, next, target, visited);
                if (result != -1.0) {
                    return weight * result;
                }
            }
        }
        return -1.0;
    }
}
