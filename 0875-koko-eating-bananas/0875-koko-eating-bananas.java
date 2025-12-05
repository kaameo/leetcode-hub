class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }

        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canEat(piles, mid, h)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean canEat(int[] piles, int k, int h) {
        long hours = 0;

        for(int p : piles){
            hours += (p + k - 1) / k;
            if(hours > h) return false;
        }
        return true;
    }
    // time complexity O(n log n)
    // space complexity O(1)
}

// n <= 1_000_000_000 -> i have to solve this problem in O(log n) complexity
//

// piles = {3, 6, 7, 11}
// if k = 6, she can eat a time at once on the left indices -> 2
// but she cant eat 2 time at a index banans, *2 -> 4
// -> sum == 6 < 8