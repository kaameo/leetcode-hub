class Solution {
    public String predictPartyVictory(String senate) {
        // RRRDDDD
        // rq = 0 1 2 7 8  9 15
        // dq = 3 4 5 6 13

        int n = senate.length();
        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }

        while (!radiants.isEmpty() && !dires.isEmpty()) {
            int r = radiants.poll();
            int d = dires.poll();

            if (r < d)
                radiants.add(r + n);
            else
                dires.add(d + n);
        }

        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
    // time complexity O(n)
    // space complexity O(n)
}