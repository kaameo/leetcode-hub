class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        Set<String> directed = new HashSet<>();

        for(int[] edge : connections){
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
            directed.add(a+","+b);
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        int changed = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next:graph.get(cur)){
                if(!visited[next]){
                    if(directed.contains(cur+","+next)){
                        changed++;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return changed;
    }
    // time complexity O(n)
    // space complexity O(n^2)
}