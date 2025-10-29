class Solution {
    public boolean closeStrings(String word1, String word2) {
        // abc = a : 1 , b : 1, c : 1
        // bca = a : 1 , b : 1, c : 1

        // cabbba = a : 2 , b : 3, c : 1
        // abbccc = a : 1 , b : 2, c : 3

        // abbccd = a : 1 , b : 2, c : 2, d : 1
        // baadcd = a : 2 , b : 1, c : 1, d : 2

        if(word1.length() != word2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        for(char c : word1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for(char c : word2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        // compare keySet
        Set<Character> set1 = map1.keySet();
        Set<Character> set2 = map2.keySet();

        for(char c : set1){
            if(!set2.contains(c)) return false;
        }
        for(char c : set2){
            if(!set1.contains(c)) return false;
        }

        // compare the values list after sort
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());

        Collections.sort(list1);    Collections.sort(list2);

        for(int i = 0; i < list1.size(); i++){
            if(!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }

        return true;
    }
    // time complexity O(n log n), because sort algorithm
    // time complexity O(n + m) ~= O(n), where n == m
}