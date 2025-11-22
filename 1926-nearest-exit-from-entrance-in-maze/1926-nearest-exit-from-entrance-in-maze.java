class Solution {
    record Pair(int x, int y, int dist) {
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        boolean[][] visited = new boolean[n][m];
        visited[entrance[0]][entrance[1]] = true;

        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(entrance[0], entrance[1], 0));

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x() + dx[d];
                int ny = cur.y() + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (maze[nx][ny] == '+' || visited[nx][ny])
                    continue;

                visited[nx][ny] = true;

                if (isExit(nx, ny, n, m))
                    return cur.dist() + 1;

                queue.offer(new Pair(nx, ny, cur.dist() + 1));
            }
        }

        return -1;
    }

    private boolean isExit(int x, int y, int n, int m) {
        return x == 0 || y == 0 || x == n - 1 || y == m - 1;
    }
    // time complexity O(n * m)
    // space complexity O(n * m)
}