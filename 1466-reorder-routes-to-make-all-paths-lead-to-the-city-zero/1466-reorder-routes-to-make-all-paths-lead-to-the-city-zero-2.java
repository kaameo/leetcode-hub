// Solution withouit String Set
class Solution {
    public int minReorder(int n, int[][] connections) {
        // graph[node] = { {next, dir}, ... }
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // build graph
        for (int[] edge : connections) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(new int[]{b, 1}); // {x,1} should reverse order, 0 -> node
            graph.get(b).add(new int[]{a, 0}); // {x,0} correct order, 0 <- node
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        int changed = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int[] nextInfo : graph.get(cur)) {
                int next = nextInfo[0];
                int dir = nextInfo[1];

                if (!visited[next]) {
                    // if dir == 1, should reverse order
                    changed += dir;

                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return changed;
    }
}
