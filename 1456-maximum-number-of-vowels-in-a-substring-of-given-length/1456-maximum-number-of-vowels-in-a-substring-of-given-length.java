class Solution {

    // public static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int winVowels = 0;
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                winVowels++;
            }
        }
        int maxVowels = winVowels;
        for (int i = k; i < s.length(); i++) {
            if(isVowel(s.charAt(i-k))){
                winVowels--;
            }
            if(isVowel(s.charAt(i))){
                winVowels++;
            }

            maxVowels = Math.max(maxVowels, winVowels);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;

        return false;
    }
    // time complexity O(n)
    // space complexity O(1)
}
// s.length < 100,000 
// n*m ~= n^2 < 10,000,000,000