class Solution {
    public int pivotIndex(int[] nums) {
        // 0 1 2 3 4 5
        //  1  7  3  6  5  6
        //  1  8 11 17 21 27
        // 28 27 20 17 11  6

        int n = nums.length;

        int[] lSums = new int[n + 1];
        lSums[0] = 0;
        for (int i = 0; i < n; i++) {
            lSums[i + 1] = lSums[i] + nums[i];
        }

        int[] rSums = new int[n + 1];
        rSums[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            rSums[i] = rSums[i + 1] + nums[i];
        }
        
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(lSums[i] == rSums[i+1]){
                return i;
            }
        }
        return -1;
    }
    // time complexity O(n)
    // space complexity O(n)
}