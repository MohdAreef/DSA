/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining 
elements.
*/
// it is similar to the Longest Common Subsequence problem , reverse the given string and find LCS of original and reversed string 

class Solution {
    public int longest(int index1, int index2, String s1, String s2, int[][] dp) {
        // base conditions
        if (index1 < 0 || index2 < 0)
            return 0;

        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        // explore
        int pick = 0;
        int nonpick = (int) -1e9;
        if (s1.charAt(index1) == s2.charAt(index2)) {
            pick = 1 + longest(index1 - 1, index2 - 1, s1, s2, dp);
        } else {
            nonpick = Math.max(longest(index1 - 1, index2, s1, s2, dp), longest(index1, index2 - 1, s1, s2, dp));
        }

        return dp[index1][index2] = Math.max(pick, nonpick);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        StringBuilder sb = new StringBuilder(s);

        String s2 = sb.reverse().toString();

        return longest(n - 1, n - 1, s, s2, dp);
    }
}
