class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        Arrays.sort(potions);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            if ((long) spell * potions[m - 1] < success) {
                result[i] = 0;
                continue;
            }

            long minPotion = (success + spell - 1L) / spell;

            int idx = lowerBound(potions, minPotion);

            result[i] = m - idx;
        }
        return result;
    }

    private int lowerBound(int[] arr, long target) {
        int l = 0;
        int r = arr.length - 1;
        int ans = arr.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    // time complexity O(m log m + n log m)
    // space complexity O(1)
}
