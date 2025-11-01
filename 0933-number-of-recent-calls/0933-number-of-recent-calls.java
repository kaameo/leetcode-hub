class RecentCounter {
    // Queue<Integer> queue = new ArrayList<>();
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while(queue.peek() <  t- 3000){
            queue.poll();
        }

        return queue.size();
    }
    // time complexity O(n)
    // space complexity O(n)
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */