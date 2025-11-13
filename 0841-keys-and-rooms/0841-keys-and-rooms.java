class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();

        deque.push(0);
        visited[0] = true;

        while(!deque.isEmpty()){
            int room = deque.pop();

            for(int key: rooms.get(room)){
                if(!visited[key]){
                    visited[key] = true;
                    deque.push(key);
                }
            }
        }

        // check visited all rooms
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
    }
    // time complexity O(n)
    // space complexity O(n)
}