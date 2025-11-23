class Solution {
    record Pair(int x, int y, int t) {}

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Deque<Pair> queue = new ArrayDeque<>();
        int freshOranges = 0;
        int maxTime = 0;

        // Find all initial rotten oranges and count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    // Add all initial rotten oranges to the queue at time 0
                    queue.offer(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges initially, the time is 0.
        if (freshOranges == 0) {
            return 0;
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            maxTime = cur.t();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x() + dx[d];
                int ny = cur.y() + dy[d];

                // Check boundary conditions
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                // Check if the neighbor is a fresh orange (value 1)
                if (grid[nx][ny] == 1) {
                    // This fresh orange is now rotten
                    grid[nx][ny] = 2;
                    freshOranges--;

                    // Enqueue the newly rotten orange with time t+1
                    queue.offer(new Pair(nx, ny, cur.t() + 1));
                }
            }
        }
        // If freshOranges is 0, all oranges rotted, return maxTime.
        // If freshOranges is > 0, some were unreachable, return -1.
        return freshOranges == 0 ? maxTime : -1;
    }
    // time complexity O(n * m)
    // space complexity O(n * m)
}