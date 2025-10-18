class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }

        if (zeroCount >= 2) {
            return new int[nums.length];
        }

        int pNum = 1;
        int zeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                continue;
            }
            pNum *= nums[i];
        }

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(zeroCount >=1 && zeroIdx != i){
                continue;
            }
            answer[i] = pNum / (nums[i] == 0 ? 1 : nums[i]);
        }

        return answer;
    }
    // time complexity O(n)
    // space complexity O(n)
}