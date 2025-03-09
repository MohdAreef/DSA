
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the 
relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/
// MEMOIZATION
class Solution {
    public int longest(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0)
            return 0;
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + longest(ind1 - 1, ind2 - 1, s1, s2, dp);
        }
        return dp[ind1][ind2] = Math.max(longest(ind1 - 1, ind2, s1, s2, dp), longest(ind1, ind2 - 1, s1, s2, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return longest(m - 1, n - 1, text1, text2, dp);

    }
}
// TABULATION
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < (m + 1); i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < (n + 1); i++) {
            dp[i][0] = 0;
        }

        for (int index1 = 1; index1 < (n + 1); index1++) {
            for (int index2 = 1; index2 < (m + 1); index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
// SPACE OPTIMIZATION
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m + 1];
        for (int i = 0; i < (m + 1); i++) {
            prev[i] = 0;
        }
        for (int index1 = 1; index1 < (n + 1); index1++) {
            int[] curr = new int[m + 1];
            curr[0] = 0;
            for (int index2 = 1; index2 < (m + 1); index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    curr[index2] = 1 + prev[index2 - 1];
                } else {
                    curr[index2] = Math.max(prev[index2], curr[index2 - 1]);
                }
            }
            prev = curr;
            curr = null;
        }
        return prev[m];
    }
}
