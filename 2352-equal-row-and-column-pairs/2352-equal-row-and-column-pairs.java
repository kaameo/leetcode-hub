class Solution {
    public int equalPairs(int[][] grid) {
        // [[3,2,1],[1,7,6],[2,7,7]]
        // [[3,1,2],[2,7,7],[1,6,7]]

        int n = grid.length;
        int[][] rows = grid;
        int[][] cols = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cols[i][j] = rows[j][i];
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isSameArray(rows[i], cols[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static boolean isSameArray(int[] aArr, int[] bArr) {
        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] != bArr[i]) {
                return false;
            }
        }

        return true;
    }
    // time complexity O(n^3)
    // space complexity O(n^2), because n*n arrays
}
// n^3 < 8,000,000