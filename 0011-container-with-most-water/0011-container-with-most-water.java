class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = 0;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            area = Math.max(area, w * h);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
    // n^2 = 10,000,000,000
    // time complexity O(n)
    // time complexity O(1)
}