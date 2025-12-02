class Solution {
    // 직관적 풀이
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int l = 0;
        int r = n - 1;

        
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < candidates && l <= r; i++) {
            left.offer(costs[l++]);
        }

        for (int i = 0; i < candidates && l <= r; i++) {
            right.offer(costs[r--]);
        }

        long totalCost = 0;
        while(k-- > 0){
            int first = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            int second = right.isEmpty() ? Integer.MAX_VALUE : right.peek();
            if(first <= second){
                totalCost += left.poll();
                if (l <= r) {
                    left.offer(costs[l++]);
                }
            }else{
                totalCost += right.poll();
                if (l <= r) {
                    right.offer(costs[r--]);
                }
            }
        }
        return totalCost;
    }
}
