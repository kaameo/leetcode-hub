class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            pQueue.offer(i);
        }

        for (int i = 0; i < k - 1; i++) {
            pQueue.remove();
        }
        return pQueue.peek();
    }
    // time complexity O(n log n), because I insert n elements into the priority queue
    // insertion time complexity of a priority queue is O(log n)
    // deletion time complexity of a priority queue is O(log n)
    // space complexity O(n), because the priority queue stores all elements
}