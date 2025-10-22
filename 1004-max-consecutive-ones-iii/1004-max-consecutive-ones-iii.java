class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r=0;
        int zeroCnt = 0;

        for (r = 0; r < n; r++) {
            if (nums[r] == 0) {
                zeroCnt++;
            }

            if (zeroCnt > k) {
                if (nums[l] == 0) {
                    zeroCnt--;
                }
                l++;
            }
        }
        return r - l;
    }
    // time complexity O(n)
    // space complexity O(1)
}
// n, k <= 100,000
// n * k <= 10,000,000,000