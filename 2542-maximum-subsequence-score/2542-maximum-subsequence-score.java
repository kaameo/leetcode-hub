class Solution {
    record Pair(int min, int sum) {}

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums2[i], nums1[i]);
        }

        Arrays.sort(arr, (a, b) -> b.min() - a.min());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i].sum();
            minHeap.offer(arr[i].sum());

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * arr[i].min());
            }
        }

        return maxScore;
    }
    // time complexity O(n log n)
    // space complexity O(n log k)
}
