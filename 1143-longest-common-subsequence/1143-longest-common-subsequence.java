class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        if (n < m) {
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
            int t = m;
            m = n;
            n = t;
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prevDiag = 0;
            char c1 = text1.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                int saved = dp[j];
                char c2 = text2.charAt(j - 1);

                if (c1 == c2) {
                    dp[j] = prevDiag + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDiag = saved;
            }
        }
        return dp[n];
    }
    // time complexity O(n * m)
    // space complexity O(n)
}