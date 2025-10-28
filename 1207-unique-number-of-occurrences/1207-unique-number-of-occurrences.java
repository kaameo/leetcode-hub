class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        Set<Integer> set = new HashSet<>();
        for(int i : map.values()){
            set.add(i);
        }

        return map.keySet().size() == set.size();
    }
    // time complexity O(n), where n is arr.length
    // space complexity O(n), where n is arr.length
}