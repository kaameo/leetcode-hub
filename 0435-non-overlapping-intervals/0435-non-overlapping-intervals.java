class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] arr : intervals) {
            System.out.println(Arrays.toString(arr));
        }

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
    }
    // time complexity O(n log n), because of sort
    // space complexity O(1)
}