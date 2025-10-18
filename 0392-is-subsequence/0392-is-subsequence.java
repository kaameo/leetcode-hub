class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int sp = 0;
        int tp = 0;

        while(sp < s.length() && tp < t.length()){
            if(s.charAt(sp) == t.charAt(tp)){
                sp++;
            }

            tp++;
        }

        return sp == s.length();
    }
    // time complexity O(m), where m == t.length()
    // space complexity O(1)
}