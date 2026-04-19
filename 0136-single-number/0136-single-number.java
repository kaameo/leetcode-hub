class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }
        // System.out.println(result);

        return result;
    }
    // time complexity O(n)
    // space complexity O(1)
}
// nums.length <= 30000

// 2, 2 ,1
// 10, 10, 01
// 10, 00, 01

// 3, 1 ,3 ,1 ,5
// 011, 001, 011, 001, 101
// 011, 010, 001, 000, 101

// 4, 1, 2, 1, 2
// 100, 001, 010, 001, 010
// 100, 101, 111, 110, 101
