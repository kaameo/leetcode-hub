class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n;
        int zeroCnt = 0;

        for (right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeroCnt++;
            }

            if (zeroCnt > 1) {
                if (nums[left] == 0) {
                    zeroCnt--;
                }
                left++;
            }
        }
        return right - left - 1;
    }
    // time complexity O(n)
    // space complexity O(1)
}