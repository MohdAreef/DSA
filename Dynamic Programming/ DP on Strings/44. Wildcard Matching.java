Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
/*
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
*/

class Solution {
    public boolean match(int index1, int index2, String s1, String s2, int[][] dp) {
        // base conditions
        if (index1 < 0 && index2 >= 0) {
            return false;
        }
        if (index2 < 0 && index1 >= 0) {
            for (int k = index1; k >= 0; k--) {
                if (s1.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (index1 < 0 && index2 < 0)
            return true;

        if (dp[index1][index2] != -1)
            return dp[index1][index2] == 0 ? false : true;
        // explore
        if (s1.charAt(index1) == s2.charAt(index2) || s1.charAt(index1) == '?') {

            boolean b1 = match(index1 - 1, index2 - 1, s1, s2, dp);
            dp[index1][index2] = (b1 == true) ? 1 : 0;
            return b1;
        }
        if (s1.charAt(index1) == '*') {

            boolean b2 = match(index1 - 1, index2, s1, s2, dp) || match(index1, index2 - 1, s1, s2, dp);
            dp[index1][index2] = (b2 == true) ? 1 : 0;
            return b2;
        }
        dp[index1][index2] = 0;
        return false;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return match(n - 1, m - 1, p, s, dp);
    }
}
