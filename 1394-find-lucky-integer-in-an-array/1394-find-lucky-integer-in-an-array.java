class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int answer = -1;

        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                answer = Math.max(answer, key);
            }
        }
        return answer;
    }
    // time complexity O(n)
    // space complexity O(n)
}