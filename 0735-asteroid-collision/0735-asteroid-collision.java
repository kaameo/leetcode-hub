class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : asteroids) {
            boolean destroyed = false;

            while (!deque.isEmpty() && deque.peekLast() > 0 && i < 0) {
                int top = deque.peekLast();
                if (Math.abs(top) < Math.abs(i)) {
                    deque.pollLast();
                    continue;
                } else if (Math.abs(top) == Math.abs(i)) {
                    deque.pollLast();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                deque.offerLast(i);
            }
        }

        int n = deque.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = deque.pollFirst();
        }

        return ans;
    }
    // time complexity O(n^2)
    // space complexity O(n), because Deque
}