class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
    // time complexity O(n)
    // space complexity O(1)
}
// [20,100,10,12,5,13]
// (2,3,5), because nums[2] == 10 < nums[3] == 12 < nums[5] == 13