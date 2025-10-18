class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        for (int num : nums) {
            if (num != 0)
                nums[nonZeroIdx++] = num;
        }
        
        for(int i = nonZeroIdx; i< nums.length; i++){
            nums[i] = 0;
        }
    }
    // time complexity O(n)
    // time complexity O(1)
}