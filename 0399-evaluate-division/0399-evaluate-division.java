class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                answer[i] = -1.0;
            } else if (start.equals(end)) {
                answer[i] = 1.0;
            } else {
                answer[i] = dfs(graph, start, end, new HashSet<>(), 1.0);
            }
        }

        return answer;
    }

    private double dfs(
            Map<String, Map<String, Double>> graph,
            String curr,
            String target,
            Set<String> visited,
            double product) {
        if (curr.equals(target)) {
            return product;
        }

        visited.add(curr);

        for (String next : graph.get(curr).keySet()) {
            if (visited.contains(next)) {
                continue;
            }

            double result = dfs(
                    graph,
                    next,
                    target,
                    visited,
                    product * graph.get(curr).get(next));

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;

    }

}