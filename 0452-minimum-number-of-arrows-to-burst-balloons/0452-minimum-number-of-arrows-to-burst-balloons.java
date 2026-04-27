class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] arr : points) {
            System.out.println(Arrays.toString(arr));
        }

        int cnt = 1;
        int arrowX = points[0][1];

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > arrowX) {
                cnt++;
                arrowX = points[i][1];
            }
        }

        return cnt;
    }
    // time complexity O(n log n), because of sort
    // space complexity O(1)
}