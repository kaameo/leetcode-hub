class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0;
        int zero = 0;
        int one = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                zero++;
            } else {
                one++;
            }

            while (zero > k && one > k) {
                if (s.charAt(left) == '0') {
                    zero--;
                } else {
                    one--;
                }

                left++;
            }
            answer += (right - left + 1);
        }
        return answer;
    }
    // time complexity O(n)
    // space complexity O(1)
}