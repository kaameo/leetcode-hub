class Solution {

    public static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int winVowels = 0;
        for(int i = 0; i < k; i++){
            if(VOWELS.contains(s.charAt(i))){
                winVowels++;
            }
        }
        int maxVowels = winVowels;
        for (int i = k; i < s.length(); i++) {
            if(VOWELS.contains(s.charAt(i-k))){
                winVowels--;
            }
            if(VOWELS.contains(s.charAt(i))){
                winVowels++;
            }

            if(maxVowels < winVowels){
                maxVowels = winVowels;
            }
        }

        return maxVowels;
    }
    // time complexity O(n)
    // space complexity O(1)
}
// s.length < 100,000 
// n*m ~= n^2 < 10,000,000,000
