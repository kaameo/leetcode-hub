class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sp = 0;
        int tp = 0;
        boolean answer = false;

        while (tp < tArr.length) {
            if (tArr[tp] == sArr[sp]) {
                sp++;
                tp++;
            } else {
                tp++;
            }

            if (sp >= sArr.length) {
                answer = true;
                break;
            }
        }

        return answer;
    }
    // time complexity O(m) m is t.length
    // space complexity O(n+m)
}