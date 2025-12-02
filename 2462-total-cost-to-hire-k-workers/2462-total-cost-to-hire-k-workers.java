class Solution {
    record Worker(int cost, int idx) {
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        Comparator<Worker> cmp = Comparator
                .comparingInt((Worker w) -> w.cost)
                .thenComparingInt(w -> w.idx);

        PriorityQueue<Worker> leftHeap = new PriorityQueue<>(cmp);
        PriorityQueue<Worker> rightHeap = new PriorityQueue<>(cmp);

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(new Worker(costs[left], right));
            left++;
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(new Worker(costs[right], right));
            right--;
        }

        long totalCost = 0;
        for (int i = 0; i < k; i++) {
            // Pick from left if right empty OR left has smaller or equal cost
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty()
                    && leftHeap.peek().cost() <= rightHeap.peek().cost())) {
                Worker picked = leftHeap.poll();
                totalCost += picked.cost();

                if (left <= right) {
                    leftHeap.offer(new Worker(costs[left], left));
                    left++;
                }
            } else {
                Worker picked = rightHeap.poll();
                totalCost += picked.cost();

                if (left <= right) {
                    rightHeap.offer(new Worker(costs[right], right));
                    right--;
                }

            }
        }

        return totalCost;
    }
    // time complexity O(n log n)
    // time complexity O(n)
}