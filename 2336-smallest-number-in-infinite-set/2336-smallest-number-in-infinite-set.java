class SmallestInfiniteSet {

    int i;
    PriorityQueue<Integer> pQueue;
    Set<Integer> set;

    public SmallestInfiniteSet() {
        this.i = 1;
        this.pQueue = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if(!this.pQueue.isEmpty()){
            return pQueue.poll();
        }
        return this.i++;
    }
    
    public void addBack(int num) {
        if(this.i <= num || pQueue.contains(num))
            return;
        
        this.pQueue.offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */