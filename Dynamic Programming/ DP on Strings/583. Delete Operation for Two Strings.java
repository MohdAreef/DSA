/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.
*/

class Solution {
    // tabulation method
    public int commomSubStringlen(String s1, String s2) {
        int i = 0, j = 0;
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (i = 0; i < (m + 1); i++) {
            dp[i][0] = 0;
        }
        for (i = 0; i < (n + 1); i++) {
            dp[0][i] = 0;
        }
        int maxi = 0;
        for (i = 1; i < (m + 1); i++) {
            for (j = 1; j < (n + 1); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxi = Math.max(maxi, dp[i][j]);
            }
        }
        return maxi;

    }

    public int minDistance(String word1, String word2) {
        int commonsubstrlen = commomSubStringlen(word1, word2);
        System.out.println(commonsubstrlen);

        int r1 = word1.length() - commonsubstrlen;
        int r2 = word2.length() - commonsubstrlen;

        return r1 + r2;

    }
}
