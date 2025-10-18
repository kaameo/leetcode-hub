class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int idx1 = 0;
        int idx2 = 0;

        int length = word1.length() + word2.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            if(i % 2 == 0 && idx1 < word1.length()) { 
                sb.append(char1[idx1++]);
            }
            if(i % 2 != 0 && idx2 < word2.length()) { 
                sb.append(char2[idx2++]);
            }
        }

        for(; idx1 < word1.length(); idx1++){
            sb.append(char1[idx1]);
        }
        for(; idx2 < word2.length(); idx2++){
            sb.append(char2[idx2]);
        }

        return sb.toString();
    }
    // time complexity O(n + m)
    // space complexity O(n + m)
}