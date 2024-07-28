
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the 
relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/

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
