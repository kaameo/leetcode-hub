class SmallestInfiniteSet {

    private int i;
    private PriorityQueue<Integer> pQueue;

    public SmallestInfiniteSet() {
        i = 1;
        pQueue = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if(!pQueue.isEmpty()){
            return pQueue.poll();
        }
        return i++;
    }
    
    public void addBack(int num) {
        if(i <= num || pQueue.contains(num))
            return;
        
        pQueue.offer(num);
    }
    // time complexity O(n), because PrioriQueue.contains() runs in O(n)
    // space complexity O(n), because of priority queue
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */