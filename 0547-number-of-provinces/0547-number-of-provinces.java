class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;

                Deque<Integer> deque = new ArrayDeque<>();
                deque.push(i);
                visited[i] = true;

                while (!deque.isEmpty()) {
                    int node = deque.pop();

                    for (int j = 0; j < n; j++) {
                        if (isConnected[node][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            deque.push(j);
                        }
                    }
                }
            }
        }
        return provinces;
    }
    // time complexity O(n^2)
    // space complexity O(n)
}