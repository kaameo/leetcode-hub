class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int window_sum = 0;
        for (int i = 0; i < k; i++) {
            window_sum += nums[i];
        }
        int max_sum = window_sum;

        for (int i = k; i < n; i++) {
            window_sum = window_sum - nums[i - k] + nums[i];
            max_sum = Math.max(max_sum, window_sum);
        }

        return (double) max_sum / k;
    }
    // time complexity O(n)
    // space complexity O(1)
}
// nums[i] <= 10,000
// max <= 10^4 * 10^5 == 1,000,000,000 < Integer.MAX_VALUE
// > 0.00001