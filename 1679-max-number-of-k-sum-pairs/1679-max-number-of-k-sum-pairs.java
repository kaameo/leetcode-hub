class Solution {
    public int maxOperations(int[] nums, int k) {
        int operation = 0;
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if(nums[l] + nums[r] > k){
                r--;
            }else if(nums[l] + nums[r] < k){
                l++;
            }else {
                operation++;
                l++;
                r--;
            }
        }

        return operation;
    }
    // n^2 = 10,000,000,000 -> can't n^2 
    // k, nums[i] = 1,000,000,000
}